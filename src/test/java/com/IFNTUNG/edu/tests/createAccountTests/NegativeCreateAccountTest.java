package com.IFNTUNG.edu.tests.createAccountTests;

import com.IFNTUNG.edu.application.pages.HomePage;
import com.IFNTUNG.edu.runners.BaseTest;
import com.IFNTUNG.edu.utils.CsvDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * This class contains user's automated steps for creating the new account with the invalid data.
 *
 * @author Vira Harasymiv
 */
public class NegativeCreateAccountTest extends BaseTest {

    @Test(priority = 1, dataProvider = "csvReader",dataProviderClass = CsvDataProviders.class)
    public void negativeCreateAccountTest(Map<String,String> testData) {
        String number = testData.get("number");
        String firstName = testData.get("firstName");
        String lastName = testData.get("lastName");
        String birthDay = testData.get("birthDay");
        String fixLength = testData.get("fixLength");
        String company = testData.get("company");
        String streetAddress = testData.get("streetAddress");
        String postCode = testData.get("postCode");
        String city = testData.get("city");
        String state = testData.get("state");
        String country = testData.get("country");
        String telephoneNumber = testData.get("telephoneNumber");
        String password = testData.get("password");
        String message = testData.get("message");
        String description = testData.get("description");

        log.info("Starting Negative Create Account Test #" + number + " for " + description);
        log.info("Starting Create Account Test with invalid data");

        String actualMessage = new HomePage(driver, log)
                .openPage()
                .getHeaderComponent()
                .clickOnMyAccountMenu()
                .clickOnContinueButton()
                .selectAnyRadioButton()
                .enterUserFirstAndLastName(firstName, lastName)
                .enterUserBirthDay(birthDay)
                .enterUserEmail(Integer.parseInt(fixLength))
                .enterCompanyName(company)
                .enterStreetAddressAndPostCode(streetAddress, postCode)
                .enterUserCityAndState(city, state)
                .selectCountry(country)
                .enterTelephoneNumber(telephoneNumber)
                .checkNewsLetterCheckBox()
                .createPassword(password)
                .submitEnteredInformationWithInValidDate()
                .getAlertText();
        Assert.assertTrue(actualMessage.trim().contains(message), "Actual message is "+ actualMessage + ", but must be " + message);
    }
}

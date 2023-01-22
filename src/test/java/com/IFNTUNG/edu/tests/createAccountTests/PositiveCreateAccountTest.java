package com.IFNTUNG.edu.tests.createAccountTests;

import com.IFNTUNG.edu.application.pages.AccountSuccessPage;
import com.IFNTUNG.edu.application.pages.HomePage;
import com.IFNTUNG.edu.runners.BaseTest;
import com.IFNTUNG.edu.utils.ConfigReader;
import com.IFNTUNG.edu.utils.TestDataReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class contains user's automated steps for creating the new account with the valid data.
 *
 * @author Vira Harasymiv
 */
public class PositiveCreateAccountTest extends BaseTest {
    private static final String EXPECTED_URL = ConfigReader.get().getAccountSuccessPageUrl();
    private static final String FIRST_NAME = TestDataReader.get().getUserName();
    private static final String LAST_NAME = TestDataReader.get().getUserLastName();
    private static final String BIRTHDAY = TestDataReader.get().getUserBirthDay();
    private static final String FIX_LENGTH = TestDataReader.get().getFixLength();
    private static final String COMPANY = TestDataReader.get().getUserCompany();
    private static final String STREET_ADDRESS = TestDataReader.get().getUserStreet();
    private static final String POST_CODE = TestDataReader.get().getUserPostCode();
    private static final String CITY = TestDataReader.get().getUserCity();
    private static final String STATE = TestDataReader.get().getUserState();
    private static final String COUNTRY = TestDataReader.get().getUserCountry();
    private static final String TELEPHONE_NUMBER = TestDataReader.get().getTelephoneNumber();
    private static final String PASSWORD = TestDataReader.get().getPassword();
    private static final String SUCCESS_MESSAGE = TestDataReader.get().getSuccessMessage();

    @Test
    public void createNewAccountTest() {
        log.info("Starting Create Account Test with valid data");
        AccountSuccessPage accountSuccessPage = new HomePage(driver, log)
                .openPage()
                .getHeaderComponent()
                .clickOnMyAccountMenu()
                .clickOnContinueButton()
                .clickMaleRadioButton()
                .enterUserFirstAndLastName(FIRST_NAME,LAST_NAME)
                .enterUserBirthDay(BIRTHDAY)
                .enterUserEmail(FIX_LENGTH)
                .enterCompanyName(COMPANY)
                .enterStreetAddressAndPostCode(STREET_ADDRESS, POST_CODE)
                .enterUserCityAndState(CITY, STATE)
                .selectCountry(COUNTRY)
                .enterTelephoneNumber(TELEPHONE_NUMBER)
                .checkNewsLetterCheckBox()
                .createPassword(PASSWORD)
                .submitEnteredInformationWithValidDate();
       String actualMessage = accountSuccessPage.getActualMessage(SUCCESS_MESSAGE);
       String actualUrl = accountSuccessPage.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualMessage.contains(SUCCESS_MESSAGE));
        softAssert.assertTrue(actualUrl.contains(EXPECTED_URL));
        softAssert.assertAll();
    }
}

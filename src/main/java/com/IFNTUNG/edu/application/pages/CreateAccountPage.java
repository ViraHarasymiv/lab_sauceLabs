package com.IFNTUNG.edu.application.pages;

import com.IFNTUNG.edu.application.locators.createAccountPageLocators.CreateAccountPageLocators;
import com.IFNTUNG.edu.utils.StringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateAccountPage extends BasePage {
    private By radioButton = CreateAccountPageLocators.RADIO_BUTTON.getPath();
    private By maleRadioButton = CreateAccountPageLocators.MALE_RADIO_BUTTON.getPath();
    private By firstNameField = CreateAccountPageLocators.FIRST_NAME_FIELD.getPath();
    private By lastNameField = CreateAccountPageLocators.LAST_NAME_FIELD.getPath();
    private By dataPicker = CreateAccountPageLocators.DATAPICKER.getPath();
    private By emailField = CreateAccountPageLocators.EMAIL_FIELD.getPath();
    private By companyNameField = CreateAccountPageLocators.COMPANY_NAME_FIELD.getPath();
    private By streetAddressField = CreateAccountPageLocators.STREET_ADDRESS_FIELD.getPath();
    private By postCodeField = CreateAccountPageLocators.POST_CODE_FIELD.getPath();
    private By cityField = CreateAccountPageLocators.CITY_FIELD.getPath();
    private By stateField = CreateAccountPageLocators.STATE_FIELD.getPath();
    private By selectCountryMenu = CreateAccountPageLocators.SELECT_COUNTRY_MENU.getPath();
    private By telephoneNumberField = CreateAccountPageLocators.TELEPHONE_NUMBER.getPath();
    private By newsletterCheckbox = CreateAccountPageLocators.NEWS_LETTER_CHECKBOX.getPath();
    private By passwordField = CreateAccountPageLocators.PASSWORD_FIELD.getPath();
    private By passwordConfirmationField = CreateAccountPageLocators.PASSWORD_FIELD_CONFIRMATION.getPath();
    private By submitButton = CreateAccountPageLocators.SUBMIT_BUTTON.getPath();

    public CreateAccountPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get the Radio Button list and check any one button
     */
    public CreateAccountPage selectAnyRadioButton() {
        log.info("Check any Radio Button");
        List<WebElement> radioButtons = findAll(radioButton);
        radioButtons.stream().findFirst().get().click();
        return this;
    }

    /**
     * Click on the Male radio button
     */
    public CreateAccountPage clickMaleRadioButton() {
    log.info("Click the Male radio button");
    click(maleRadioButton);
    return this;
    }

    /**
     * Verify that only one Radio Button is checked. If all Radio Buttons are checked,
     * return false
     */
    public boolean isOneRadioButtonChecked() {
        log.info("Verifying that only one Radio Button is checked");
        List<WebElement> radioButtons = findAll(radioButton);
        radioButtons.get(0).click();
        radioButtons.get(1).click();
        if ((radioButtons.get(0).isSelected() && radioButtons.get(1).isSelected()) ||
                (!radioButtons.get(0).isSelected() && !radioButtons.get(1).isSelected())) {
            return false;
        }
        return true;
    }

    /**
     * Type the user's First and Last Name
     */
    public CreateAccountPage enterUserFirstAndLastName(String firstUserName, String lastName) {
        log.info("enter the user's First and Last Name");
        type(firstUserName, firstNameField);
        type(lastName, lastNameField);
        return this;
    }

    /**
     * Type the user's birthday
     */
    public CreateAccountPage enterUserBirthDay(String birthDay) {
        selectDate(birthDay, dataPicker);
        return this;
    }

    /**
     * Type the user's email
     */
    public CreateAccountPage enterUserEmail(String fix_length) {
        String email = StringUtils.generateRandomEmail(Integer.parseInt(fix_length));
        type(email, emailField);
        return this;
    }

    /**
     * Type the user's company
     */
    public CreateAccountPage enterCompanyName(String company) {
        type(company, companyNameField);
        return this;
    }

    /**
     * Type the user's street address and the post code
     */
    public CreateAccountPage enterStreetAddressAndPostCode(String streetAddress, String postCode) {
        type(streetAddress, streetAddressField);
        type(postCode, postCodeField);
        return this;
    }

    /**
     * Type the user's city and state
     */
    public CreateAccountPage enterUserCityAndState(String city, String state) {
        type(city, cityField);
        type(state, stateField);
        return this;
    }

    /**
     * Select the user's country
     */
    public CreateAccountPage selectCountry(String country) {
        WebElement dropdownElement = find(selectCountryMenu);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(country);
        return this;
    }

    /**
     * Type the user's city and state
     */
    public CreateAccountPage enterTelephoneNumber(String telephoneNumber) {
        type(telephoneNumber, telephoneNumberField);
        return this;
    }

    /**
     * Check the News Letter checkbox
     */
    public CreateAccountPage checkNewsLetterCheckBox() {
        click(newsletterCheckbox);
        return this;
    }

    /**
     * Create and confirm new password
     */
    public CreateAccountPage createPassword(String password) {
        type(password, passwordField);
        type(password, passwordConfirmationField);
        return this;
    }

    /**
     * Submit entered user's information with valid data
     */
    public AccountSuccessPage submitEnteredInformationWithValidDate() {
        click(submitButton);
        return new AccountSuccessPage(driver, log);
    }

    /**
     * Submit entered user's information with invalid data
     */
    public CreateAccountPage submitEnteredInformationWithInValidDate() {
        click(submitButton);
        return this;
    }

    /** Switch to alert and get it's message */
    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert says: " + alertText);
        return alertText;
    }

}



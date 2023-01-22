package com.IFNTUNG.edu.application.locators.createAccountPageLocators;

import org.openqa.selenium.By;

public enum CreateAccountPageLocators {
    RADIO_BUTTON(By.xpath("//input[@type='radio']")),
    MALE_RADIO_BUTTON(By.xpath("//input[@value='m']")),
    FIRST_NAME_FIELD(By.xpath("//input[@name='firstname']")),
    LAST_NAME_FIELD(By.xpath("//input[@name='lastname']")),
    DATAPICKER(By.xpath("//input[@class='hasDatepicker']")),
    EMAIL_FIELD(By.xpath("//input[@name='email_address']")),
    COMPANY_NAME_FIELD(By.xpath("//input[@name='company']")),
    STREET_ADDRESS_FIELD(By.xpath("//input[@name='street_address']")),
    POST_CODE_FIELD(By.xpath("//input[@name='postcode']")),
    CITY_FIELD(By.xpath("//input[@name='city']")),
    STATE_FIELD(By.xpath("//input[@name='state']")),
    SELECT_COUNTRY_MENU(By.xpath("//select[@name='country']")),
    TELEPHONE_NUMBER(By.xpath("//input[@name='telephone']")),
    NEWS_LETTER_CHECKBOX(By.xpath("//input[@name='newsletter']")),
    PASSWORD_FIELD(By.xpath("//input[@name='password']")),
    PASSWORD_FIELD_CONFIRMATION(By.xpath("//input[@name='confirmation']")),
    SUBMIT_BUTTON(By.xpath("//span[contains(text(), 'Continue')]"));

    private final By path;

    CreateAccountPageLocators(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}

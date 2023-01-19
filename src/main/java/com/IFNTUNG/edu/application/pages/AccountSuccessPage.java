package com.IFNTUNG.edu.application.pages;

import com.IFNTUNG.edu.application.locators.accountSuccesLocators.AccountSuccessLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AccountSuccessPage extends BasePage {
    private By actualMessage = AccountSuccessLocators.ACTUAL_MESSAGE.getPath();

    public AccountSuccessPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get the message about successful user's registration
     */
    public String getActualMessage(String message) {
        return getText(actualMessage, message);
    }
}

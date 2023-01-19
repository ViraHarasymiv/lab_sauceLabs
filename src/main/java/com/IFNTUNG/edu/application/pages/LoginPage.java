package com.IFNTUNG.edu.application.pages;

import com.IFNTUNG.edu.application.components.headerComponent.HeaderComponent;
import com.IFNTUNG.edu.application.locators.loginPageLocators.LoginPageLocators;;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private HeaderComponent headerComponent;
    private By continueButton = LoginPageLocators.CONTINUE_BUTTON.getPath();

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        headerComponent = new HeaderComponent(driver, log);
    }

    /**
     * Open Create Account Page by clicking on the Continue button
     */
    public CreateAccountPage clickOnContinueButton() {
        click(continueButton);
        return new CreateAccountPage(driver, log);
    }
}

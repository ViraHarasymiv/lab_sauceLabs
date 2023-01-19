package com.IFNTUNG.edu.application.components.headerComponent;

import com.IFNTUNG.edu.application.locators.headerComponentLocators.HeaderComponentLocators;
import com.IFNTUNG.edu.application.pages.BasePage;
import com.IFNTUNG.edu.application.pages.LoginPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {
    private By myAccountMenu = HeaderComponentLocators.MY_ACCOUNT_MENU.getPath();

    public HeaderComponent(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open LoginPage by clicking on the My Account Menu
     */
    public LoginPage clickOnMyAccountMenu() {
        log.info("Clicking on the My Account Menu on the Home Page");
        click(myAccountMenu);
        return new LoginPage(driver, log);
    }
}

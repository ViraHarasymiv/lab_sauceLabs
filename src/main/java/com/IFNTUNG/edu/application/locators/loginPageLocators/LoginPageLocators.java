package com.IFNTUNG.edu.application.locators.loginPageLocators;

import org.openqa.selenium.By;

public enum LoginPageLocators {
    CONTINUE_BUTTON(By.xpath("//span[contains(text(), 'Continue')]"));

    private final By path;

    LoginPageLocators(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}

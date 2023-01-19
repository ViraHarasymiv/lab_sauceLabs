package com.IFNTUNG.edu.application.locators.accountSuccesLocators;

import org.openqa.selenium.By;

public enum AccountSuccessLocators {
    ACTUAL_MESSAGE(By.xpath("//h1"));

    private final By path;

    AccountSuccessLocators(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}

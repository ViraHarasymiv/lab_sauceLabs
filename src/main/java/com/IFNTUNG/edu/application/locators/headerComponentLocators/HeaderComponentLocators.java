package com.IFNTUNG.edu.application.locators.headerComponentLocators;

import org.openqa.selenium.By;

public enum HeaderComponentLocators {
    MY_ACCOUNT_MENU(By.xpath("//span[contains(text(), 'My Account')]"));

    private final By path;

    HeaderComponentLocators(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}

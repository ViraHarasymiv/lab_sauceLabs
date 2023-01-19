package com.IFNTUNG.edu.application.pages;

import com.IFNTUNG.edu.application.components.headerComponent.HeaderComponent;
import com.IFNTUNG.edu.utils.ConfigReader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final String PAGE_URL = ConfigReader.get().getHomePageUrl();
    private HeaderComponent headerComponent;

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
        headerComponent = new HeaderComponent(driver, log);
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    /**
     * Open HomePage with it's url
     */
    public HomePage openPage() {
        log.info("Opening page: " + PAGE_URL);
        openUrl(PAGE_URL);
        log.info("Page opened!");
        return this;
    }
}

package com.IFNTUNG.edu.runners;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;


public class SauceLabsFactory {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;
    private String platform;
    private Logger log;

    public SauceLabsFactory(String browser, Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public SauceLabsFactory(String browser, String platform, Logger log) {
        this.browser = browser.toLowerCase();
        this.platform = platform;
        this.log = log;
    }

    public WebDriver createDriver() {
        log.info("Creating SauceLabs instance for: " + browser + " on " + platform);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("platformName", platform);
        Map<String, Object> sauceOptions = new HashMap<>();
        if(platform.contains("Windows")){
            sauceOptions.put("screenResolution", "1920x1080");
        } else{
            sauceOptions.put("screenResolution", "1920x1440");
        }
        capabilities.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://oauth-vira.harasymiv-5fe59:06579d23-fed1-4e51-84da-bb2151536b7c@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.set(new RemoteWebDriver(url, capabilities));

        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        return driver.get();
    }
}

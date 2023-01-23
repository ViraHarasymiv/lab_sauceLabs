package com.IFNTUNG.edu.runners;

import com.IFNTUNG.edu.utils.SauceLabsDataReader;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;


public class SauceLabsFactory implements SauceOnDemandAuthenticationProvider {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;
    private String platform;
    private String sauceTestName;
    private Logger log;
    private ThreadLocal<String>sessionId = new ThreadLocal<>();

    private static String USER_NAME = SauceLabsDataReader.get().getSauceLabsUserName();
    private static String ACCESS_KEY = SauceLabsDataReader.get().getSauceLabsAccessKey();

    private static final SauceOnDemandAuthentication AUTHENTICATION = new SauceOnDemandAuthentication(USER_NAME, ACCESS_KEY);

    public SauceLabsFactory(String browser, String platform, Logger log, String sauceTestName) {
        this.browser = browser.toLowerCase();
        this.platform = platform;
        this.sauceTestName = sauceTestName;
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

        sauceOptions.put("name",sauceTestName);
        capabilities.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://" + AUTHENTICATION.getUsername()
                    + ":" + AUTHENTICATION.getAccessKey() + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.set(new RemoteWebDriver(url, capabilities));
        sessionId.set( ((RemoteWebDriver)driver.get()).getSessionId().toString());

        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        return driver.get();
    }

    @Override
    public SauceOnDemandAuthentication getAuthentication() {
        return AUTHENTICATION;
    }
    public String getSessionId(){
        return sessionId.get();
    }
}

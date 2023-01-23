package com.IFNTUNG.edu.runners;
import com.IFNTUNG.edu.utils.SauceLabsTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners({SauceLabsTestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    @Parameters({ "browser", "environment", "platform"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, @Optional("local") String environment,  @Optional("Windows 10") String platform, ITestContext ctx) {
        log = LogManager.getLogger(ctx.getCurrentXmlTest().getSuite().getName());
        ctx.setAttribute("sauce",false);
        switch (environment) {

            case "grid":
                driver = new GridFactory(browser, log).createDriver();
                break;

            case "sauce":
                ctx.setAttribute("sauce",true);
                String sauceTestName = ctx.getName() + " | " + method.getName() + " | " + browser + " | " + platform;
                SauceLabsFactory factory = new SauceLabsFactory(browser, platform, log, sauceTestName);
                driver = factory.createDriver();
                ctx.setAttribute("sessionId",factory.getSessionId());
                break;

            default:
                driver = new BrowserDriverFactory(browser, log).createDriver();
                break;
        }

        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        driver.quit();
    }
}
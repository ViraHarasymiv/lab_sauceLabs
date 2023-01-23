# Lab 2: Running tests on SauceLabs

The target website is [BPB PUBLICATIONS](http://practice.bpbonline.com/index.php).

[SAUCE JAVA LIBRARIES](https://github.com/saucelabs/sauce-java) for TestNG are used to mark a Sauce Job as passed/failed, based on the test result; to obtain the Sauce Session Id, to provide SauceOnDemandAuthentication class, which handles the user name and access key

Automated test sample: positive test case for the creating new account. It is run on **Google Chrome (platform - Windows 10)**, **Firefox(platform - Windows 8)**, **Safari (platform - macOS 12)**, **MicrosoftEdge(platform - Windows 11)**.

## To run tests on SauceLabs you should:

1. Create the new account in [SAUCELABS](https://saucelabs.com/) in order to try it free

2. Create RemoteWebDriver using the DesiredCapabilities class to set browserName, browserVersion,platformName in the **SauceLabsFactory class**. [PLATFORM CONFIGURATOR](https://saucelabs.com/platform/platform-configurator#/) is used to choose the appropriate browser name and the platform name

3. Add the "sauce" environment to the **BaseTest class** and create a new object of the SauceLabsFactory class

4. Create testNG.xml file with browser and platform parameters.

5. See your results in the **"Test Results"** section.


package com.IFNTUNG.edu.utils;

import com.saucelabs.saucerest.SauceREST;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class SauceLabsTestListener extends TestListenerAdapter {
    private boolean sauce = false;
    private String sessionId;
    private SauceREST sauceREST;
    private String userName = SauceLabsDataReader.get().getSauceLabsUserName();
    private String accesKey = SauceLabsDataReader.get().getSauceLabsAccessKey();

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        if (sauce) {
            sauceREST.jobPassed(sessionId);
        }
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        if (sauce) {
            sauceREST.jobFailed(sessionId);
            //Improve error message
            Throwable throwable = tr.getThrowable();
            String message = throwable.getMessage();
            StackTraceElement [] stackTraceElements = throwable.getStackTrace();
            String link = "SauseLabs' test case link: https://app.eu-central-1.saucelabs.com/tests/" + sessionId;
            String sauceTestName = tr.getTestContext().getName() + " | " + tr.getName();
            String errorMessage = sauceTestName + "\n" + link + "\n" + message;
            Throwable errorThrowable = new Throwable(errorMessage, throwable);
            errorThrowable.setStackTrace(stackTraceElements);
            tr.setThrowable(errorThrowable);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        sauce = ((boolean) result.getTestContext().getAttribute("sauce"));
        if (sauce) {
            this.sessionId = (String) result.getTestContext().getAttribute("sessionId");
            this.sauceREST = new SauceREST(userName, accesKey);
        }

    }
}


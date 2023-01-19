package com.IFNTUNG.edu.tests.radioButtonsTest;

import com.IFNTUNG.edu.application.pages.HomePage;
import com.IFNTUNG.edu.runners.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void checkRadioButtons(){
    Boolean isOneRadioButtonChecked = new HomePage(driver,log)
                .openPage()
                .getHeaderComponent()
                .clickOnMyAccountMenu()
                .clickOnContinueButton()
                .isOneRadioButtonChecked();
        Assert.assertTrue(isOneRadioButtonChecked);
    }
}

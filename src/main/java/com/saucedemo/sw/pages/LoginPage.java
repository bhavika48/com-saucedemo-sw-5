package com.saucedemo.sw.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.sw.customlisteners.CustomListeners;
import com.saucedemo.sw.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created by Jay Vaghani
 */
public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement userNameField;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginLink;


    public void enterUserName() {
        Reporter.log("Enter userName " +   " to userName field " + userNameField.toString());
        sendTextToElement(userNameField, "standard_user");
        CustomListeners.test.log(Status.PASS,"Enter userName " );
    }

    public void enterPassword() {
        Reporter.log("Enter password " +  " to password field " + passwordField.toString());
        sendTextToElement(passwordField, "secret_sauce");
        CustomListeners.test.log(Status.PASS,"Enter Password " );
    }

    public void selectLogin() {
        Reporter.log("Clicking on Login Link " + loginLink.toString());
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS,"Click on login Link");
    }
}






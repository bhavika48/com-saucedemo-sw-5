package com.saucedemo.sw.testsuite;


import com.saucedemo.sw.customlisteners.CustomListeners;
import com.saucedemo.sw.pages.LoginPage;
import com.saucedemo.sw.pages.ProductsPage;
import com.saucedemo.sw.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    ProductsPage productsPage ;
    LoginPage loginPage ;

    @BeforeMethod
    public void inIt(){
        productsPage= new ProductsPage();
        loginPage= new LoginPage();
    }

    @Test(groups = {"Sanity,Smoke"})
    public void userShouldLoginSuccessfullyWithValid() {
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.selectLogin();
        String expectedMessage="Products";
        String actualMessage=productsPage.getTextProducts();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test(groups = {"Sanity Regression"})
    public void verifyThatSixProductsAreDisplayedOnPage() {
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.selectLogin();
        ArrayList<String> products = productsPage.getListOfProductsName();
        int expNo = 6;
        int actNo = products.size();
        Assert.assertEquals(actNo,expNo);
    }


}


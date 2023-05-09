package com.saucedemo.sw.pages;


import com.aventstack.extentreports.Status;
import com.saucedemo.sw.customlisteners.CustomListeners;
import com.saucedemo.sw.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class ProductsPage extends Utility {
    @CacheLookup
    @FindBy(xpath ="//span[@class='title']" )
    WebElement productsText;

    public String getTextProducts() {
        Reporter.log("Get text from product " + productsText.toString());
        return getTextFromElement(productsText);

    }


    public ArrayList<String> getListOfProductsName() {
        Reporter.log("Get list of products " + productsText.toString());
        ArrayList<String> products = getListOfTextByElement(By.xpath("//div[@class='inventory_item_name']"));
        return products;
    }


}





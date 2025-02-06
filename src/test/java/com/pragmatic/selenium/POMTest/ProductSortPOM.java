package com.pragmatic.selenium.POMTest;

import com.pragmatic.selenium.POM.BaseClass;
import com.pragmatic.selenium.POM.ProductListPageLocators;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSortPOM extends BaseClass {



    @Test

    public void testSortProductAtoZ() {


            // Select "Name (A to Z)"

        ProductListPageLocators productListPageLocators =new ProductListPageLocators(driver);
        productListPageLocators.clickSortOption();
        productListPageLocators.clickZAOption();
           // productPageLocators.verifyProductsSortedAtoZ();

        List<String> actualNames = new ArrayList<>();
        for (WebElement name : productListPageLocators.verifyProductsSortedAtoZ()) {
            actualNames.add(name.getText());
        }

        // Expected order of names
        List<String> expectedNames = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"
        );

        Assert.assertEquals(actualNames, expectedNames,"Sorting A to Z is mismatch");


        }

    @Test

    public void testSortProductZtoA() {


        // Select "Name (A to Z)"

        ProductListPageLocators productListPageLocators =new ProductListPageLocators(driver);
        productListPageLocators.clickSortOption();
        productListPageLocators.verifyProductsSortedZtoA();


        List<String> actualNames = new ArrayList<>();
        for (WebElement name : productListPageLocators.verifyProductsSortedZtoA()) {
            actualNames.add(name.getText());
        }

        // Expected order of names
        List<String> expectedNames = Arrays.asList(
                "Test.allTheThings() T-Shirt (Red)",
                "Sauce Labs Onesie",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Bike Light",
                "Sauce Labs Backpack"
        );

        Assert.assertEquals(actualNames, expectedNames,"Sorting Z to A is mismatch");


    }


}

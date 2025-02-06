package com.pragmatic.selenium.POMTest;

import com.pragmatic.selenium.POM.BaseClass;
import com.pragmatic.selenium.POM.ProductListPageLocators;
import com.pragmatic.selenium.POM.ProductPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductTestPOM extends BaseClass {
    @Test
    public void testProductName() {
        ProductListPageLocators pageLocators = new ProductListPageLocators(driver);
        String actualName = pageLocators.productName();
        String expectedName = "Sauce Labs Backpack";
        Assert.assertEquals(actualName, expectedName);
    }

    @Test
    public void testProductPrice() {
        ProductListPageLocators pageLocators = new ProductListPageLocators(driver);
        String actualPrice = pageLocators.productPrice();
        String expectedPrice = "$29.99";
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @Test(description="Test Case 2.1: Verify if all products are displayed with the correct name, price, and image.")


    public void verifyMultipleProducts() throws MalformedURLException {
        List<List<String>> expectedProducts = new ArrayList<>();
        expectedProducts.add(List.of("Sauce Labs Backpack", "$29.99", "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"));
        expectedProducts.add(List.of("Sauce Labs Bike Light", "$9.99", "/static/media/bike-light-1200x1500.37c843b0.jpg"));
        expectedProducts.add(List.of("Sauce Labs Bolt T-Shirt", "$15.99", "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"));
        expectedProducts.add(List.of("Sauce Labs Fleece Jacket", "$49.99", "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"));
        expectedProducts.add(List.of("Sauce Labs Onesie", "$7.99", "/static/media/red-onesie-1200x1500.2ec615b2.jpg"));
        expectedProducts.add(List.of("Test.allTheThings() T-Shirt (Red)", "$15.99", "/static/media/red-tatt-1200x1500.30dadef4.jpg")); // Corrected filename

        List<WebElement> productContainers = driver.findElements(By.className("inventory_item"));
        Assert.assertEquals(expectedProducts.size(), productContainers.size(), "Number of products doesn't match");

        List<List<String>> actualProducts = new ArrayList<>();

        for (WebElement container : productContainers) {
            List<String> actualProduct = new ArrayList<>();
            actualProduct.add(container.findElement(By.className("inventory_item_name")).getText());
            actualProduct.add(container.findElement(By.className("inventory_item_price")).getText());

            WebElement imageElement = container.findElement(By.xpath(".//div[@class='inventory_item_img']/a/img"));
            String actualImageUrl = imageElement.getAttribute("src");

            URL url = new URL(actualImageUrl);
            String actualRelativeUrl = url.getPath();

            actualProduct.add(actualRelativeUrl);
            actualProducts.add(actualProduct);
        }

        for (int i = 0; i < expectedProducts.size(); i++) {
            List<String> expectedProduct = expectedProducts.get(i);
            List<String> actualProduct = actualProducts.get(i);

            Assert.assertEquals(actualProduct.get(0), expectedProduct.get(0), "Product name mismatch at index " + i);
            Assert.assertEquals(actualProduct.get(1), expectedProduct.get(1), "Product price mismatch at index " + i);
            Assert.assertEquals(actualProduct.get(2), expectedProduct.get(2), "Product image URL mismatch at index " + i);
        }
    }

    @Test(description="Test Case 2.2: Verify sorting functionality for:Ato Z")

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

    @Test(description="Test Case 2.2: Verify sorting functionality for:Zto A")

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
    @Test(description = "Test Case 2.3: Verify the product details page when clicking on a product.")
    public void VerifyProductDetails(){
        // Click on Sauce Labs Bolt T-Shirt in the list
        ProductListPageLocators productListPageLocators =new ProductListPageLocators(driver);

        productListPageLocators.addTwoItemsToCart1();
        // Verify the product name
        ProductPageLocator productPageLocator=new ProductPageLocator(driver);

        String actualName = productPageLocator.getName();
        String expectedTitle = "Sauce Labs Backpack";
        Assert.assertEquals(actualName, expectedTitle, "Product name does not match");
        //Verify the product description
        String actualDescription = productPageLocator.getDescription();
        String expectedDescription = "carry.allTheThings() with the sleekpp, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualDescription, expectedDescription, "Product description does not match");
        //Verify the product price
        String actualPrice = productPageLocator.getPrice();
        String expectedPrice ="$29.99";
        Assert.assertEquals(actualPrice, expectedPrice, "Product price does not match");

    }




    }










package com.pragmatic.selenium.POMTest;

import com.pragmatic.selenium.POM.BaseClass;
import com.pragmatic.selenium.POM.CheckoutLocators;
import com.pragmatic.selenium.POM.dataProvider2;
import com.pragmatic.selenium.dataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SauceLoginPage;

import java.time.Duration;

public class CheckoutTestPOM extends BaseClass {


    @Test
    public void addToCart() {
        CheckoutLocators locators = new CheckoutLocators(driver);
        locators.clickAddToCart();

    }

    @Test



    public void addProductToCheckout() {
        CheckoutLocators locators = new CheckoutLocators(driver);
        locators.clickCheckout();
    }

    @BeforeMethod

    public void beforeMethodCheckout() {
        addToCart();
        addProductToCheckout();

    }

    @Test(dataProvider = "user-credentials", dataProviderClass = dataProvider2.class, description = "Test Case 4.1: Verify the First Name,Last Name,and Postal Code fields are required on the checkout information page.")

    public void testCheckoutWithBalnkCredentials(String firstname, String lastName, String postalCode, String expectedError) {
        CheckoutLocators locators = new CheckoutLocators(driver);
        locators.typeFirstName(firstname).typeLastName(lastName).typePostalCode(postalCode).clickContinue();
        Assert.assertEquals(locators.getError(), expectedError);
    }

    @Test(dataProvider = "valid-user-credentials", dataProviderClass = dataProvider2.class, description = "Test Case 4.2: Verify entering valid information on the checkout information page allows proceeding to the next step.")

    public void checkoutSuccess(String firstname, String lastName, String postalCode, String expectedError) {
        CheckoutLocators locators = new CheckoutLocators(driver);
        locators.typeFirstName(firstname).typeLastName(lastName).typePostalCode(postalCode).clickContinue();
        String URL= driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://www.saucedemo.com/checkout-step-two.html");

    }

    @Test(description = "Test Case 4.4: Verify the button completes the order and displays the confirmation message.")

    public void completeOrder(){
        CheckoutLocators locators=new CheckoutLocators(driver);
        locators.clickFinish();
        String actualText=locators.OrderCompletionMessage();

        String expectedText="Thank you for your order!";
        Assert.assertEquals(actualText,expectedText);
    }

    @Test(description = "Test Case 4.5: Verify the Cancel button navigates back to the cart page..")
    public void cancelOrderProcess(){
        CheckoutLocators locators=new CheckoutLocators(driver);
        locators.cancelOrder();
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,"https://www.saucedemo.com/cart.html");
    }
}

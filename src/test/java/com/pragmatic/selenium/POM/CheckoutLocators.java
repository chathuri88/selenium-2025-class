package com.pragmatic.selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SauceLoginPage;

public class CheckoutLocators {

    public final WebDriver driver;
    By byAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    By byCheckout = By.id("checkout");
    By byError = By.cssSelector("[data-test='error']");
    By byFirstName = By.id("first-name");
    By byLastName = By.id("last-name");
    By byPostalCode = By.id("postal-code");
    By byContinue = By.id("continue");
    By byFinish = By.id("finish");
    By byOrderCompletionMessage = By.xpath("//h2[@class='complete-header']");
    By byCancel= By.id("cancel");



    public CheckoutLocators(WebDriver driver) {
        this.driver = driver;
    }


    public void clickAddToCart() {
        driver.findElement(byAddToCart).click();

    }



    public void clickCheckout() {
        driver.findElement(byCheckout).click();


    }

    public CheckoutLocators typeFirstName(String firstname) {
        driver.findElement(byFirstName).sendKeys(firstname);
        return this;
    }

    public CheckoutLocators typeLastName(String lastname) {
        driver.findElement(byLastName).sendKeys(lastname);
        return this;
    }

    public CheckoutLocators typePostalCode(String postalCode) {
        driver.findElement(byPostalCode).sendKeys(postalCode);
        return this;
    }

    public void clickContinue() {
        driver.findElement(byContinue).click();
    }

    public void clickFinish() {
        driver.findElement(byFinish).click();
    }

    public String OrderCompletionMessage() {
        return driver.findElement(byOrderCompletionMessage).getText();
    }


    public void cancelOrder(){
        driver.findElement(byCancel).click();
    }


    public String getError(){

        return driver.findElement(byError).getText();
    }

}

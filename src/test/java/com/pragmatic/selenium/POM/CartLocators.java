package com.pragmatic.selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartLocators {

    public final WebDriver driver;


    //By byBikeLightItem= By.xpath("//div[contains(text(), 'Sauce Labs Bike Light')]");
    By byInitialCartCount=By.className("shopping_cart_badge");
    By byRemoveItem=By.id("remove-sauce-labs-backpack");
    By byUpdateCartCount=By.xpath("//span[data-test='shopping-cart-badge']");
    By byVerifyBikeLightItem=By.xpath("//div[contains(text(), 'Sauce Labs Bike Light')]");
    By byContinueShopping=By.id("continue-shopping");
    By byCheckout=By.id("checkout");
    By byCartItemListLocator=By.cssSelector("[data-test='inventory-item-name']");


    public CartLocators
            (WebDriver driver) {
        this.driver = driver;
    }


    public String initialCartCount(){

     return driver.findElement(byInitialCartCount).getText();



    }

    public void removeItem(){
        driver.findElement(byRemoveItem).click();
    }

    public void updateCartCount(){
        driver.findElement(byUpdateCartCount).click();
    }

    public void ByVerifyBikeLightItem(){
        driver.findElement(byVerifyBikeLightItem).isDisplayed();


    }

    public void continueShopping(){

        driver.findElement(byContinueShopping).click();
    }

    public void setByCheckout(){

        driver.findElement(byCheckout).click();
    }

    public List<WebElement> getCartItems(){
        return driver.findElements(byCartItemListLocator);
    }




}

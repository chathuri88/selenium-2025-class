package com.pragmatic.selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPageLocators {

    public final WebDriver driver;

    By byAddToCart1 = By.id("add-to-cart-sauce-labs-backpack");
    By byAddToCart2 = By.id("add-to-cart-sauce-labs-bike-light");

    By byProductList = By.cssSelector("[data-test='inventory-item']");


    By byCartLink = By.xpath("//a[@class='shopping_cart_link']");
    By byBackPackItem=By.xpath("//div[contains(text(), 'Sauce Labs Backpack'");
    By byBikeLightItem= By.xpath("//div[contains(text(), 'Sauce Labs Bike Light')]");

    By byProductName= By.xpath("//a[@id='item_4_title_link']/div");

    By byProductPrice=By.xpath("//div[@data-test='inventory-item-price']");
    By bySortDropDown= By.className("product_sort_container");
    By byNameAZOption=By.xpath("//option[text()='Name (A to Z)']");
    By byNameZAOption=By.xpath("//option[text()='Name (Z to A)']");
    By byproductNames=By.className("inventory_item_name");
    By byProductDescription=By.xpath("//div[@data-test='inventory-item-description']");

    By byInventoryList = By.cssSelector("[data-test='inventory-item']");



    public ProductListPageLocators(WebDriver driver) {
        this.driver = driver;
    }

    public String productName(){

        return driver.findElement(byProductName).getText();

    }

    public String productDescription(){
        return driver.findElement(byProductDescription).getText();
    }

    public String productPrice(){
        return driver.findElement(byProductPrice).getText();
    }

    public void addTwoItemsToCart1(){

        driver.findElement(byAddToCart1).click();
    }

    public void addTwoItemsToCart2(){

        driver.findElement(byAddToCart2).click();
    }

    public void clickCartLink(){
        driver.findElement(byCartLink).click();
    }

    public void clickBackPackItem(){
        driver.findElement(byBackPackItem).click();
    }
    public void clickBikeLightItem(){
        driver.findElement(byBikeLightItem).click();
    }

    public void clickSortOption(){
        driver.findElement(bySortDropDown).click();
    }
    public void clickAZOption(){
        driver.findElement(byNameAZOption).click();
    }

    public void clickZAOption(){
        driver.findElement(byNameZAOption).click();
    }


    public List<WebElement> verifyProductsSortedAtoZ(){
       return driver.findElements(byproductNames);

    }

    public List<WebElement>  verifyProductsSortedZtoA(){
       return driver.findElements(byproductNames);

    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(byProductList);
    }







}








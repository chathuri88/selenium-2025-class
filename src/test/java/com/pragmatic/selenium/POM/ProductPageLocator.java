package com.pragmatic.selenium.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageLocator {

    public final WebDriver driver;


    By byName= By.cssSelector("[data-test='inventory-item-name']");
    By byDescription =By.cssSelector("[data-test='inventory-item-desc']");
    By byPrice=By.cssSelector("[data-test='inventory-item-price']");
    By byImage=By.cssSelector("[data-test='item-sauce-labs-bolt-t-shirt-img']");




    public ProductPageLocator(WebDriver driver) {
        this.driver = driver;
    }

    public String getName() {
            return driver.findElement(byName).getText();
        }

        public String getDescription() {
            return driver.findElement(byDescription).getText();
        }

        public String getPrice() {
            return driver.findElement(byPrice).getText();
        }


    }



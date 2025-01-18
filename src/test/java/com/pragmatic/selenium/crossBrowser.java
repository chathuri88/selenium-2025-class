package com.pragmatic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class crossBrowser {
    WebDriver driver;

    @Test
    public void LoginChromeTestMethod() {
        //Create a browser instance
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headclass");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        //Navigate to the webpage

        //Type username
        WebElement username= driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //Type password
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //Click on the login button
        WebElement loginButton= driver.findElement(By.id("login-button"));
        loginButton.click();

        //Assert

        Assert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Products");

    }

        }

package com.pragmatic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void LoginTestMethod(){
        //Create a browser instance
        WebDriver webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();

        //Navigate to the webpage

        webDriver.get("https://www.saucedemo.com/");
        //Type username
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on the login button
        webDriver.findElement(By.id("login-button")).click();

        //Assert

        Assert.assertEquals(webDriver.findElement(By.cssSelector("[data-test='title']")).getText(),"Products");

        //close the browser


       //webDriver.quit();
    }

}

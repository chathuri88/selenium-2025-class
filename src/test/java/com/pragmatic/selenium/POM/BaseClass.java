package com.pragmatic.selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {
    public WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        LoginWithValidUsernameValidPassword();
    }


    public void LoginWithValidUsernameValidPassword() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on the login button
        driver.findElement(By.id("login-button")).click();

        //Assert

        Assert.assertEquals(driver.findElement(By.cssSelector("[data-test='title']")).getText(), "Products");


    }





//    @AfterMethod
//    public void afterMethod(){
//        driver.quit();
//    }




}

package com.pragmatic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class orangeHRM {
    WebDriver driver;

    @Test
    public void testCurrentURL(){

    }

    @Test
    public void VerifyTitle() {
        //Create a browser instance
        //ChromeOptions options=new ChromeOptions();
        //options.addArguments("--headclass");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //driver.findElement(By.id("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
@Test
    public void testNavigation(){
      String baseURL= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
      driver.navigate().to(baseURL);
      driver.navigate().back();
    driver.navigate().forward();
    driver.navigate().refresh();
    }




}

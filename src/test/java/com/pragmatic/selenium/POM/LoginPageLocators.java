package com.pragmatic.selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SauceLoginPage;

public class LoginPageLocators {
    private final WebDriver driver;
    By byUsername=By.id("user-name");
    By byPassword=By.id("password");
    By byLogin=By.id("login-button");
    By byError=By.cssSelector("[data-test='error']");
    public LoginPageLocators(WebDriver driver){
        this.driver=driver;
    }
    public LoginPageLocators typeUsername(String username){
        driver.findElement(byUsername).sendKeys(username);
        return this;
    }

    public LoginPageLocators typePassword(String password){
        driver.findElement(byPassword).sendKeys(password);
        return this;
    }

    public void clickLogin(){
        driver.findElement(byLogin).click();


    }

    public String getError(){

        return driver.findElement(byError).getText();
    }

}




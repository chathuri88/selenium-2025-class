package com.pragmatic.selenium.POMTest;

import com.pragmatic.selenium.POM.BaseClass;
import com.pragmatic.selenium.POM.LoginPageLocators;
import com.pragmatic.selenium.dataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceLoginPage;

public class LoginTestPOM extends BaseClass

{



    @Test

    public void  loginwithValidCredentials(){

        LoginPageLocators loginPage= new LoginPageLocators(driver);
        loginPage.typeUsername("standard-user").typePassword("secret-sauce").clickLogin();
    }

    @Test

    public void verifyLoginWithInvalidUsername() {
        LoginPageLocators loginPage = new LoginPageLocators(driver);
        loginPage.typeUsername("chathuri").typePassword("secret-sauce").clickLogin();
        String expectedError="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getError(),expectedError);
    }



    @Test(dataProvider = "login-credentials",dataProviderClass = dataProvider.class,description="Verify login with blank user name and password")

    public void testLoginWithBalnkUsernamePassword(String username,String password,String expectedError){
       LoginPageLocators loginPage=new LoginPageLocators(driver);
        loginPage.typeUsername(username).typePassword(password).clickLogin();
        Assert.assertEquals(loginPage.getError(),expectedError);
    }


    }






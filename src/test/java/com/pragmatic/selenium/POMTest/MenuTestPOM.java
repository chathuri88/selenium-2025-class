package com.pragmatic.selenium.POMTest;

import com.pragmatic.selenium.POM.BaseClass;
import com.pragmatic.selenium.POM.MenuLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MenuTestPOM extends BaseClass {

    @Test

    public void Menu(){
        MenuLocators menuLocators=new MenuLocators(driver);

        menuLocators.clickMenu();
        menuLocators.clickLogout();

    }

    @Test

    public void AllItems(){
        MenuLocators menuLocators=new MenuLocators(driver);
        menuLocators.clickMenu();
        menuLocators.clickAllItems();
    }

    @Test
    public void About(){

        MenuLocators menuLocators=new MenuLocators(driver);
        menuLocators.clickMenu();
        menuLocators.clickAbout();
    }
}

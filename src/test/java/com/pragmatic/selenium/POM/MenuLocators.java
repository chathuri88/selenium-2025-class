package com.pragmatic.selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuLocators {

    public final WebDriver driver;

    public MenuLocators(WebDriver driver){
        this.driver=driver;
    }

    By byMenuButton= By.id("react-burger-menu-btn");

    By byLogoutButton = By.xpath("//a[@id='logout_sidebar_link']");

    By byAllItems=By.xpath("//a[@id='inventory_sidebar_link']");

    By byAbout=By.xpath("//a[@id='about_sidebar_link']");

    public void clickMenu() {
        driver.findElement(byMenuButton).click();


    }


    public void clickLogout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLogoutButton));
        driver.findElement(byLogoutButton).click();


    }

    public void clickAllItems(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byAllItems));
        driver.findElement(byAllItems).click();
    }

    public void clickAbout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byAbout));
        driver.findElement(byAbout).click();
    }


}

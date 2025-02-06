package com.pragmatic.selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class NavigationMenuLocators {
    public final WebDriver driver;
    By byMainMenu = By.id("react-burger-menu-btn");
    By byMenuWrap = By.cssSelector("[class='bm-menu-wrap']");
    By byLogoutLink = By.id("logout_sidebar_link");
    By byAllItemsLink = By.id("inventory_sidebar_link");
    By byAboutLink = By.id("about_sidebar_link");

    public NavigationMenuLocators(WebDriver driver) {
        this.driver = driver;
    }


    public void clickMenu() {
        driver.findElement(byMainMenu).click();
    }

    public WebElement menuVisible() {
        return driver.findElement(byMainMenu);
    }


    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byLogoutLink));
        driver.findElement(byLogoutLink).click();
    }


    public void clickAllItemsLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(byAllItemsLink));
        driver.findElement(byAllItemsLink).click();
    }


    public void clickAbout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(byAboutLink));
        driver.findElement(byAboutLink).click();
    }
}


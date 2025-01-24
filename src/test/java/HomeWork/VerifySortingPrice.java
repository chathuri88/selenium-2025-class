package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifySortingPrice {

    public WebDriver driver;


    @BeforeMethod
    public void loginToSauceDemo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        login();
    }

        private void login() {
            // Log in with valid credentials
            WebElement username = driver.findElement(By.id("user-name"));
            username.sendKeys("standard_user");
            //Type password
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("secret_sauce");
            //Click on the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }

        @Test

        public void sortPriceHighToLow(){
            WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
            sortDropdown.click();

            WebElement priceHighToLowOption = sortDropdown.findElement(By.xpath("//option[text()='Price (high to low)']"));
            priceHighToLowOption.click();

            // Get product prices
            List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));
            List<String> actualPrices = new ArrayList<>();
            for (WebElement price : productPrices) {
                actualPrices.add(price.getText());
            }

            // Expected order of prices
            List<String> expectedPrices = Arrays.asList(
                    "$49.99",
                    "$29.99",
                    "$15.99",
                    "$15.99",
                    "$9.99",
                    "$7.99"
            );

            Assert.assertEquals(actualPrices, expectedPrices);
        }
        @Test
        public void sortPriceLowToHigh(){
            WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
            sortDropdown.click();

            WebElement priceLowToHighOption = sortDropdown.findElement(By.xpath("//option[text()='Price (low to high)']"));
            priceLowToHighOption.click();

            // Get product prices
            List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));
            List<String> actualPrices = new ArrayList<>();
            for (WebElement price : productPrices) {
                actualPrices.add(price.getText());
            }

            // Expected order of prices
            List<String> expectedPrices = Arrays.asList(
                    "$7.99",
                    "$9.99",
                    "$15.99",
                    "$15.99",
                    "$29.99",
                    "$49.99"
            );

            Assert.assertEquals(actualPrices, expectedPrices);
        }


        }







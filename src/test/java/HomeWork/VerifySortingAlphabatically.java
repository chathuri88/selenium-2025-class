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

public class VerifySortingAlphabatically {
    public WebDriver driver;


    @BeforeMethod
    public void loginToSauceDemo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        login();

    }

//    @AfterMethod
//    public void afterMethod() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

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

    public void testSortProductAtoZ() {

     {
            // Select "Name (A to Z)"
            WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
            sortDropdown.click();

            WebElement nameAZOption = sortDropdown.findElement(By.xpath("//option[text()='Name (A to Z)']"));
            nameAZOption.click();

            // Get product names
            List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
            List<String> actualNames = new ArrayList<>();
            for (WebElement name : productNames) {
                actualNames.add(name.getText());
            }

            // Expected order of names
            List<String> expectedNames = Arrays.asList(
                    "Sauce Labs Backpack",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Fleece Jacket",
                    "Sauce Labs Onesie",
                    "Test.allTheThings() T-Shirt (Red)"
            );

            Assert.assertEquals(actualNames, expectedNames);
            System.out.println("Sort Products according to the ascending:"+actualNames);
        }
    }
@Test
    public void testSortProductZtoA() {

    // Select "Name (Z to A)"
    WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
    sortDropdown.click();

    WebElement nameZTOption = sortDropdown.findElement(By.xpath("//option[text()='Name (Z to A)']"));
    nameZTOption.click();

    // Get product names
    List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
    List<String> actualNames = new ArrayList<>();
    for (WebElement name : productNames) {
        actualNames.add(name.getText());
    }

    // Expected order of names
    List<String> expectedNames = Arrays.asList(
            "Test.allTheThings() T-Shirt (Red)",
            "Sauce Labs Onesie",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Bike Light",
            "Sauce Labs Backpack"
    );

    Assert.assertEquals(actualNames, expectedNames);
    System.out.println("Sort Products according to the ascending:"+actualNames);
}
    }

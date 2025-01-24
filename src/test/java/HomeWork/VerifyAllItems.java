package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class VerifyAllItems {
    public WebDriver driver;

    @BeforeMethod
    public void loginToSauceDemo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        login();
    }

    private void login () {
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

    public void AllItems(){
        WebElement menuButton=driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        System.out.println("Menu button expanded successfully");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='inventory_sidebar_link']")));
        WebElement AllItemsOption= driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));
        AllItemsOption.click();
        System.out.println("All Items loaded successfully");
    }

@Test
    public void AboutPage(){
        WebElement menuButton=driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        System.out.println("Menu button expanded successfully");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='about_sidebar_link']")));
        WebElement aboutPage=driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));
        aboutPage.click();
        System.out.println("About Page loaded successfully");
    }
    }


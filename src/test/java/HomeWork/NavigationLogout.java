package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationLogout {
    public WebDriver driver;

    @BeforeMethod
    public void loginToSauceDemo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        login();
        //Menu();

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
        public void Menu(){

        WebElement menuButton=driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        System.out.println("Menu button expanded successfully");
        }
        @Test
        public void logout(){

        WebElement logOutButton=driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logOutButton.click();
        System.out.println("User logout successfully");
        }
    }


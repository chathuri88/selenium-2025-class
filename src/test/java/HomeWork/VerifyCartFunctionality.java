package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyCartFunctionality {

    WebDriver driver;
    @BeforeMethod
    public void loginToSauceDemo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        login();
        addProdToCart();
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

    public void addProdToCart() {

        WebElement addToCart1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart1.click();
        WebElement addToCart2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addToCart2.click();
        WebElement cartLink=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartLink.click();
    }
@Test
        public void verifyCartProduct(){
            // Verify cart contents
            WebElement backpackItem = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
            WebElement bikeLightItem = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Bike Light')]"));

            Assert.assertTrue(backpackItem.isDisplayed());
            Assert.assertTrue(bikeLightItem.isDisplayed());
        }

        @Test
    public void removeProduct(){

            // Verify initial cart count
            String initialCartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
            Assert.assertEquals(initialCartCount, "2");

            // Remove the backpack
            driver.findElement(By.id("remove-sauce-labs-backpack")).click();

            // Verify updated cart count
            String updatedCartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
            Assert.assertEquals(updatedCartCount, "1");
            System.out.println("After removing one product cart content count is:"+updatedCartCount);



            // Verify bike light is still present
            WebElement bikeLightItem = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Bike Light')]"));
            Assert.assertTrue(bikeLightItem.isDisplayed());
        }
       @Test
        public void continueShopping(){
        WebElement continueShopping= driver.findElement(By.id("continue-shopping"));
        continueShopping.click();
           // Verify current page is product listing page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");

       }
       @Test
        public void checkout(){
            WebElement checkout= driver.findElement(By.id("checkout"));
            checkout.click();
           String currentUrl = driver.getCurrentUrl();
           Assert.assertEquals(currentUrl, "https://www.saucedemo.com/checkout-step-one.html");
       }
        }




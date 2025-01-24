package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
//WebDriverWait wait=new WebDriverWait(455);

public class SauceDemo {

    public WebDriver driver;

    @BeforeClass
    public void loginToSauceDemo() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        //Type username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //Type password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //Click on the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='title']"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Products";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(priority =1 )

    public void addProdToCart() {

        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
    }
    @Test (priority = 2 )
    public void VerifyCart(){
        WebElement cartLink=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartLink.click();

    }

    @Test (priority = 3)

    public void testProductIsExistInStore() {



       
        List<WebElement> productElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        String productName="Sauce Labs Backpack";
        // Check if the product is in the list
        for (WebElement productElement : productElements) {
            if (productElement.getText().equals(productName)) {
                System.out.println("Product is similar:" +productName);
            }
        }

    }

    @Test (priority = 4 )

    public void addProdutToCheckout(){
          WebElement checkout= driver.findElement(By.id("checkout"));
          checkout.click();
          WebElement name=driver.findElement(By.id("first-name"));
          name.sendKeys("Chathuri");
          WebElement lastname= driver.findElement(By.id("last-name"));
          lastname.sendKeys("Kirinda");
          WebElement postalCode= driver.findElement(By.id("postal-code"));
          postalCode.sendKeys("65560");
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0,250)", "");
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
          driver.findElement(By.id("continue")).click();

          WebElement finish= driver.findElement(By.id("finish"));
          finish.click();



    }
}



package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver webDriver;

    @BeforeClass
    public void openURL() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://www.saucedemo.com/");
        //Navigate to the webpage
    }

    @Test
    public void LoginWithValidUsernameValidPassword() {

        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on the login button
        webDriver.findElement(By.id("login-button")).click();

        //Assert

        Assert.assertEquals(webDriver.findElement(By.cssSelector("[data-test='title']")).getText(), "Products");


    }

    @Test
    public void loginwithblankCredentials() {
        webDriver.findElement(By.id("user-name")).clear();
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("login-button")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("h3[data-set=error")).getText(), "Epic sadface: Username is required");

    }

    @Test
    public void loginwithblankUsername() {
        webDriver.findElement(By.id("user-name)")).clear();
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("h3[data-set=error")).getText(), "Epic sadface: Username is required");

    }

    @Test

    public void loginwithblankPassword() {
        webDriver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("login-button")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("h3[data-set=error")).getText(), "Epic sadface: Username is required");

    }
    @Test

    public void loginwithinvalidPassword() {
        webDriver.findElement(By.id("user-name")).sendKeys("problem_user");
        webDriver.findElement(By.id("password")).sendKeys("qwer");
        webDriver.findElement(By.id("login-button")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("h3[data-set=error")).getText(), "Epic sadface: Username and password do not match any user in this service");
    }
   @Test
    public void loginwithInvalidUsername() {
        webDriver.findElement(By.id("user-name")).sendKeys("abcd");
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("h3[data-set=error")).getText(), "Epic sadface: Username and password do not match any user in this service");
    }
   @Test(dataProvider= "login-credentials")
    public void loginwithInvalidCredentials(String username,String password,String expectedMessage) {
        webDriver.findElement(By.id("user-name")).sendKeys("username");
        webDriver.findElement(By.id("password")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();
        String errorMessage= webDriver.findElement(By.cssSelector("h3[data-set=error")).getText();
        Assert.assertEquals(errorMessage,expectedMessage,"Error message is incorrect");

    }


}




//     @AfterMethod
//    public void afterMethod(){
//         webDriver.quit();
//     }





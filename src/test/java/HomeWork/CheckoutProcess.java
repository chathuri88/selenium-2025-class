package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckoutProcess {
    public WebDriver driver;

    @BeforeMethod
    public void loginToSauceDemo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        login();
        addProdToCart();
        VerifyCart();
        addProdutToCheckout();
        //CheckoutSuccess();

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


    private void addProdToCart() {

        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
    }

    private void VerifyCart() {
        WebElement cartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartLink.click();

    }

    private void addProdutToCheckout() {
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

    }

//    @AfterMethod
//    public void afterMethod() {
//        driver.close();
//    }


    @DataProvider(name = "userCredentials")
    public static Object[][] userCredentials() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"", "Kirinda", "65560", "Error: First Name is required"},
                {"Chathuri", "", "65560", "Error: Last Name is required"},
                {"Chathuri", "Kirinda", "", "Error: Postal Code is required"},


        };
    }

    @Test(dataProvider = "userCredentials")
    public void testCheckoutWithBlankDetails(String firstname, String lastName, String postalCode, String expectedError) {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(), expectedError);

    }

    @Test
    public void CheckoutSuccess() {


        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Chathuri");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Kirinda");

        WebElement postalCode = driver.findElement(By.id("postal-code"));
        postalCode.sendKeys("65560");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
        driver.findElement(By.id("continue")).click();

    }

    @Test
    public void orderSummaryPage() {
        // Find all product price elements (adjust XPath if needed
        List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

// Create an ArrayList to store prices
        ArrayList<Double> prices = new ArrayList<>();

        // Extract prices and add to the list
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }

        // Calculate the total
        double total = 0;
        for (double price : prices) {
            total += price;
        }

        // Print the total
        System.out.println("Total: $" + total);

    }

@Test
    public void completeOrder() {
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
        WebElement orderCompletionMessage = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String actualText=orderCompletionMessage.getText();
        String expectedText="Thank you for your order!";
        Assert.assertEquals(actualText,expectedText);
    }


    @Test

    public void cancelOrder(){

        WebElement cancelButton=driver.findElement(By.id("cancel"));
        cancelButton.click();
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.saucedemo.com/cart.html";
        Assert.assertEquals(actualURL,expectedURL);
    }
}

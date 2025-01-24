package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductListPage {
    public WebDriver driver;


    @BeforeMethod
    public void loginToSauceDemo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        login();

    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
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
    public void testProductName() {

        String expectedName = "Sauce Labs Backpack";

        String actualName = driver.findElement(By.xpath("//a[@id='item_4_title_link']/div")).getText();

        Assert.assertEquals(actualName, expectedName);
    }

    @Test

    public void testProductPrice() {

        String ExpectedProductPrice = "$29.99";
        String ActualProductPrice = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']")).getText();
        Assert.assertEquals(ActualProductPrice, ExpectedProductPrice);
    }

    @Test
    public void verifyProductDetails() {
        // Find all product containers
//        List<WebElement> productContainers = driver.findElements(By.className("inventory_item"));
//
//        // Create a 2D array (List of Lists) to store product information
//        List<List<String>> products = new ArrayList<>();
//
//        for (WebElement container : productContainers) {
//
//            // Extract product name
//            String name = container.findElement(By.className("inventory_item_name")).getText();
//
//            // Extract product price
//            String price = container.findElement(By.className("inventory_item_price")).getText();
//
//            // Extract product description
//            String description = container.findElement(By.className("inventory_item_desc")).getText();
//
//            // Add product information to the 2D array
//            List<String> productInfo = new ArrayList<>();
//            productInfo.add(name);
//            productInfo.add(price);
//            productInfo.add(description);
//            products.add(productInfo);
//        }
//
//        // Print the product information
//        for (List<String> product : products) {
//            System.out.println(product);
//        }
//
//    }
//        // Expected product data (replace with your actual data)
//        List<List<String>> expectedProducts = new ArrayList<>();
//        expectedProducts.add(List.of("Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.","https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"));
//        expectedProducts.add(List.of("Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.","https://www.saucedemo.com/static/media/bike-light-1200x1500.37c843b0.jpg"));
//        expectedProducts.add(List.of("Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.","https://www.saucedemo.com/static/media/bike-light-1200x1500.37c843b0.jpg"));
//        expectedProducts.add(List.of("Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.","https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"));
//
//        // Find all product containers
//        List<WebElement> productContainers = driver.findElements(By.className("inventory_item"));
//
//        // Create a list to store actual product information
//        List<List<String>> actualProducts = new ArrayList<>();
//
//        // Extract actual product information
//        for (WebElement container : productContainers) {
//            List<String> actualProduct = new ArrayList<>();
//            actualProduct.add(container.findElement(By.className("inventory_item_name")).getText());
//            actualProduct.add(container.findElement(By.className("inventory_item_price")).getText());
//            actualProduct.add(container.findElement(By.className("inventory_item_desc")).getText());
//            actualProduct.add(container.findElement(By.className("inventory_item_img")).getText());
//            actualProducts.add(actualProduct);
//        }
//
//        // Assert that the number of products matches
//      //  Assert.assertEquals(expectedProducts.size(), actualProducts.size());
//
//        // Assert product details for each product
//        for (int i = 0; i < expectedProducts.size(); i++) {
//            Assert.assertEquals(actualProducts.get(i).get(0), expectedProducts.get(i).get(0)); // Assert name
//            Assert.assertEquals(actualProducts.get(i).get(1), expectedProducts.get(i).get(1)); // Assert price
//            Assert.assertEquals(actualProducts.get(i).get(2), expectedProducts.get(i).get(2));
//            Assert.assertEquals(actualProducts.get(i).get(3), expectedProducts.get(i).get(3));
//            // Get the actual image URL
//        String imageElement = productContainers.get(i).getDomAttribute("src");//.findElement(By.xpath("//div[@class='inventory_item_img']/a/img"));
//           // String actualImageUrl = imageElement.getDomProperty("src");
//
//            // Get the expected image URL
//            String expectedImageUrl = expectedProducts.get(i).get(3);
//
//            // Assert that the image URLs match
//            Assert.assertEquals(imageElement, expectedImageUrl);
//        }
//    }
//
//        }


        // Expected product data
        List<List<String>> expectedProducts = new ArrayList<>();
        expectedProducts.add(List.of("Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"));
        expectedProducts.add(List.of("Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", "https://www.saucedemo.com/static/media/bike-light-1200x1500.37c843b0.jpg"));
        expectedProducts.add(List.of("Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "https://www.saucedemo.com/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"));
        expectedProducts.add(List.of("Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"));

        // Find all product containers
        List<WebElement> productContainers = driver.findElements(By.className("inventory_item"));

        // Create a list to store actual product information
        List<List<String>> actualProducts = new ArrayList<>();

        // Extract actual product information
        for (WebElement container : productContainers) {
            List<String> actualProduct = new ArrayList<>();
            actualProduct.add(container.findElement(By.className("inventory_item_name")).getText());
            actualProduct.add(container.findElement(By.className("inventory_item_price")).getText());
            actualProduct.add(container.findElement(By.className("inventory_item_desc")).getText());

            // Get the actual image URL
            WebElement imageElement = container.findElement(By.xpath("//div[@class='inventory_item_img']/a/img"));
            String actualImageUrl = imageElement.getAttribute("src");
            actualProduct.add(actualImageUrl);

            actualProducts.add(actualProduct);
        }

        // Assert that the number of products matches
        //Assert.assertEquals(expectedProducts.size(), actualProducts.size());

        // Assert product details for each product
        for (int i = 0; i < expectedProducts.size(); i++) {
            Assert.assertEquals(actualProducts.get(i).get(0), expectedProducts.get(i).get(0)); // Assert name
            Assert.assertEquals(actualProducts.get(i).get(1), expectedProducts.get(i).get(1)); // Assert price
            Assert.assertEquals(actualProducts.get(i).get(2), expectedProducts.get(i).get(2)); // Assert description
            Assert.assertEquals(actualProducts.get(i).get(3), expectedProducts.get(i).get(3)); // Assert image URL
        }
    }


}




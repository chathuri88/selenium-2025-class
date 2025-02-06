package com.pragmatic.selenium.POMTest;

import com.pragmatic.selenium.POM.BaseClass;
import com.pragmatic.selenium.POM.CartLocators;
import com.pragmatic.selenium.POM.ProductListPageLocators;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CartTestingPOM extends BaseClass {


    @Test(description = "Test Case 3.1:Verify that the correct products are displayed in the cart after adding them from the product listing page.")
        public void addProdToCart(){

            ProductListPageLocators productListPageLocators =new ProductListPageLocators(driver);
            productListPageLocators.addTwoItemsToCart1();//Add Product 1 to Cart
            productListPageLocators.addTwoItemsToCart2();//Add Product 2 to Cart
            productListPageLocators.clickCartLink();
            CartLocators cartLocators=new CartLocators(driver);

        List<WebElement> cartItems = cartLocators.getCartItems();
        // Expected product names
        List<String> expectedProducts = new ArrayList<>(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light"));
        // Verify that the actual products in the cart match the expected products
        Assert.assertEquals(cartItems.size(), expectedProducts.size(), " Number of products in cart does not match expected");
        for (int i = 0; i < cartItems.size(); i++) {
            String actualProductName = cartItems.get(i).getText();
            String expectedProductName = expectedProducts.get(i);
            Assert.assertEquals(actualProductName, expectedProductName, "Product name mismatch at index" + i);
        }


    }


    @Test(description = "Verify that removing a product from the cart updates the cart count and removes it from the cart page.")
    public void removeProduct(){
        ProductListPageLocators productListPageLocators =new ProductListPageLocators(driver);

        productListPageLocators.addTwoItemsToCart1();//Add Product 1 to Cart
        productListPageLocators.addTwoItemsToCart2();//Add Product 2 to Cart
        CartLocators cartLocators=new CartLocators(driver);
        int initialCartCount = Integer.parseInt(cartLocators.initialCartCount());
        cartLocators.removeItem();
        int expectedCartCount = initialCartCount - 1; // Assuming you remove 1 item
        int actualCartCount = Integer.parseInt(cartLocators.initialCartCount());
        Assert.assertEquals(actualCartCount, expectedCartCount, "Cart count is incorrect after removing product.");
    }


    @Test(description = "Test Case 3.3: Verify the Continue Shopping button navigates to the Product List page.")
    public void continueShopping(){
        ProductListPageLocators productListPageLocators =new ProductListPageLocators(driver);

        productListPageLocators.addTwoItemsToCart1();//Add Product 1 to Cart
        productListPageLocators.addTwoItemsToCart2();
        productListPageLocators.clickCartLink();
        CartLocators cartLocators=new CartLocators(driver);

        cartLocators.continueShopping();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html","The page is mismatch");
    }

        @Test(description = "Test Case 3.4: Verify the Checkout button navigates to the checkout page.")
        public void checkoutNavigation(){
          ProductListPageLocators productListPageLocators =new ProductListPageLocators(driver);
          productListPageLocators.addTwoItemsToCart1();
          productListPageLocators.addTwoItemsToCart2();
          productListPageLocators.clickCartLink();
          CartLocators cartLocators=new CartLocators(driver);
          cartLocators.setByCheckout();

          String currentUrl = driver.getCurrentUrl();
          Assert.assertEquals(currentUrl, "https://www.saucedemo.com/checkout-step-one.html","The page is mismatch");
        }

}





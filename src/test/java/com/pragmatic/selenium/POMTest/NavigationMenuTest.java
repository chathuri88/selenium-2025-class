package com.pragmatic.selenium.POMTest;

import com.pragmatic.selenium.POM.BaseClass;
import com.pragmatic.selenium.POM.NavigationMenuLocators;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationMenuTest extends BaseClass {

    @Test(description = "Test Case 5.1: Verify clicking the Menu button opens the navigation menu.")
    public void testMainMenu(){
        //Open the Main menu
        NavigationMenuLocators navigationMenuPage=new NavigationMenuLocators(driver);
        navigationMenuPage.clickMenu();
        Assert.assertTrue(navigationMenuPage.menuVisible().isDisplayed(),
                "Main menu is not visible after click on the main Menu");
    }


    @Test(description = "Test Case 5.2: Verify the Logout option logs the user out and redirects to the login page.")
    public void testLogoutFunctionality(){
        //Open the Main menu
        NavigationMenuLocators navigationMenuPage= new NavigationMenuLocators(driver);
        navigationMenuPage.clickMenu();
        //Select logout
        navigationMenuPage.clickLogout();
        // Assert user is redirected to login page after logout
        String expectedUrl="https://www.saucedemo.com/";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualURL);

    }


    @Test(description = "Test Case 5.3: Verify the All Items option in the menu navigates back to the product listing page.")
    public void testAllItemsNavigation(){
        NavigationMenuLocators navigationMenuPage=new NavigationMenuLocators(driver);
        //Open the Main menu
        navigationMenuPage.clickMenu();
        navigationMenuPage.clickAllItemsLink();
        String expectedUrl= "https://www.saucedemo.com/inventory.html";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualURL);
    }


    @Test(description = "Test Case 5.4: Verify the About option redirects to the company website.")
    public void testVerifyAboutLink(){
        NavigationMenuLocators navigationMenuPage=new NavigationMenuLocators(driver);
        //Open the Main menu
        navigationMenuPage.clickMenu();
        navigationMenuPage.clickAbout();
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://saucelabs.com/"),
                "About link does not redirect to the correct URL");
    }
}



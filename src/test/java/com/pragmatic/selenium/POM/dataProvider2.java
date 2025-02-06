package com.pragmatic.selenium.POM;


import org.testng.annotations.DataProvider;

public class dataProvider2 {

    @DataProvider(name = "user-credentials")
    public static Object[][] userCredentials() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"", "Kirinda", "65560", "Error: First Name is required"},
                {"Chathuri", "", "65560", "Error: Last Name is required"},
                {"Chathuri", "Kirinda", "", "Error: Postal Code is required"}

        };
    }

    @DataProvider(name = "valid-user-credentials")
    public static Object[][] ValidUserCredentials() {
        return new Object[][]{
                {"Chathuri", "Kirinda", "65560", ""},


        };
    }

}

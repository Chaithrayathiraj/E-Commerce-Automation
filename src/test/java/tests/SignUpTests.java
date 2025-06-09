package tests;


import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SignUpPage;
import utils.Screenshotutils;

import java.time.Duration;

public class SignUpTests extends BaseTest {

    @Test
    public void testUserSignUp() {
    	
        SignUpPage signUpPage = new SignUpPage(driver);
        
        
     // Generate a unique username to avoid duplicate errors
        String username = "testuser" + System.currentTimeMillis();

        // Open sign up modal and enter credentials
        signUpPage.openSignUpModal();
        signUpPage.enterUsername("testuser123");  // You can generate random or parameterize
        signUpPage.enterPassword("Test@1234");
        signUpPage.clickSignUpButton();

        // Wait for alert and accept it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        alert.accept();

        // Verify alert message for success or failure
        Assert.assertTrue(alertText.contains("Sign up successful") || alertText.contains("This user already exist"),
                "Unexpected alert message: " + alertText);
        Screenshotutils.takeScreenshot(driver, "SignUpTests");

    }
}

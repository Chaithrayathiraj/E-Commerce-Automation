package tests;



import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.Screenshotutils;

public class LoginTests extends BaseTest {

    @Test
    public void testUserLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Use the same username you signed up with earlier OR a valid existing user
        // For demo, use a fixed test user that exists
        String username = "testuser123";  // Change as per your existing user
        String password = "Test@1234";

        loginPage.login(username, password);

        // Wait for the page to update after login
        // Simple check: verify logout link is displayed
        Assert.assertTrue(loginPage.isLogoutVisible(), "Logout link is not visible, login might have failed.");
        Screenshotutils.takeScreenshot(driver, "LoginTests");

    }
}

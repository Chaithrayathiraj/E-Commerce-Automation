package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utils.Screenshotutils;

public class HomePageTests extends BaseTest {

    @Test
    public void verifyHomePageTitleAndLogo() {
        HomePage homePage = new HomePage(driver);

        String actualTitle = homePage.getPageTitle();
        String expectedTitle = "STORE"; // You can verify by opening the site

        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
        Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed!");
        Screenshotutils.takeScreenshot(driver, "HomePageTests");

    }
}

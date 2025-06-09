package tests;


import base.BaseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductListPage;
import pageObjects.ProductPage;
import utils.Screenshotutils;

public class AddtoCartTests extends BaseTest {

    @Test
    
    public void testAddFirstProductToCart() {
        driver.get("https://www.demoblaze.com/");

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.clickFirstProduct(); // Navigates to product detail page

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart(); // Clicks Add to cart
        Screenshotutils.takeScreenshot(driver, "AddToCartTest");

    }
}
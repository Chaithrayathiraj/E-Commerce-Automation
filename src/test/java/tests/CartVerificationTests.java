package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.CartPage;
import utils.Screenshotutils;

public class CartVerificationTests extends BaseTest {

    
    @Test
    public void testProductPresenceInCart() {
        driver.get("https://www.demoblaze.com/");

        // Step 1: Click on Samsung galaxy s6
        driver.findElement(By.linkText("Samsung galaxy s6")).click();

        // Step 2: Wait and click 'Add to cart'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']"))).click();

        // Step 3: Wait for alert and accept it
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Step 4: Go to Cart
        driver.findElement(By.id("cartur")).click();

        // Step 5: Validate Product in Cart
        CartPage cartPage = new CartPage(driver);
        String expectedProduct = "Samsung galaxy s6";
        boolean isProductPresent = cartPage.isProductPresent(expectedProduct);

        Assert.assertTrue(isProductPresent, "❌ Product not found in cart: " + expectedProduct);
    }
}

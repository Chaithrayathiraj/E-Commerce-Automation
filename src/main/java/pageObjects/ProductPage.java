package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    private By addToCartButton = By.xpath("//a[text()='Add to cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for button to be clickable, then click
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']")));
        addToCartBtn.click();

        // Wait for and accept alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
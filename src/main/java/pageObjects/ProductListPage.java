package pageObjects;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductListPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locator for first product link
    private By firstProduct = By.xpath("//a[@class='hrefch']");

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickFirstProduct() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        firstProduct.click();
    }
}

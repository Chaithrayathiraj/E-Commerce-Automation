package pageObjects;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By productTitleLocator = By.xpath("//tbody[@id='tbodyid']/tr[1]/td[2]");
    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By cardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseBtn = By.xpath("//button[text()='Purchase']");
    private By confirmationText = By.cssSelector(".sweet-alert > h2");
    private By okButton = By.xpath("//button[text()='OK']");

    // Methods

    public String getProductTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleLocator));
        return titleElement.getText();
    }

    public boolean isProductPresent(String expectedProductName) {
        try {
            String actualProductName = getProductTitle();
            return actualProductName.equalsIgnoreCase(expectedProductName);
        } catch (Exception e) {
            return false;
        }
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
    }

    public void fillPurchaseForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public void clickPurchaseButton() {
        driver.findElement(purchaseBtn).click();
    }

    public String getConfirmationText() {
        return driver.findElement(confirmationText).getText();
    }

    public void clickOK() {
        driver.findElement(okButton).click();
    }
}

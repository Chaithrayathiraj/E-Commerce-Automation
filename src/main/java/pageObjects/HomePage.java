package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Locators
    private By logo = By.id("nava");
    private By loginLink = By.id("login2");
    private By signUpLink = By.id("signin2");
    private By cartLink = By.id("cartur");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickSignUp() {
        driver.findElement(signUpLink).click();
    }

    public void clickCart() {
        driver.findElement(cartLink).click();
    }
}

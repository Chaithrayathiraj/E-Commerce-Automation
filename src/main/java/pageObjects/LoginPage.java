package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Locators
    private By loginLink = By.id("login2");
    private By usernameInput = By.id("loginusername");
    private By passwordInput = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By logoutLink = By.id("logout2");  // to verify successful login

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginModal() {
        driver.findElement(loginLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Optional: Check if logout link is visible to confirm login success
    public boolean isLogoutVisible() {
        return driver.findElements(logoutLink).size() > 0;
    }

    // Combined method to do login
    public void login(String username, String password) {
        openLoginModal();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}

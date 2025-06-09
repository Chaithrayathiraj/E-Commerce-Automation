package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

    WebDriver driver;

    // Locators
    private By signUpLink = By.id("signin2");
    private By usernameInput = By.id("sign-username");
    private By passwordInput = By.id("sign-password");
    private By signUpButton = By.xpath("//button[text()='Sign up']");
    private By closeButton = By.xpath("//div[@id='signInModal']//button[text()='Close']");

    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Click the Sign Up link to open modal
    public void openSignUpModal() {
        driver.findElement(signUpLink).click();
    }

    // Fill username
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    // Fill password
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Click Sign Up button
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    // Click Close button if needed
    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }

    // Combined method to do full sign up flow
    public void signUp(String username, String password) {
        openSignUpModal();
        enterUsername(username);
        enterPassword(password);
        clickSignUpButton();
    }
}

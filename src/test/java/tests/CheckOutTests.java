package tests;




import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import utils.Screenshotutils;

public class CheckOutTests extends BaseTest {

    @Test
    public void testPlaceOrder() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        driver.get("https://www.demoblaze.com/");
        homePage.clickCart();

        cartPage.clickPlaceOrder();

        cartPage.fillPurchaseForm("Chaithra", "India", "Bangalore", "1234567890", "06", "2025");

        cartPage.clickPurchaseButton();

        String confirmation = cartPage.getConfirmationText();
        System.out.println("Confirmation Message: " + confirmation);

        Assert.assertEquals(confirmation, "Thank you for your purchase!");

        cartPage.clickOK();
        Screenshotutils.takeScreenshot(driver, "CheckOutTests");

    }
}

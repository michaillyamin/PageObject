package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CartPage;
import page.PhonePage;

import java.time.Duration;

public class AddPhoneToCartTest {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private static final String EXPECTED_PHONE_NAME = "Zenfone 8";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
    }

    @Test
    public void addItemToCart() {
        new PhonePage(webDriver)
                .openPage()
                .addItemToCart();
        new CartPage(webDriver)
                .openPage();
        WebElement phoneName = new CartPage(webDriver).getNameOfTheAddedPhone();
        Assert.assertEquals(phoneName.getText(), EXPECTED_PHONE_NAME);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
        webDriver = null;
    }
}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SearchPage;

import java.time.Duration;
import java.util.List;

public class SearchByProductNameTest {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private static final String PRODUCT_NAME = "Zenfone";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
    }

    @Test
    public void searchByProductName() {
        List<WebElement> products = new SearchPage(webDriver)
                .openPage()
                .searchProductByName(PRODUCT_NAME);
        Assert.assertTrue(products.size() > 0);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
        webDriver = null;
    }
}

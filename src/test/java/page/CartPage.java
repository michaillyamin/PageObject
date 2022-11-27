package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends AbstractPage{

    private static final String CART_PAGE_URL = "https://uk.store.asus.com/checkout/cart/";
    private static final String EXPECTED_PHONE_XPATH = "//strong[@class='product-item-name']";

    @FindBy(xpath = EXPECTED_PHONE_XPATH)
    private WebElement expectedPhone;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getNameOfTheAddedPhone() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(EXPECTED_PHONE_XPATH)));
        return expectedPhone;
    }

    @Override
    public CartPage openPage() {
        webDriver.get(CART_PAGE_URL);
        return this;
    }
}

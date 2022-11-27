package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.runtime.model.CustomPreview;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PhonePage extends AbstractPage {

    private static final String PHONE_PAGE_URL = "https://uk.store.asus.com/zenfone-8-16764-16764.html";
    private static final String ADD_PHONE_TO_CART_BUTTON_XPATH = "//button[@class='action primary tocart']";
    private static final String CLOSE_COOKIE_XPATH = "//div[@class='btn-asus btn-ok btn-read-ck']";

    @FindBy(xpath = ADD_PHONE_TO_CART_BUTTON_XPATH)
    private WebElement addPhoneToCartButton;

    @FindBy(xpath = CLOSE_COOKIE_XPATH)
    private WebElement closeCookieButton;


    public PhonePage(WebDriver webDriver) {
        super(webDriver);
    }

    public PhonePage addItemToCart() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_COOKIE_XPATH)));
        closeCookieButton.click();

        new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADD_PHONE_TO_CART_BUTTON_XPATH)));
        addPhoneToCartButton.click();

        return this;
    }

    @Override
    public PhonePage openPage() {
        webDriver.get(PHONE_PAGE_URL);
        return this;
    }
}

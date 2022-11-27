package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends AbstractPage{

    private static final String SEARCH_PAGE_URL = "https://www.asus.com/uk/searchresult?searchType=&searchKey=&page=1";
    private static final String SEARCH_INPUT_XPATH = "//input[@class='SearchResultRightArea__searchInput__1Y2Tm']";
    private static final String SEARCH_RESULT_AREA_XPATH = "//div[@class='SearchResultProducts__searchResultProductsWrapper__3RcXk']";
    private static final String CLOSE_COOKIE_XPATH = "//div[@class='btn-asus btn-ok btn-read-ck']";

    @FindBy(xpath = SEARCH_INPUT_XPATH)
    private WebElement searchInput;

    @FindBy(xpath = CLOSE_COOKIE_XPATH)
    private WebElement closeCookieButton;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> searchProductByName(String productName) {
        new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_INPUT_XPATH)));
        searchInput.sendKeys(productName);
        searchInput.sendKeys(Keys.ENTER);

        List<WebElement> listOfProducts = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(SEARCH_RESULT_AREA_XPATH)));

        return listOfProducts;
    }

    @Override
    public SearchPage openPage() {
        webDriver.get(SEARCH_PAGE_URL);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_COOKIE_XPATH)));
        closeCookieButton.click();
        return this;
    }
}

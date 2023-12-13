package ru.boronin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.boronin.test.TestData;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HeadPage {
    public final String url =  "https://www.wildberries.ru/catalog/0/search.aspx?search=";
    public WebDriver driver;
    public Actions actions;
    @FindBy(css = ".product-card__wrapper")
    public List<WebElement> products;

    @FindBy(css = ".product-card-list")
    public WebElement productList;

    @FindBy(css = ".hover .product-card__add-basket")
    public WebElement buttonToBasket;
    @FindBy(xpath = "//a[@href='/lk/basket']")
    WebElement basket;

    public By priceSelector = By.cssSelector(".price__lower-price");
    public By productNameSelector = By.cssSelector("a.product-card__link.j-card-link.j-open-full-product-card");

    public HeadPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public HeadPage search() {
        driver.get(url + TestData.item);
        waitOfVisibility(productList);
        return this;
    }
    public Map<String, String> addProductsToBasket() {
        waitOfVisibility(productList);
        Map<String, String> map = new TreeMap<>();
        int count = 0;
        for (WebElement x:products) {
            waitOfVisibility(productList);
            actions.scrollToElement(x);
            actions.moveToElement(x).build().perform();
            String string = x.findElement(productNameSelector).getAttribute("aria-label");
            String[] strings = string.split(",");
            string = String.join("", strings);
            map.put(string,
                    x.findElement(priceSelector).getText());
            buttonToBasket.click();
            count ++;
            if ( count == 5) {
                break;}
        }
        return map;
    }
    public void waitOfVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until
                (ExpectedConditions.visibilityOf(element));
    }
    public void logIntoBasket() {
        basket.click();
    }
}

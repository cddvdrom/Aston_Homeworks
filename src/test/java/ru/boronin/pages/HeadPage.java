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
import java.util.List;

public class HeadPage {
    public WebDriver driver;
    public WebElement login;
    public Actions actions;
    @FindBy(id = "searchInput")
    public WebElement search;
    @FindBy(css = ".product-card__wrapper")
    public WebElement product;
    @FindBy(css = ".hover .product-card__wrapper")
    public WebElement productCard;
    @FindBy(css = ".hover .product-card__add-basket")
    public WebElement buttonToBasket;

    public HeadPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public HeadPage search() {
        driver.get("https://www.wildberries.ru/catalog/0/search.aspx?search=" + TestData.item);
        waitOfVisibility(product);
        return this;
    }

    public HeadPage addProductsToBasket() {
        waitOfVisibility(product);
        getProductList().stream().forEach((x) -> {
                    actions.moveToElement(x).perform();
                    waitOfVisibility(buttonToBasket);
                    buttonToBasket.click();
                }
        );
        return this;
    }

    public List<WebElement> getProductList() {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-card__wrapper"));
        return products;
    }

    public void waitOfPresent(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until
                (ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitOfVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until
                (ExpectedConditions.visibilityOf(element));
    }
}

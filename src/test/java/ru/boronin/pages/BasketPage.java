package ru.boronin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketPage {
    private WebDriver driver;
    @FindBy(css = "list-item__wrap")
    List<WebElement> items;
    @FindBy(className = "b-top__total")
    WebElement basket;

    public By name = By.cssSelector("span.good-info__good-name");
    public By price = By.cssSelector("list-item__price-new");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Map<String, String> getBasketProducts() {
        waitOfVisibility(basket);

        Map<String, String> map = new HashMap<>();
        for (WebElement item : items
        ) {
            map.put(
                    item.findElement(name).getText(), item.findElement(price).getText()
            );
        }
        return map;
    }
    public void waitOfVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until
                (ExpectedConditions.visibilityOf(element));
    }
}

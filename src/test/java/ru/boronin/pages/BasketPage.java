package ru.boronin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BasketPage {
    private WebDriver driver;
    @FindBy(className = "list-item__wrap")
    List<WebElement> items;
    @FindBy(className = "b-top__total")
    WebElement basket;
    @FindBy(css=".basket-section__header")
    WebElement quantity;
    @FindBy (css = ".b-top__total.line span:nth-child(2)")
    WebElement result;

    public By name = By.cssSelector("span.good-info__good-name");
    public By price = By.className("list-item__price-new");
public By brand = By.className("good-info__good-brand");
    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Map<String, String> getBasketProducts() {
        waitOfVisibility(basket);
        Map<String, String> map = new TreeMap<>();
        for (WebElement item : items
        ) {
            System.out.println(item.findElement(price).getText());
            String [] strings = (item.findElement(name).getText() +item.findElement(brand).getText()).split(",");
            map.put(
                     strings[0]+strings[1], item.findElement(price).getText()
            );
        }
        return map;
    }
    public void waitOfVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until
                (ExpectedConditions.visibilityOf(element));
    }
    public String getQuantity (){
        return quantity.getAttribute("data-count");
    }
    public String getResultSum () {
        return result.getText();
    }
}

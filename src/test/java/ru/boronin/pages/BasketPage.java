package ru.boronin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketPage {
    private WebDriver driver;

    By item = By.cssSelector ( "list-item__good");

    By name = By.cssSelector("span.good-info__good-name");
    By price =By.cssSelector("list-item__price-new");

    public BasketPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
public Map <String,String> getBasketProducts () {
        Map <String,String> map = new HashMap<>();
    for (WebElement w:productList()
         ) {
        map.put(
                w.findElement(name).getText(),w.findElement(price).getText()
        );
    }
        return map;
}
public List<WebElement> productList (){
        List <WebElement> list = new ArrayList<>();
        list = driver.findElements(item);
        return  list;
}
}

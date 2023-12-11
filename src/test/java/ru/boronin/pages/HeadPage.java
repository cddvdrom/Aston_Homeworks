package ru.boronin.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeadPage {
//    private final SelenideElement search = $("#searchInput");
//
//    public void searchProduct (String name){
//        search.setValue(name).pressEnter();
//    }
    @FindBy(xpath = "//*[@id=\"basketContent\"]/div[2]/a")
    public WebElement login;

    @FindBy (id = "searchInput")
    public WebElement search;
}

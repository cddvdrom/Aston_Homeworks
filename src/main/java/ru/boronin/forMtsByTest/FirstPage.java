package ru.boronin.forMtsByTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FirstPage {
    public WebDriver driver;
    public FirstPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")
    private WebElement paySection;
    @FindBy(className = "pay__partners")
    private WebElement payIcons;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[1]/section/div/a")
    private WebElement serviceHref;
    @FindBy(xpath = "//*[@id=\"connection-phone\"]")
    private WebElement inputPhone;

    @FindBy(xpath = "//*[@id=\"connection-sum\"]")
    private WebElement inputMoney;

    @FindBy(xpath = "//*[@id=\"connection-email\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement continueButton;


    public void setInputPhone(String phone) {
        inputPhone.sendKeys(phone);
    }
    public void setInputMoney(String money) {
        inputMoney.sendKeys(money);
    }
    public void setInputEmail(String email) {
        inputEmail.sendKeys(email);
    }
    public void clickContinueBtn() {
        continueButton.click();
    }
    public String getPaySectionText () {
   return paySection.getText();
    }
    public int getQuantityPayIcons (){
       List<WebElement> listPayIcons = payIcons.findElements(By.tagName("img"));
       return listPayIcons.size();
    }
}


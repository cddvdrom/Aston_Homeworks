package ru.boronin.forMtsByTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayFrame {
    private WebDriver driver;
    private Actions actions;
    public PayFrame (WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions=new Actions(driver);
        this.driver = driver;
    }
    @FindBy(id = "cc-number")
    private WebElement cardNumber;
    @FindBy(className = "header__payment-amount")
    private WebElement payForm;
    @FindBy(css = "button[type=\"submit\"]")
    private WebElement payFormButton;
    @FindBy(css = ".header__payment-info")
    private WebElement payPhoneNumber;
    @FindBy(className = "cards-brands")
    private WebElement cardBrands;
    @FindBy(css = ".ng-tns-c47-1 .ng-star-inserted")
    private WebElement cardNumberText;
    @FindBy(css = ".ng-tns-c47-4 .ng-star-inserted")
    private WebElement dateText;
    @FindBy(css = ".ng-tns-c47-5 .ng-star-inserted")
    private WebElement cvvText;
    @FindBy(css = ".ng-tns-c47-3 .ng-star-inserted")
    private WebElement nameText;
    public WebElement getCardNumber() {
        return cardNumber;
    }
    public String getTextSum () {
        return payForm.getText();
    }
    public String getTextButtonSum () {

        return payFormButton.getText();
    }
    public String getPayPhoneNumber () {
        return payPhoneNumber.getText();
    }
    public int getQuantityCardBrands() {
        return cardBrands.findElements(By.tagName("img")).size();
    }
    public String getCardNumberText() {
        return cardNumberText.getText();
    }
    public String getDateText() {
        return dateText.getText();
    }
    public String getCvvText() {
        return cvvText.getText();
    }
    public String getNameText() {
        return nameText.getText();
    }
}

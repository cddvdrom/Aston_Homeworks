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
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/p[1]")
    private WebElement payForm;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/button")
    private WebElement payFormButton;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/p[2]")
    private WebElement payPhoneNumber;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div")
    private WebElement cardBrands;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label")
    private WebElement cardNumberText;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label")
    private WebElement dateText;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label")
    private WebElement cvvText;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label")
    private WebElement nameText;
    public WebElement getCardNumber() {
        return cardNumber;
    }
    public String getTextSum (){
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

package ru.boronin.forMtsByTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    @FindBy(partialLinkText = "Подробнее о сервисе")
    private WebElement moreAboutServiceHref;

    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/p[2]")
    private WebElement headerPaymentInfo;

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

    public void clickHrefMoreAboutService() {
        moreAboutServiceHref.click();
    }

    public String getPaySectionText() {
        return paySection.getText();
    }

    public int getQuantityPayIcons() {
        List<WebElement> listPayIcons = payIcons.findElements(By.tagName("img"));
        return listPayIcons.size();
    }

    public String getHeaderPaymentInfo (){
        return headerPaymentInfo.getText();}
}


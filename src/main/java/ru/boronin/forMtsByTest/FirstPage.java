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
    private WebDriver driver;
    private Actions actions;
    public FirstPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions=new Actions(driver);
        this.driver = driver;
    }
    @FindBy(id = "cookie-agree")
private WebElement cookieAcceptButton;
    @FindBy(xpath = "/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div")
    private WebElement paySection;
    @FindBy(className = "pay__partners")
    private WebElement payIcons;
    @FindBy(id = "connection-phone")
    private WebElement inputPhone;
    @FindBy(id = "connection-sum")
    private WebElement inputMoney;
    @FindBy(id = "connection-email")
    private WebElement inputEmail;
    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement continueButton;
    @FindBy(partialLinkText = "Подробнее о сервисе")
    private WebElement moreAboutServiceHref;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/p[2]")
    private WebElement headerPaymentInfo;
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/div/span[2]")
    private WebElement useCard;
    @FindBy(xpath = "/html/body/div[8]/div/iframe")
    private WebElement paidFrame;
    @FindBy(id = "cc-number")
    private WebElement cardNumber;
    @FindBy(css = "input[placeholder='Номер телефона']")
    private WebElement placeHolderPhone;

    @FindBy(css = "input[placeholder='Сумма']")
    private WebElement placeHolderSum;

    @FindBy(css = "input[placeholder='E-mail для отправки чека']")
    private WebElement placeHolderEmail;

    @FindBy(css = "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper > button")
    private WebElement select;

    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")
    private WebElement select1;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p")
    private WebElement select2;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p")
    private WebElement select3;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")
    private WebElement select4;
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

    public WebElement getCardNumberText() {
        return cardNumberText;
    }

    public WebElement getDateText() {
        return dateText;
    }

    public WebElement getCvvText() {
        return cvvText;
    }

    public WebElement getNameText() {
        return nameText;
    }

    public WebElement getCardBrands() {
        return cardBrands;
    }

    public WebElement getPaidFrame() {
        return paidFrame;
    }

    public WebElement getPaySection() {
        return paySection;
    }

    public void clickSelect (){
        actions.moveToElement(select).click().build().perform();
    }
    public void clickSelect1 (){
        actions.moveToElement(select1).click().build().perform();
        waitVisibilityOfSelect(select1);
    }
    public void clickSelect2 (){
        actions.moveToElement(select2).click().build().perform();
        waitVisibilityOfSelect(select2);
    }
    public void clickSelect3 (){
        actions.moveToElement(select3).click().build().perform();
        waitVisibilityOfSelect(select3);
    }
    public void clickSelect4 (){
        actions.moveToElement(select4).click().build().perform();
        waitVisibilityOfSelect(select4);
    }
    public void waitVisibilityOfSelect (WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(element));
    }
    public String getPaySectionText() {
        return paySection.getText();
    }
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
    public int getQuantityPayIcons() {
        List<WebElement> listPayIcons = payIcons.findElements(By.tagName("img"));
        return listPayIcons.size();
    }
    public void acceptCookies(){
        if (cookieAcceptButton.isDisplayed())
        {
            cookieAcceptButton.click();
        }
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(cookieAcceptButton));
    }
    public WebElement getMoreAboutServiceHref() {
        return moreAboutServiceHref;
    }
    public void checkPaidApp()
    {
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(paidFrame));
        driver.switchTo().frame(paidFrame);
        new WebDriverWait(driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(cardNumber));
    }
    public String getTextUseCard (){
        return useCard.getText();
    }
}


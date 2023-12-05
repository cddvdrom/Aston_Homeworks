package ru.boronin.forMtsByTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        if(cookieAcceptButton.isDisplayed()){
            cookieAcceptButton.click();};
new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(cookieAcceptButton));
    }
    public WebElement getMoreAboutServiceHref() {
        return moreAboutServiceHref;
    }
    public void checkPaidApp()
    {
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bepaid-app")));
        WebElement frame = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(frame);
        new WebDriverWait(driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-number")));
    }
    public String getTextUseCard (){
        return useCard.getText();
    }
}


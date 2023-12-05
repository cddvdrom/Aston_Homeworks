package ru.boronin.forMtsByTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

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

    public String getHeaderPaymentInfo (){
        return headerPaymentInfo.getText();}

    public void fillPaydInfo (String phone,String sum,String email){
        setInputPhone(phone);
        setInputMoney(sum);
        setInputEmail(email);
    }
    public void acceptCookies(WebDriver driver){
        Wait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        waiter.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
        cookieAcceptButton.click();

    }
    public void waitLoadPageByTitle (WebDriver driver,String title){
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.titleIs(title));
    }

    public WebElement getPaySection() {
        return paySection;
    }

    public WebElement getPayIcons() {
        return payIcons;
    }

       public WebElement getInputPhone() {
        return inputPhone;
    }

    public WebElement getInputMoney() {
        return inputMoney;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getMoreAboutServiceHref() {
        return moreAboutServiceHref;
    }
}


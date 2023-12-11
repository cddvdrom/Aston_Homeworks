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
    private ConfProperties confProperties;
    public FirstPage(WebDriver driver,ConfProperties confProperties) {
        PageFactory.initElements(driver, this);
        actions=new Actions(driver);
        this.driver = driver;
        this.confProperties = confProperties;
    }
    private By[] communicationService =
            {
                    By.cssSelector("input[placeholder='Номер телефона']"),
                    By.cssSelector("input[placeholder='Сумма']"),
                    By.cssSelector("input[placeholder='E-mail для отправки чека']"),
            };
    private By[] homeInternet =
            {
                    By.cssSelector("input[placeholder='Номер абонента']"),
                    By.cssSelector("input[placeholder='Сумма']"),
                    By.cssSelector("input[placeholder='E-mail для отправки чека']"),
            };
    private By[] paymentByInstallments =
            {
                    By.cssSelector("input[placeholder='Номер счета на 44']"),
                    By.cssSelector("input[placeholder='Сумма']"),
                    By.cssSelector("input[placeholder='E-mail для отправки чека']"),
            };
    private By[] debt =
            {
                    By.cssSelector("input[placeholder='Номер счета на 2073']"),
                    By.cssSelector("input[placeholder='Сумма']"),
                    By.cssSelector("input[placeholder='E-mail для отправки чека']"),
            };
    @FindBy(id = "cookie-agree")
private WebElement cookieAcceptButton;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")
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
    @FindBy(xpath = "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/div/span[2]")
    private WebElement useCard;
    @FindBy(xpath = "/html/body/div[8]/div/iframe")
    private WebElement paidFrame;
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
    @FindBy (xpath = "/html/body/div[6]/main/div/div[2]")
    private WebElement cookieWindow;
    public void clickSelect () {
        actions.moveToElement(select).click().build().perform();
    }
    public void clickSelect1 () {
        actions.moveToElement(select1).click().build().perform();
        waitVisibilityOfSelect(select1);
    }
    public void clickSelect2 () {
        actions.moveToElement(select2).click().build().perform();
        waitVisibilityOfSelect(select2);
    }
    public void clickSelect3 () {
        actions.moveToElement(select3).click().build().perform();
        waitVisibilityOfSelect(select3);
    }
    public void clickSelect4 () {
        actions.moveToElement(select4).click().build().perform();
        waitVisibilityOfSelect(select4);
    }
    public void waitVisibilityOfSelect (WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(element));
    }
    public WebElement getPaySection () {
        return paySection;
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
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }
    public void clickHrefMoreAboutService() {
        moreAboutServiceHref.click();
    }
    public int getQuantityPayIcons() {
        List<WebElement> listPayIcons = payIcons.findElements(By.tagName("img"));
        return listPayIcons.size();
    }
    public void acceptCookies() {
      try {
          new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(cookieAcceptButton));
          cookieAcceptButton.click();

      }catch (Exception e) {}
    }
        public void getHeadPage() {
            driver.get(confProperties.getProperty("mtsByPage"));
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.titleContains(confProperties.getProperty("titleFirstPage")));
    }
    public WebElement getContinueButton() {
        return continueButton;
    }
    public void checkPaidApp()
    {
        PayFrame payFrame = new PayFrame(driver);
        new WebDriverWait(driver,Duration.ofSeconds(7)).until(ExpectedConditions.visibilityOf(paidFrame));
        driver.switchTo().frame(paidFrame);
        new WebDriverWait(driver,Duration.ofSeconds(7)).
                until(ExpectedConditions.visibilityOf(payFrame.getCardNumber()));
    }
    public String getTextUseCard () {
        return useCard.getText();
    }
    public String getCommunicationService (int n) {
        return driver.findElement(communicationService[n]).getAttribute("placeholder");
    }
    public String getHomeInternet (int n) {
        return driver.findElement(homeInternet[n]).getAttribute("placeholder");
    }
    public String paymentByInstallments (int n) {
        return driver.findElement(paymentByInstallments[n]).getAttribute("placeholder");
    }
    public String debt (int n) {
        return driver.findElement(debt[n]).getAttribute("placeholder");
    }
    public void fillPaydForm (String phone,String sum,String email){
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(continueButton));
        setInputPhone(phone);
        setInputEmail(email);
        setInputMoney(sum);
    }
    public void clickContinueButton () {
        actions.scrollToElement(getContinueButton());
        clickContinueBtn();
    }
    public void switchToPayFrame () {
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(paidFrame));
        driver.switchTo().frame(paidFrame);
        new WebDriverWait(driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-number")));
    }
}


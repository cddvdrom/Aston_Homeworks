import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLSelectElement;
import ru.boronin.forMtsByTest.ConfProperties;
import ru.boronin.forMtsByTest.FirstPage;
import java.time.Duration;


public class TestMtsBy {
    public static FirstPage firstPage;
    public static ConfProperties confProperties;
    public static WebDriver webDriver;
    public static WebElement element;
    public static String mainWindow;

    @BeforeAll
    public static void setup() {
        confProperties = new ConfProperties();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "/src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(confProperties.getProperty("binary"));
        options.addArguments("--lang=ru-RU");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        firstPage = new FirstPage(webDriver);
    }
    @BeforeEach
    public void getHeadPage() {
        webDriver.get(confProperties.getProperty("mtsByPage"));
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.titleIs(confProperties.getProperty("titleFirstPage")));
        firstPage.acceptCookies();
    }
  //  @AfterAll
    public static void afterAll() {
        webDriver.quit();
    }
  //  @Test
    public void onlinePayTextTest() {
        String actual = firstPage.getPaySectionText();
        String expected = confProperties.getProperty("paySectionText");
        Assertions.assertEquals(actual, expected);
    }
  //  @Test
    public void payIconsTest() {
        int actual = firstPage.getQuantityPayIcons();
        int expected = Integer.parseInt(confProperties.getProperty("quantityPayIcons"));
        Assertions.assertEquals(actual, expected);
    }
 //   @Test
    public void moreAboutServiceHref() {
        firstPage.clickHrefMoreAboutService();
        String actual = webDriver.getTitle();
        String expected = confProperties.getProperty("moreAboutServiceTitle");
        Assertions.assertEquals(actual, expected);
    }
  //  @Test
    public void payFormTest() {
        String phone = confProperties.getProperty("phone");
        String sum = confProperties.getProperty("sum");
        String email = confProperties.getProperty("email");
        firstPage.setInputPhone(phone);
        firstPage.setInputEmail(email);
        firstPage.setInputMoney(sum);
        firstPage.clickContinueBtn();
        firstPage.checkPaidApp();
        Assertions.assertEquals(firstPage.getTextUseCard(),confProperties.getProperty("useCardText"));
    }

    @Test
    public void payTextTest() {
        By [] communicationServiceText = {
                By.cssSelector("input[placeholder='Номер телефона']"),
                By.cssSelector("input[placeholder='Сумма']"),
                By.cssSelector("input[placeholder='E-mail для отправки чека']"),
        };

        By [] homeInternet = {
                By.cssSelector("input[placeholder='Номер абонента']"),
                By.cssSelector("input[placeholder='Сумма']"),
                By.cssSelector("input[placeholder='E-mail для отправки чека']"),
        };

        By [] paymentByInstallments = {
                By.cssSelector("input[placeholder='Номер счета на 44']"),
                By.cssSelector("input[placeholder='Сумма']"),
                By.cssSelector("input[placeholder='E-mail для отправки чека']"),
        };
        By [] debt = {
                By.cssSelector("input[placeholder='Номер счета на 2073']"),
                By.cssSelector("input[placeholder='Сумма']"),
                By.cssSelector("input[placeholder='E-mail для отправки чека']"),
        };

        String [] communicationServiceTexts = confProperties.getProperty("communicationServiceText").split(",");
        String [] homeInternetTexts = confProperties.getProperty("homeInternet").split(",");
        String [] paymentByInstallmentsTexts = confProperties.getProperty("paymentByInstallments").split(",");
        String [] debtTexts = confProperties.getProperty("debt").split(",");

        Actions actions = new Actions(webDriver);
        WebElement select = webDriver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper > button"));
        actions.moveToElement(select).click();


        WebElement select1 = webDriver.findElement(By.xpath
                ("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"));
        actions.moveToElement(select1).click();

        Assertions.assertEquals(communicationServiceTexts[0],webDriver.findElement(communicationServiceText[0]).getAttribute("placeholder"));
        Assertions.assertEquals(communicationServiceTexts[1],webDriver.findElement(communicationServiceText[1]).getAttribute("placeholder"));
        Assertions.assertEquals(communicationServiceTexts[2],webDriver.findElement(communicationServiceText[2]).getAttribute("placeholder"));

        actions.moveToElement(select).click();
        WebElement select2 = webDriver.findElement(By.xpath
                ("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p"));
        actions.moveToElement(select2).click();

        Assertions.assertEquals(homeInternet[0],webDriver.findElement(communicationServiceText[0]).getAttribute("placeholder"));
        Assertions.assertEquals(homeInternet[1],webDriver.findElement(communicationServiceText[1]).getAttribute("placeholder"));
        Assertions.assertEquals(homeInternet[2],webDriver.findElement(communicationServiceText[2]).getAttribute("placeholder"));

        actions.moveToElement(select).click();
        WebElement select3 = webDriver.findElement(By.xpath
                ("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p"));
        actions.moveToElement(select3).click();

        Assertions.assertEquals(paymentByInstallments[0],webDriver.findElement(communicationServiceText[0]).getAttribute("placeholder"));
        Assertions.assertEquals(paymentByInstallments[1],webDriver.findElement(communicationServiceText[1]).getAttribute("placeholder"));
        Assertions.assertEquals(paymentByInstallments[2],webDriver.findElement(communicationServiceText[2]).getAttribute("placeholder"));

        actions.moveToElement(select).click();
        WebElement select4 = webDriver.findElement(By.xpath
                ("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p"));
        actions.moveToElement(select4).click();

        Assertions.assertEquals(debt[0],webDriver.findElement(communicationServiceText[0]).getAttribute("placeholder"));
        Assertions.assertEquals(debt[1],webDriver.findElement(communicationServiceText[1]).getAttribute("placeholder"));
        Assertions.assertEquals(debt[2],webDriver.findElement(communicationServiceText[2]).getAttribute("placeholder"));



}
}

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.boronin.forMtsByTest.ConfProperties;
import ru.boronin.forMtsByTest.FirstPage;

import java.time.Duration;
import java.util.List;


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

    @AfterAll
    public static void afterAll() {
        webDriver.quit();
    }

      @Test
    public void onlinePayTextTest() {
        String actual = firstPage.getPaySectionText();
        String expected = confProperties.getProperty("paySectionText");
        Assertions.assertEquals(actual, expected);
    }

      @Test
    public void payIconsTest() {
        int actual = firstPage.getQuantityPayIcons();
        int expected = Integer.parseInt(confProperties.getProperty("quantityPayIcons"));
        Assertions.assertEquals(actual, expected);
    }

       @Test
    public void moreAboutServiceHref() {
        firstPage.clickHrefMoreAboutService();
        String actual = webDriver.getTitle();
        String expected = confProperties.getProperty("moreAboutServiceTitle");
        Assertions.assertEquals(actual, expected);
    }

      @Test
    public void payFormTest() {
        String phone = confProperties.getProperty("phone");
        String sum = confProperties.getProperty("sum");
        String email = confProperties.getProperty("email");
        firstPage.setInputPhone(phone);
        firstPage.setInputEmail(email);
        firstPage.setInputMoney(sum);
        firstPage.clickContinueBtn();
        firstPage.checkPaidApp();
        Assertions.assertEquals(firstPage.getTextUseCard(), confProperties.getProperty("useCardText"));
    }

    @Test
    public void payTextTest() {
        By[] communicationService = {
                By.cssSelector("input[placeholder='Номер телефона']"),
                By.cssSelector("input[placeholder='Сумма']"),
                By.cssSelector("input[placeholder='E-mail для отправки чека']"),
        };
        By[] homeInternet = {
                By.cssSelector("input[placeholder='Номер абонента']"),
                By.cssSelector("input[placeholder='Сумма']"),
                By.cssSelector("input[placeholder='E-mail для отправки чека']"),
        };
        By[] paymentByInstallments = {
                By.cssSelector("input[placeholder='Номер счета на 44']"),
                By.cssSelector("input[placeholder='Сумма']"),
                By.cssSelector("input[placeholder='E-mail для отправки чека']"),
        };
        By[] debt = {
                By.cssSelector("input[placeholder='Номер счета на 2073']"),
                By.cssSelector("input[placeholder='Сумма']"),
                By.cssSelector("input[placeholder='E-mail для отправки чека']"),
        };
        String[] communicationServiceTexts = confProperties.getProperty("communicationServiceText").split(",");
        String[] homeInternetTexts = confProperties.getProperty("homeInternet").split(",");
        String[] paymentByInstallmentsTexts = confProperties.getProperty("paymentByInstallments").split(",");
        String[] debtTexts = confProperties.getProperty("debt").split(",");
        firstPage.clickSelect();
        firstPage.clickSelect1();
        Assertions.assertEquals(communicationServiceTexts[0], webDriver.findElement(communicationService[0]).getAttribute("placeholder"));
        Assertions.assertEquals(communicationServiceTexts[1], webDriver.findElement(communicationService[1]).getAttribute("placeholder"));
        Assertions.assertEquals(communicationServiceTexts[2], webDriver.findElement(communicationService[2]).getAttribute("placeholder"));
        firstPage.clickSelect();
        firstPage.clickSelect2();
        Assertions.assertEquals(homeInternetTexts[0], webDriver.findElement(homeInternet[0]).getAttribute("placeholder"));
        Assertions.assertEquals(homeInternetTexts[1], webDriver.findElement(homeInternet[1]).getAttribute("placeholder"));
        Assertions.assertEquals(homeInternetTexts[2], webDriver.findElement(homeInternet[2]).getAttribute("placeholder"));
        firstPage.clickSelect();
        firstPage.clickSelect3();
        Assertions.assertEquals(paymentByInstallmentsTexts[0], webDriver.findElement(paymentByInstallments[0]).getAttribute("placeholder"));
        Assertions.assertEquals(paymentByInstallmentsTexts[1], webDriver.findElement(paymentByInstallments[1]).getAttribute("placeholder"));
        Assertions.assertEquals(paymentByInstallmentsTexts[2], webDriver.findElement(paymentByInstallments[2]).getAttribute("placeholder"));
        firstPage.clickSelect();
        firstPage.clickSelect4();
        Assertions.assertEquals(debtTexts[0], webDriver.findElement(debt[0]).getAttribute("placeholder"));
        Assertions.assertEquals(debtTexts[1], webDriver.findElement(debt[1]).getAttribute("placeholder"));
        Assertions.assertEquals(debtTexts[2], webDriver.findElement(debt[2]).getAttribute("placeholder"));
        firstPage.clickSelect();
        firstPage.clickSelect1();
        String phone = confProperties.getProperty("phone");
        String sum = confProperties.getProperty("sum");
        String email = confProperties.getProperty("email");
        firstPage.setInputPhone(phone);
        firstPage.setInputEmail(email);
        firstPage.setInputMoney(sum);
        firstPage.clickContinueBtn();
        new WebDriverWait(webDriver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(firstPage.getPaidFrame()));
        webDriver.switchTo().frame(firstPage.getPaidFrame());
        new WebDriverWait(webDriver,Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-number")));
        String actualSum = webDriver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/p[1]")).getText();
        String expectedSum = confProperties.getProperty("sum") + " BYN";
        Assertions.assertEquals(expectedSum,actualSum);
        Assertions.assertEquals("Оплатить "+ expectedSum,webDriver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/button")).getText());

        String actualPhone = webDriver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/p[2]")).getText();
        String expectedPhone = "Оплата: Услуги связи Номер:375" + confProperties.getProperty("phone");
        Assertions.assertEquals(expectedPhone,actualPhone);

        List<WebElement> cardBrands = firstPage.getCardBrands().findElements(By.tagName("img"));
        Assertions.assertEquals(5,cardBrands.size());

        Assertions.assertEquals("Номер карты",firstPage.getCardNumberText().getText());
        Assertions.assertEquals("Срок действия",firstPage.getDateText().getText());
        Assertions.assertEquals("CVC",firstPage.getCvvText().getText());
        Assertions.assertEquals("Имя держателя (как на карте)",firstPage.getNameText().getText());


    }



}

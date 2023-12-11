import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.boronin.forMtsByTest.ConfProperties;
import ru.boronin.forMtsByTest.FirstPage;
import ru.boronin.forMtsByTest.PayFrame;

import java.time.Duration;

public class TestMtsBy {
    public static FirstPage firstPage;
    public static ConfProperties confProperties;
    public static WebDriver webDriver;
    public static PayFrame payFrame;
    public static Actions actions;

    @BeforeAll
    public static void setup() {
        confProperties = new ConfProperties();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        firstPage = new FirstPage(webDriver, confProperties);
        payFrame = new PayFrame(webDriver);
        actions = new Actions(webDriver);
    }

    @BeforeEach
    public void before() {
        firstPage.getHeadPage();
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
        Assertions.assertEquals(expected, actual);
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
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-connection\"]/button")));
        String phone = confProperties.getProperty("phone");
        String sum = confProperties.getProperty("sum");
        String email = confProperties.getProperty("email");
        firstPage.fillPaydForm(phone, sum, email);
        firstPage.clickContinueButton();
        firstPage.checkPaidApp();
        Assertions.assertEquals(firstPage.getTextUseCard(), confProperties.getProperty("useCardText"));
    }

    @Test
    public void payTextTest() {
        String[] communicationServiceTexts = confProperties.getProperty("communicationServiceText").split(",");
        String[] homeInternetTexts = confProperties.getProperty("homeInternet").split(",");
        String[] paymentByInstallmentsTexts = confProperties.getProperty("paymentByInstallments").split(",");
        String[] debtTexts = confProperties.getProperty("debt").split(",");

        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(communicationServiceTexts[i], firstPage.getCommunicationService(i));
        }

        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(homeInternetTexts[i], firstPage.getHomeInternet(i));
        }

        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(paymentByInstallmentsTexts[i], firstPage.paymentByInstallments(i));
        }

        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(debtTexts[i], firstPage.debt(i));
        }

        firstPage.fillForm();
        String actualSum = payFrame.getTextSum();
        String expectedSum = confProperties.getProperty("sum") + " BYN";
        Assertions.assertEquals(expectedSum, actualSum);
        Assertions.assertEquals("Оплатить " + expectedSum, payFrame.getTextButtonSum());

        String actualPhone = payFrame.getPayPhoneNumber();
        String expectedPhone = "Оплата: Услуги связи Номер:375" + confProperties.getProperty("phone");
        Assertions.assertEquals(expectedPhone, actualPhone);
        int actual = payFrame.getQuantityCardBrands();
        int expected = Integer.parseInt(confProperties.getProperty("quantityPaySystem"));
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals("Номер карты", payFrame.getCardNumberText());
        Assertions.assertEquals("Срок действия", payFrame.getDateText());
        Assertions.assertEquals("CVC", payFrame.getCvvText());
        Assertions.assertEquals("Имя держателя (как на карте)", payFrame.getNameText());
    }
}

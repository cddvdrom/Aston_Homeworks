import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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

    @BeforeAll
    public static void setup() {
        confProperties = new ConfProperties();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "/src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(confProperties.getProperty("binary"));
        options.addArguments("--lang=ru-RU");
        webDriver = new ChromeDriver(options);
        firstPage = new FirstPage(webDriver);
         webDriver.manage().window().maximize();

    }

    @AfterAll
    public static void afterAll() {
        //    webDriver.close();
    }

    //  @Test
    @Order(1)
    public void onlinePayTextTest() {
        webDriver.get(confProperties.getProperty("mtsByPage"));
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.titleIs("МТС – мобильный оператор в Беларуси"));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        String actual = firstPage.getPaySectionText();
        String expected = confProperties.getProperty("paySectionText");
        Assertions.assertEquals(actual, expected);
    }

    //  @Test
    @Order(2)
    public void payIconsTest() {
        webDriver.get(confProperties.getProperty("mtsByPage"));
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.titleIs("МТС – мобильный оператор в Беларуси"));
        int actual = firstPage.getQuantityPayIcons();
        int expected = Integer.parseInt(confProperties.getProperty("quantityPayIcons"));
        Assertions.assertEquals(actual, expected);
    }

    //    @Test
    //  @Order(3)
    public void moreAboutServiceHref() {
        firstPage.clickHrefMoreAboutService();
        String actual = webDriver.getTitle();
        String expected = confProperties.getProperty("moreAboutServiceTitle");
        Assertions.assertEquals(actual, expected);
        webDriver.navigate().back();

    }

    @Test
    @Order(4)
    public void payFormTest() {
        webDriver.get(confProperties.getProperty("mtsByPage"));
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("МТС – мобильный оператор в Беларуси"));
        firstPage.setInputPhone(confProperties.getProperty("phone"));
        firstPage.setInputMoney(confProperties.getProperty("sum"));
        firstPage.setInputEmail(confProperties.getProperty("email"));


        new WebDriverWait(webDriver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("cookie-agree")
                ));
        webDriver.findElement(By.id("cookie-agree")).click();


        Wait<WebDriver> waiter = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1));
        waiter.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id=\"pay-connection\"]/button"))).click();

    }
}


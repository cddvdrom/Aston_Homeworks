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
import java.util.NoSuchElementException;
import java.util.function.Function;


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
        webDriver.manage().window().maximize();
        FirstPage page = new FirstPage(webDriver);
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
        webDriver.switchTo().defaultContent();

    }

    @Test
    @Order(4)
    public void payFormTest() {
        webDriver.get(confProperties.getProperty("mtsByPage"));

        webDriver.get(confProperties.getProperty("mtsByPage"));
     //   new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("МТС – мобильный оператор в Беларуси"));
        System.out.println("0");

        String phone = confProperties.getProperty("phone");
        String sum = confProperties.getProperty("sum");
        String email = confProperties.getProperty("email");

        waitForAccesible(By.id("cookie-agree")).click();

        waitForAccesible(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div"));

        webDriver.findElement(By.id("connection-phone")).sendKeys(phone);
        webDriver.findElement(By.id("connection-email")).sendKeys(email);
        webDriver.findElement(By.id("connection-sum")).sendKeys(sum);

webDriver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();
    }
    public WebElement waitForAccesible(By by) {
        Wait <WebDriver> waiter = new FluentWait<> (webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        waiter.until(d-> {
            try {
                WebElement element = webDriver.findElement(by);
                return element.isDisplayed();
            } catch(NoSuchElementException e) {
                return false;
            }
                     }
        );
        return webDriver.findElement(by);
    }
}

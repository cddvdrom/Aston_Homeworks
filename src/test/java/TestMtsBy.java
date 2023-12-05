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
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


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
        mainWindow = webDriver.getWindowHandles().iterator().next();
    }

    @BeforeEach
    public void getHeadPage(){
        webDriver.get(confProperties.getProperty("mtsByPage"));
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("МТС – мобильный оператор в Беларуси"));
        if(webDriver.findElement(By.id("cookie-agree")).isDisplayed()){
        webDriver.findElement(By.id("cookie-agree")).click();};
    }

    @AfterAll
    public static void afterAll() {
        webDriver.close();
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

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-connection\"]/button")));

        webDriver.findElement(By.id("connection-phone")).sendKeys(confProperties.getProperty("phone"));
        webDriver.findElement(By.id("connection-email")).sendKeys(confProperties.getProperty("email"));
        webDriver.findElement(By.id("connection-sum")).sendKeys(confProperties.getProperty("sum"));

        webDriver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();
    }

    public WebElement waitForAccesible(By by) {
        Wait<WebDriver> waiter = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        waiter.until(d -> {
                    try {
                        WebElement element = webDriver.findElement(by);
                        return element.isDisplayed();
                    } catch (NoSuchElementException e) {
                        return false;
                    }
                }
        );
        return webDriver.findElement(by);
    }
}

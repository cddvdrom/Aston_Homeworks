import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.boronin.forMtsByTest.ConfProperties;
import ru.boronin.forMtsByTest.FirstPage;

public class TestMtsBy {
    public static FirstPage firstPage;
    public static ConfProperties confProperties;
    public static WebDriver webDriver;
    @BeforeAll
    public static void setup() {
        confProperties = new ConfProperties();
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +
                           "/src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(confProperties.getProperty("binary"));
        options.addArguments("--lang=ru-RU");
        webDriver = new ChromeDriver(options);
        firstPage = new FirstPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get(confProperties.getProperty("mtsByPage"));
    }
    @Test
    public void onlinePayTextTest () {
        String actual = firstPage.getPaySectionText();
        String expected = confProperties.getProperty("paySectionText");
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void payIconsTest () {
        int actual = firstPage.getQuantityPayIcons();
        int expected = Integer.parseInt(confProperties.getProperty("quantityPayIcons"));
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void moreAboutServiceHref (){
        firstPage.clickHrefMoreAboutService();
        String actual = webDriver.getTitle();
        String expected = confProperties.getProperty("moreAboutServiceTitle");
        Assertions.assertEquals(actual, expected);
        webDriver.navigate().back();
    }

}

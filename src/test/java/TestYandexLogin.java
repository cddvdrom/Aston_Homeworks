import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.boronin.forYandexTest.ConfProperties;
import ru.boronin.forYandexTest.LoginPage;
import ru.boronin.forYandexTest.ProfilePage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestYandexLogin {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static ConfProperties confProperties;
    @BeforeAll
    public static void setup() {
        confProperties = new ConfProperties();
        System.setProperty("webdriver.chrome.driver", new File(
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe").getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.setBinary(confProperties.getProperty("binary"));
        WebDriver webDriver = new ChromeDriver(options);
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(confProperties.getProperty("loginpage"));
    }
    @Test
    public void loginTest() {
        loginPage.inputLogin(confProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(confProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        Assertions.assertEquals(confProperties.getProperty("login"), user);
    }
}

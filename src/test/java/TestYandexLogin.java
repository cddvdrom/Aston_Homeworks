import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.boronin.ConfProperties;
import ru.boronin.LoginPage;
import ru.boronin.ProfilePage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestYandexLogin {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver webDriver;
    public static ConfProperties confProperties;

    @BeforeAll
    public static void setup() {
        confProperties = new ConfProperties();
        System.setProperty("webdriver.chrome.driver", new File(
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe").getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.setBinary(confProperties.getPROPERTIES().getProperty("binary"));
        webDriver = new ChromeDriver(options);
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(confProperties.getPROPERTIES().getProperty("loginpage"));
    }
    @Test
    public void loginTest() {
        loginPage.inputLogin(confProperties.getPROPERTIES().getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(confProperties.getPROPERTIES().getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        Assertions.assertEquals(confProperties.getPROPERTIES().getProperty("login"), user);
    }
}

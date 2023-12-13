package ru.boronin.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.boronin.pages.BasketPage;
import ru.boronin.pages.HeadPage;
import ru.boronin.utils.Utils;

public class TestPage {
    public static WebDriver driver;
    public HeadPage headPage = new HeadPage(driver);
    public BasketPage basketPage = new BasketPage(driver);
    public Utils utils = new Utils();

    @BeforeAll
    static void beforeAll (){
        driver=new ChromeDriver();
    }
    @BeforeEach
    void openHeadPage (){
     driver.manage().window().maximize();
    }
    @AfterEach
    void afterEach () {
            //driver.quit();
    }
}

package ru.boronin.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.boronin.pages.HeadPage;


public class TestPage {
    public static WebDriver driver;
    HeadPage headPage = new HeadPage(driver);

    @BeforeAll
    static void beforeAll (){
        driver=new ChromeDriver();
    }
    @BeforeEach
    void openHeadPage (){
     driver.manage().window().maximize();
    }
    @AfterEach
    void afterEach (){
           // driver.quit();
    }
}

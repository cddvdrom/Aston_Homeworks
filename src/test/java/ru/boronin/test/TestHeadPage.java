package ru.boronin.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.boronin.pages.HeadPage;


public class TestHeadPage {
    public static WebDriver driver;
    HeadPage headPage = new HeadPage();

    @BeforeAll
    static void beforeAll (){
        driver=new ChromeDriver();
    }
    @BeforeEach
    void openHeadPage (){
     driver.get("https://wildberries.ru");
    }
    @AfterEach
    void afterEach (){
           // driver.quit();
    }
}

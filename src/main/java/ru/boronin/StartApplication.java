package ru.boronin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StartApplication {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "/src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
        options.addArguments("--lang=ru-RU");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("connection-phone")).sendKeys("23234");
        driver.findElement(By.id("connection-email")).sendKeys("234234234");
        driver.findElement(By.id("connection-sum")).sendKeys("100");
    }
}

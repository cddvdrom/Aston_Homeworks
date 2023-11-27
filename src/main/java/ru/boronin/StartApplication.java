package ru.boronin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;

public class StartApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(1,2));

        WebDriver driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "/usr/bin/edgeDriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://passport.yandex.ru/auth");
    }
}

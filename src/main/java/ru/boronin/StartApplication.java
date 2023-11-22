package ru.boronin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class StartApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(1,2));

        WebDriver driver = new EdgeDriver();
        System.out.println(driver.getTitle());
    }
}

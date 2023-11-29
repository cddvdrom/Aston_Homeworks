package ru.boronin.forMtsByTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ServicePage {
    public WebDriver driver;

    public ServicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}


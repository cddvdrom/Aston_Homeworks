package ru.boronin.forYandexTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "/html/body/div/div/main/div/section[1]/div/div/ul/li[2]/bdi")
    private WebElement user;
    @FindBy(xpath = "/html/body/div/div/div/div/div/div[6]/a[2]/div[2]/span")
    private WebElement logoutBtn;
    @FindBy(xpath = "/html/body/div/div/header/div/div[2]/button/div/div[1]/img")
    private WebElement rightMenu;
    public String getUserName() {
        return user.getText(); }
    public void userLogout() {
        rightMenu.click();
        logoutBtn.click(); } }

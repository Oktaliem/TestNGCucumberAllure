package com.oktaliem.page;

import com.oktaliem.page.webactions.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by oktaliem
 */
public class LoginPage extends BasePage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "button")
    WebElement loginBtn;

    @FindBy(name = "email")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;


    @Step
    public LoginPage loginToPortal(String username, String password) {
        inputTextBox(this.userName,username);
        inputTextByJSExecutor(this.password,password);
        clickOn(loginBtn);
        saveScreenshotPNG(driver);
        return this;
    }


    @Step
    public LoginPage openURL(String url) {
        driver.get(url);
        saveScreenshotPNG(driver);
        return this;
    }

    @Step
    public LoginPage landingToDashboardPage() {
        checkIfTextIsExpected(By.tagName("h1"),"Dashboard");
        saveScreenshotPNG(driver);
        return this;
    }

    @Step
    public LoginPage verifyErrorMessageDisplayed(String errorMessage) {
        checkIfTextIsExpected(By.className("alert-danger"),errorMessage);
        saveScreenshotPNG(driver);
        return this;
    }
}
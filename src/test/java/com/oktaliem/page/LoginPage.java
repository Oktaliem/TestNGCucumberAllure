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
        Log.info("STEP - login to Portal");
        inputTextBox(this.userName,username);
        inputTextByJSExecutor(this.password,password);
        clickOn(loginBtn);
        saveScreenshotPNG(driver);
        return this;
    }


    @Step
    public LoginPage openURL(String url) {
        Log.info("STEP - open URL");
        driver.get(url);
        saveScreenshotPNG(driver);
        return this;
    }

    @Step
    public void landingToDashboardPage() {
        Log.info("STEP - Landing to dashboard page");
        checkIfTextIsExpected(By.tagName("h1"),"Wizard");
        saveScreenshotPNG(driver);
    }

    @Step
    public void verifyErrorMessageDisplayed(String errorMessage) {
        Log.info("STEP - Verify Error Message Displayed");
        checkIfTextIsExpected(By.className("alert-danger"),errorMessage);
        saveScreenshotPNG(driver);
    }
}
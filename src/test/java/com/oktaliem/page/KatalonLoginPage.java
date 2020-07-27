package com.oktaliem.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class KatalonLoginPage extends BasePage {

    public KatalonLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Sign In")
    private WebElement loginBtn;

    @FindBy(id = "user_email")
    private WebElement userName;

    @FindBy(id = "user_pass")
    private WebElement password;

    @FindBy(xpath = "//div[@class='col-lg-6 col-right-content form-toggle sign-in-form-toggle']//div//span[@class='checkmark']")
    private WebElement checkBox;

    @FindBy(id = "login-btn")
    private WebElement signInBtn;

    @FindBy(className = "error-general-btn")
    private WebElement message;

    @Step
    public void goToKatalonPortal(String url) {
        goToWeb(url);
    }

    @Step
    public void loginWithCredential(String email, String password) {
        clickOn(loginBtn);
        refreshPage();
        fluentWait(userName,100000,500);
        inputTextBox(userName,email);
        inputTextBox(this.password,password);
        clickOn(checkBox);
        clickElementViaJSExecutor(signInBtn);
        saveScreenshotPNG(driver);
    }

    @Step
    public void errorMessageWillBeDisplayed(String message) {
        waitUntilLocatorIsVisible(By.className("error-general"),6);
        String errorMessage = getTextFromElement(By.className("error-general"));
        Assert.assertEquals(errorMessage,message);
        saveScreenshotPNG(driver);
    }
}

package com.oktaliem.page;

import com.github.javafaker.Faker;
import com.oktaliem.page.webactions.BaseActions;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

/**
 * Created by oktaliem
 */
public class BasePage extends BaseActions {

    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    protected Faker testData = new Faker(new Locale("en_SG"));

    @Step
    public void openSideBarMenu(String menu) {
        String element = "//a[contains(.,'" + menu + "')]";
        WebElement el = driver.findElement(By.xpath(element));
        fluentWait(el, 60000, 500);
        clickOn(el);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

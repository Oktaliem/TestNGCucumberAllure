package com.oktaliem.stepdefs;

import com.oktaliem.UserAccess;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oktaliem
 */
public class BaseStepDef {
    protected static WebDriver driver;
    public UserAccess okta_is_on;


    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        okta_is_on = new UserAccess(driver);
        return driver;
    }


}

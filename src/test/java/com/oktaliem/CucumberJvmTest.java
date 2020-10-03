package com.oktaliem;

import com.oktaliem.page.webactions.Log;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by oktaliem
 */
@CucumberOptions(features = {"src/test/resources/features"})
public class CucumberJvmTest extends AbstractTestNGCucumberTests {
    protected WebDriver driver;

    public void updateTestCaseStatusInJira(String no, String status) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.google.com/";
        driver.get(url);
        if (status.equals("failed")) {
            driver.findElement(By.name("q")).sendKeys("yah " + no + " Gagal");
            driver.navigate().to(url + no);
        }
        if (status.equals("passed")) {
            driver.findElement(By.name("q")).sendKeys("OK " + no + " Berhasil");
            driver.navigate().to(url + no);
        }
        driver.quit();
    }


    @Before
    public void before(Scenario scenario) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println(" _____ _____ ____ _____   ____ _____  _    ____ _____ _____ ____  ");
        System.out.println("|_   _| ____/ ___|_   _| / ___|_   _|/ \\  |  _ \\_   _| ____|  _ \\ ");
        System.out.println("  | | |  _| \\___ \\ | |   \\___ \\ | | / _ \\ | |_) || | |  _| | | | |");
        System.out.println("  | | | |___ ___) || |    ___) || |/ ___ \\|  _ < | | | |___| |_| |");
        System.out.println("  |_| |_____|____/ |_|   |____/ |_/_/   \\_\\_| \\_\\|_| |_____|____/ ");
        System.out.println("-------------------------------------------------------------------------------------");
        Log.info("I am on Scenario: " + scenario.getName());
        Log.info("With Tag: " + scenario.getSourceTagNames());
    }

    @After
    public void after(Scenario scenario) {
        Log.info("Test result for Feature and Scenario : " + scenario.getId() + " " + scenario.getStatus());
        System.out.println(scenario.getStatus());
        String testStatus = scenario.getStatus();
        String[] tagNames = scenario.getSourceTagNames().toArray(new String[0]);
        String jiraNumber = (String) Array.get(tagNames, 0);
        System.out.println(jiraNumber.substring(1));
        updateTestCaseStatusInJira(jiraNumber.substring(1), testStatus);
    }

}
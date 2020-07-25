package com.oktaliem;

import com.oktaliem.page.webactions.Log;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeMethod;

/**
 * Created by oktaliem
 */
@CucumberOptions(features = {"src/test/resources/features"})
public class CucumberJvmTest extends AbstractTestNGCucumberTests {

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
        Log.info("Test result for Feature and Scenario : " + scenario.getId()+" "+scenario.getStatus());
    }
}
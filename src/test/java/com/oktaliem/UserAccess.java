package com.oktaliem;

import com.oktaliem.page.*;
import com.oktaliem.page.DashboardPage;
import com.oktaliem.stepdefs.KatalonStepDefs;
import org.openqa.selenium.WebDriver;

/**
 * Created by oktaliem
 */
public class UserAccess {

    WebDriver driver;

    public UserAccess(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {return new LoginPage(driver);}
    public DashboardPage dashboardPage(){return new DashboardPage(driver);}
    public ItemsPage itemsPage(){return new ItemsPage(driver);}
    public KatalonLoginPage katalonLoginPage(){return new KatalonLoginPage(driver);}
}


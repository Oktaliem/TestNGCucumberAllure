package com.oktaliem.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LoginStepDef extends BaseStepDef {
    public WebDriver driver = getDriver();

    @Given("^I go to (.*)$")
    public void userGoesToAkauntingPortal(String url) {
        okta_is_on.loginPage().openURL(url);
    }

    @And("^I login with valid the username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginWithValidTheUsernameAndPassword(String userName, String password) {
        okta_is_on.loginPage().loginToPortal(userName, password);
    }

    @Then("^I can login successfully$")
    public void iCanLoginSuccessfully() {
        okta_is_on.loginPage().landingToDashboardPage();
    }

    @Then("^I will see error message \"([^\"]*)\"$")
    public void iWillSeeErrorMessage(String errorMessage) throws Throwable {
        okta_is_on.loginPage().verifyErrorMessageDisplayed(errorMessage);
    }

    @Given("^login to \"([^\"]*)\" with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void loginToWithUsernameAndPassword(String url, String userName, String password) throws Throwable {
       okta_is_on.loginPage().openURL(url);
       okta_is_on.loginPage().loginToPortal(userName,password);
       okta_is_on.loginPage().landingToDashboardPage();
    }


    @After
    public void teardown() {
        driver.quit();
    }

}

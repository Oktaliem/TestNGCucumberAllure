package com.oktaliem.stepdefs;


import com.oktaliem.UserAccess;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class KatalonStepDefs extends BaseStepDef {
    public WebDriver driver = getDriver();

    @When("^I'm landing to katalon portal$")
    public void iMLandingToKatalonPortal() {
        okta_is_on.katalonLoginPage().goToKatalonPortal("https://www.katalon.com/");
    }

    @And("^I'm sign in with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iMSignInWithEmailAndPassword(String email, String password) throws Throwable {
        okta_is_on.katalonLoginPage().loginWithCredential(email, password);

    }

    @Then("^I'm unable to sign in and error message will be displayed \"([^\"]*)\"$")
    public void iMUnableToSignInAndErrorMessageWillBeDisplayed(String message) throws Throwable {
        okta_is_on.katalonLoginPage().errorMessageWillBeDisplayed(message);
    }


    @After
    public void teardown() {
        driver.quit();
    }

}

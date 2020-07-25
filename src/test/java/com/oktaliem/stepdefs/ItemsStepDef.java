package com.oktaliem.stepdefs;

import com.oktaliem.UserAccess;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * Created by oktaliem
 */
public class ItemsStepDef extends BaseStepDef {
    List<String> result;

    @When("^I fill out the form$")
    public void iFillOutTheForm() {
        okta_is_on = new UserAccess(driver);
        okta_is_on.dashboardPage().openSideBarMenu("Items");
        result = okta_is_on.itemsPage().fillOutAddItemsFrom();
    }

    @Then("^I am able to create new item$")
    public void iAmAbleToCreateNewItem() {
        okta_is_on.itemsPage().resultWillBeDisplayedOnTheItemList(result);
    }
}

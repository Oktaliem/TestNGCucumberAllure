package com.oktaliem.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oktaliem
 */
public class ItemsPage extends BasePage {

    public ItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "new-button")
    private WebElement addNewForm;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "sku")
    private WebElement sku;

    @FindBy(id = "sale_price")
    private WebElement salePrice;

    @FindBy(id = "purchase_price")
    private WebElement purchasePrice;

    @FindBy(className = "button-submit")
    private WebElement saveBtn;

    @FindBys({
            @FindBy(tagName = "tbody"),
            @FindBy(tagName = "tr")
    })
    private List<WebElement> itemTable;

    @FindBy(name = "search")
    private WebElement searchFields;

    @FindBy(className = "btn-filter")
    private WebElement filterBtn;

    @Step
    public List<String> fillOutAddItemsFrom() {
        String name = testData.name().firstName();
        String sku = testData.random().hex();
        String description = testData.random().hex(1000);
        String salePrice = "20";
        String purchasePrice = "21";
        String category = "Makanan";

        clickOn(addNewForm);
        inputTextBox(this.name, name);
        inputTextBox(this.sku, sku);
        inputTextBox(By.id("description"), description);
        inputTextBox(this.salePrice, salePrice);
        inputTextBox(this.purchasePrice, purchasePrice);
        selectTax("2");
        selectCategory(category);
        saveScreenshotPNG(driver);
        clickOn(saveBtn);

        List<String> result = new ArrayList<>();
        result.add(name);
        result.add(sku);
        result.add(description);
        result.add(salePrice);
        result.add(purchasePrice);
        result.add(category);
        result.add("1");
        return result;
    }

    private void selectTax(String tax) {
        clickOn(By.id("select2-tax_id-container"));
        inputTextBox(By.className("select2-search__field"), tax);
    }

    private void selectCategory(String category) {
        clickOn(By.id("select2-category_id-container"));
        List<WebElement> els = driver.findElements(By.className("select2-results__option"));
        for (WebElement el : els) {
            if (el.getText().equals(category)) {
                clickOn(el);
            }
        }
    }

    @Step
    public void resultWillBeDisplayedOnTheItemList(List<String> result) {
        saveScreenshotPNG(driver);
        String nameExpected = result.get(0);
        String categoryExpected = result.get(5);
        String quantityExpected = result.get(6);
        String purchasePriceEx = result.get(4);

        inputTextBox(searchFields, nameExpected);
        clickOn(filterBtn);
        saveScreenshotPNG(driver);

        List<WebElement> firstRow = itemTable.get(0).findElements(By.tagName("td"));
        String nameActual = firstRow.get(1).getText();
        String categoryActual = firstRow.get(2).getText();
        String quantityActual = firstRow.get(3).getText();
        String purchasePriceAc = firstRow.get(5).getText();

        Assert.assertEquals(nameActual, nameExpected);
        Assert.assertEquals(categoryActual, categoryExpected);
        Assert.assertEquals(quantityActual, quantityExpected);
        Assert.assertEquals(purchasePriceAc, "$" + purchasePriceEx + ".00");
    }

}

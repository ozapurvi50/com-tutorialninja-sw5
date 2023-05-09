package com.tutorialninja.demo.sw5.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.demo.sw5.customlisteners.CustomListeners;
import com.tutorialninja.demo.sw5.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class LaptopAndNotebooksPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNoteBooksText;

    By productsPrices = By.xpath("//p[@class ='price']");

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement path;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement product;

    String text = "Price (High > Low)";

    By productsList = By.xpath("//h4/a");

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> sortOut;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement path4;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement sendQuantity;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement update;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement path5;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement path6;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkOutButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement path7;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement path8;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement path1;


    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement path2;

    public String getLaptopsAndNotebooksText() {
        CustomListeners.test.log(Status.PASS, "Click on Laptops and Notebooks ");
        Reporter.log(" Click on Laptops and Notebooks ");
        return getTextFromElement(laptopsAndNoteBooksText);
    }

    public String getMessage1() {

        return getTextFromElement(path2);
    }

    public void sortOutPriceHighToLow() {

        selectByVisibleTextFromDropDown(path, text);
    }

    public ArrayList<Double> getProductsPriceList() {
        List<WebElement> products = getListOfElements(productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        CustomListeners.test.log(Status.PASS, "Sort out Products ");
        Reporter.log(" Sort out Products ");
        return originalProductsPrice;
    }

    public void arrangePriceWise() {
        arrangeProductsPriceWise(sortOut);
    }

    public void selectSortByOption(String option) {

        CustomListeners.test.log(Status.PASS, "Sort by  ");
        Reporter.log(" Sort by ");
        selectByVisibleTextFromDropDown(sortBy, option);
    }

    public void selectProductByName(String product) {
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnProduct() {
        Reporter.log("Click on Product ");
        clickOnElement(product);
        CustomListeners.test.log(Status.PASS, "click on Product");

    }

    public String getMessage() {

        return getTextFromElement(path1);
    }

    public void shoppingCart() {
        Reporter.log("Click on shoppinCart ");
        clickOnElement(shoppingCart);
        CustomListeners.test.log(Status.PASS, "Click on shoppingCart");
    }

    public String getMessage3() {
        return getTextFromElement(path4);
    }

    public void sendQuantity(String text) {
        Reporter.log("Send text to quantity ");
        sendTextToElement(sendQuantity, text);
        CustomListeners.test.log(Status.PASS, "Send text to quantity ");

    }

    public void update() {
        Reporter.log("Click on Update ");
        clickOnElement(update);
        CustomListeners.test.log(Status.PASS, "Click on Update ");
    }

    public String getMessage4() {

        return getTextFromElement(path5);
    }

    public String getMessage5() {
        return getTextFromElement(path6);
    }

    //Click on checkout button
    public void checkOut() {
        Reporter.log("Click on Checkout ");
        clickOnElement(checkOutButton);
        CustomListeners.test.log(Status.PASS, "Click on Checkout");
    }

    public String getMessage6() {
        return getTextFromElement(path7);
    }
}
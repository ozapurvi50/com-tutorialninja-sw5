package com.tutorialninja.demo.sw5.pages;

import com.tutorialninja.demo.sw5.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement datePicker;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;

    @CacheLookup
    @FindBy (xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;

    @CacheLookup
    @FindBy (css = "#input-quantity")
    WebElement qtyField;

    @CacheLookup
    @FindBy (xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy (css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    @CacheLookup
    @FindBy (xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy (xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement path3;

    @CacheLookup
    @FindBy (xpath = "//button[@id='button-cart']")
    WebElement cartButton;

    public void addToCart() {

        clickOnElement(cartButton);
    }



    public String getMessage2() {
        return
                getTextFromElement(path3);
    }
    public String getProductText() {
        return getTextFromElement(productText);
    }

    public void selectDeliveryDate(String day, String month, String year) {
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
    }
    public void enterQuantity(String qty) {
        sendTextToElement(qtyField, qty);
    }

    public void clearQuantity(String qty) {
       qtyField.clear();

    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public String getProductAddedSuccessMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        clickOnElement(shoppingCartLink);
    }

}

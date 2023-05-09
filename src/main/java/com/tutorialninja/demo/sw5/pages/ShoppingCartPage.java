package com.tutorialninja.demo.sw5.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.demo.sw5.customlisteners.CustomListeners;
import com.tutorialninja.demo.sw5.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import javax.rmi.CORBA.Util;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//small[normalize-space()='Delivery Date:2011-04-22']")
    WebElement deliveryDate;


    @CacheLookup
    @FindBy (xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;

    @CacheLookup
    @FindBy (xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    @CacheLookup
    @FindBy (xpath = "//input[@id='input-payment-firstname']")
    WebElement name;

    @CacheLookup
    @FindBy (xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;

    @CacheLookup
    @FindBy (xpath = "//input[@id='input-payment-email']")
    WebElement email;

    @CacheLookup
    @FindBy (xpath = "//input[@id='input-payment-telephone']")
    WebElement phone;

    @CacheLookup
    @FindBy (xpath = "//input[@id='input-payment-address-1']")
    WebElement address;

    @CacheLookup
    @FindBy (xpath = "//input[@id='input-payment-city']")
    WebElement city;

    @CacheLookup
    @FindBy (xpath = "//input[@id='input-payment-postcode']")
    WebElement postcode;

    @CacheLookup
    @FindBy (xpath = "//select[@id='input-payment-zone']")
    WebElement payzone;

    @CacheLookup
    @FindBy (xpath = "//input[@value='guest']")
    WebElement continueButtons;

    @CacheLookup
    @FindBy (xpath = "#button-account")
    WebElement guestContinue;

    @CacheLookup
    @FindBy (xpath = "#button-guestt")
    WebElement continueRegisterButton;


    public void clickOnContinueButton() {
        clickOnElement(continueButtons);
    }

    public void sendName(String text) {
        sendTextToElement(name, text);
    }

    public void sendLastName(String text) {
        sendTextToElement(lastName, text);
    }

    public void sendAddress(String text) {
        sendTextToElement(address, text);
    }

    public void sendEmail(String text) {
        sendTextToElement(email, text);
    }

    public void sendTelephone(String text) {
        sendTextToElement(phone, text);
    }

    public void sendCity(String text) {
        sendTextToElement(city, text);
    }

    public void sendPostCode(String text) {
        sendTextToElement(postcode, text);
    }

    public void enterRegion(String text) {
        selectByVisibleTextFromDropDown(payzone, text);
    }


    public void continueRegister() {
        clickOnElement(continueRegisterButton);
    }

    public void clickContinue(){

        clickOnElement(guestContinue);
    }


    public String getShoppingCartText() {
        Reporter.log("Get ShoppingCart" );
        CustomListeners.test.log(Status.PASS,"Get shoppingCart");
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        Reporter.log("Get Product Name");
        CustomListeners.test.log(Status.PASS,"Get Product Name");
        return getTextFromElement(productName);

    }

    public String getDeliveryDate() {
        Reporter.log("Get Delivery date");
        CustomListeners.test.log(Status.PASS,"Get Delivery date");
        return getTextFromElement(deliveryDate);

    }

    public String getModel() {
        Reporter.log("Get Model" );
        CustomListeners.test.log(Status.PASS, "Get Model");
        return getTextFromElement(model);
    }

    public String getTotal() {
        Reporter.log("Get Total");
        CustomListeners.test.log(Status.PASS,"Get Total");
        return getTextFromElement(total);

    }
}


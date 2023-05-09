package com.tutorialninja.demo.sw5.pages;

import com.tutorialninja.demo.sw5.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement textBox;

    @CacheLookup
    @FindBy(id = "button-shipping-method")
    WebElement shippingMethod;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(), 'Warning: Payment method required!')]")
    WebElement path9;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyPolicy;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement guestContinue;


    public void sendTextToTextbox(String text) {

        sendTextToElement(textBox, text);
    }
    public void button(){

        clickOnElement(shippingMethod);
    }
    public String getMessage8() {

        return getTextFromElement(path9);
    }
    public void clickOnPrivacyPolicy() {

        clickOnElement(privacyPolicy);
    }
    public void clickContinue(){

        clickOnElement(guestContinue);}

}

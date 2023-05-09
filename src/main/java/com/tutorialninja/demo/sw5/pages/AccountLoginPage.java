package com.tutorialninja.demo.sw5.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.demo.sw5.customlisteners.CustomListeners;
import com.tutorialninja.demo.sw5.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import java.util.List;

public class AccountLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(id="input-email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(id="input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement message1;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
    List <WebElement> logout;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement verify;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continubtn2;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccount;

    public String getMessage1() {

        return getTextFromElement(message1);   // method to verify Logout
    }

    public void enterEmailAddress(String email) {

        sendTextToElement(emailAddressField, email);
        CustomListeners.test.log(Status.PASS, "Enter email address");
        Reporter.log(" Enter correct email" + emailAddressField.toString());
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter password ");
        Reporter.log(" Enter correct password " + passwordField.toString());

    }

    public void loginToApplication(String email, String password){
        enterEmailAddress(email);
        enterPassword(password);
    }

    public String getReturningCustomerText() {
        CustomListeners.test.log(Status.PASS, "Enter message ");
        Reporter.log(" Get message of Returning customer " + returningCustomerText.toString());
        String message = getTextFromElement(returningCustomerText);
        return message;

    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS, "click on Login Button");
        Reporter.log("Click on  " + loginBtn + " submit button " + loginBtn.toString());
    }

    By linkLogOut=By.xpath("//a[normalize-space()='Logout']");
    public void mouseHoverOnLogOutAndClick(){

        clickOnElement(linkLogOut);
    }
    public void clickOnMyAccountLogin() {

        clickOnElement(myAccount);



    }


    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = logout;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = logout;
        }
    }

    public String getMessage() {
        return getTextFromElement(verify);   // method to verify Logout
    }

    public void clickOnContinueButton2() {
        Reporter.log(" Click on continue " + continubtn2.toString());
        clickOnElement(continubtn2);
        CustomListeners.test.log(Status.PASS, "Click on continue ");
    }
}

package com.tutorialninja.demo.sw5.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.demo.sw5.customlisteners.CustomListeners;
import com.tutorialninja.demo.sw5.utility.Utility;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class AccountRegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement name1;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement phone;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement passWord;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement conPassword;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    WebElement radioButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn1;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn2;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement path1;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> accountList;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement verify2;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continubtn2;

    public String getRegisterAccountText() {
        return getTextFromElement(registerAccountText);
    }

    public void enterName(String name) {
        Reporter.log(" Enter correct name" + name);
        sendTextToElement(name1, name);
        CustomListeners.test.log(Status.PASS, "Enter Name" + name);
    }

    public void enterLastName(String lastname) {
        Reporter.log(" Enter correct lastname" + lastname);
        sendTextToElement(lastName, lastname);
        CustomListeners.test.log(Status.PASS, "Enter Last Name" + lastname);
    }

    public void enterEmailAddress(String email) {
        Reporter.log(" Enter correct email" + email);
        sendTextToElement(emailAddress, email);
        CustomListeners.test.log(Status.PASS, "Enter email address" + email);
    }

    public void enterPassword(String password) {
        Reporter.log(" Enter correct password " + password);
        sendTextToElement(passWord, password);
        CustomListeners.test.log(Status.PASS, "Enter password " + password);
    }

    public void enterTelephone(String telephone) {
        Reporter.log(" Enter correct telephone " + telephone);
        sendTextToElement(phone, telephone);
        CustomListeners.test.log(Status.PASS, "Enter Phone no. " + telephone);
    }

    public void enterConfirmPassword(String cofpassword) {
        Reporter.log(" Enter correct confirm password " + cofpassword);
        sendTextToElement(conPassword, cofpassword);
        CustomListeners.test.log(Status.PASS, "Confirm password " + cofpassword);
    }

    public void clickOnRadioButton(String details) {
        Reporter.log(" Enter correct confirm password " + details);
        clickOnElement(radioButton);                  //Clicking on subscription radio buttons
        CustomListeners.test.log(Status.PASS, "click on radio button yes " + details);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log(" Click on Checkbox " + privacyPolicyCheckBox.toString());
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS, "Click on Checkbox ");
    }

    public void clickOnContinueButton() {
        Reporter.log(" Click on continue " + continueBtn.toString());
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS, "Click on continue ");
    }

    public String getMessage1() {
        return getTextFromElement(path1);   // method to verify Account Created
    }

    public void clickOnContinueButton1() {
        Reporter.log(" Click on continue " + continueBtn1.toString());
        clickOnElement(continueBtn1);
        CustomListeners.test.log(Status.PASS, "Click on continue ");
    }

    public void clickOnMyAccount() {
        clickOnElement(myAccount);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = accountList;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = accountList;
        }
    }

    public String getMessage2() {
        return getTextFromElement(verify2);   // method to verify Logout
    }


    public void clickOnContinueButton2() {
        Reporter.log(" Click on continue " + continubtn2.toString());
        clickOnElement(continubtn2);
        CustomListeners.test.log(Status.PASS, "Click on continue ");
    }
}

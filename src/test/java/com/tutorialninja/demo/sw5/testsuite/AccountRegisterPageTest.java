package com.tutorialninja.demo.sw5.testsuite;

import com.tutorialninja.demo.sw5.pages.AccountRegisterPage;
import com.tutorialninja.demo.sw5.pages.HomePage;
import com.tutorialninja.demo.sw5.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.time.Duration;

public class AccountRegisterPageTest extends BaseTest {


    AccountRegisterPage accountRegisterPage;
    HomePage homePage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        accountRegisterPage = new AccountRegisterPage();

    }

    @Test (groups = {"sanity", "regression"},dataProvider = "credentials", dataProviderClass = TestData .class)

    public void registerDetails(String name,String lastname,String email, String telephone, String password, String cofpassword) {

        //Click on My Account Link.
        //Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.clickOnMyAccountRegister();

        //Verify the text “Register Account”.
        Assert.assertEquals(accountRegisterPage.getRegisterAccountText(), "Register Account", "Register page not displayed");

        //Enter First Name
        accountRegisterPage.enterName(name);

        //Enter Last Name
        accountRegisterPage.enterLastName(lastname);

        //Enter Email
        accountRegisterPage.enterEmailAddress(email);

        //Enter Telephone
        accountRegisterPage.enterTelephone(telephone);

        //Enter Password
        accountRegisterPage.enterPassword(password);

        //Enter Password Confirm
        accountRegisterPage.enterConfirmPassword(cofpassword);

        //Select Subscribe Yes radio button
        accountRegisterPage.clickOnRadioButton("Yes");

        //Click on Privacy Policy check box
        accountRegisterPage.clickOnPrivacyPolicyCheckBox();

        //Click on Continue button
        accountRegisterPage.clickOnContinueButton();

        //Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(accountRegisterPage.getMessage1(), "Your Account Has Been Created!", "Content doesn't match");

        //Click on Continue button
        accountRegisterPage.clickOnContinueButton1();

        //Click on My Account Link.
        accountRegisterPage.clickOnMyAccount();

        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountRegisterPage.selectMyAccountOptions("Logout");

        //Verify the message “Account Logout”
        Assert.assertEquals(accountRegisterPage.getMessage2(), "Account Logout", "Not logged out");

        //Click on Continue button
        accountRegisterPage.clickOnContinueButton2();
    }



}

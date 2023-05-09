package com.tutorialninja.demo.sw5.testsuite;

import com.tutorialninja.demo.sw5.pages.AccountLoginPage;
import com.tutorialninja.demo.sw5.pages.HomePage;
import com.tutorialninja.demo.sw5.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.time.Duration;

public class AccountLoginPageTest extends BaseTest {

    AccountLoginPage accountLoginPage;
    HomePage homePage;

    @BeforeMethod
    public void inIt() {

        accountLoginPage = new AccountLoginPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"}, dataProvider = "details", dataProviderClass = TestData.class)
    public void loginToApplication(String email, String password) throws InterruptedException {

        //Change currency to Pounds
        homePage.selectCurrency("£Pound Sterling");

        //Click on My Account Link.
        Thread.sleep(3000);
        homePage.clickOnMyAccountLogin();

        //verify returning customer text
        Assert.assertEquals(accountLoginPage.getMessage1(), "Returning Customer", "Not matched");

        //Enter email and password in email and password field
        accountLoginPage.loginToApplication(email, password);

        //Click on login button
        accountLoginPage.clickOnLoginButton();

        //Click on myAccount
        accountLoginPage.clickOnMyAccountLogin();

        //Click on Logout button
        accountLoginPage.mouseHoverOnLogOutAndClick();

        //Click on Logout Button
        accountLoginPage.selectMyAccountOptions("Logout");

        //Verify the message “Account Logout”
        Assert.assertEquals(accountLoginPage.getMessage(), "Account Logout", "Not logged out");

        //Click on continue button
        accountLoginPage.clickOnContinueButton2();

    }


}

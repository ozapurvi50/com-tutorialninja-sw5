package com.tutorialninja.demo.sw5.testsuite;

import com.tutorialninja.demo.sw5.pages.AccountLoginPage;
import com.tutorialninja.demo.sw5.pages.ComponentsPage;
import com.tutorialninja.demo.sw5.pages.HomePage;
import com.tutorialninja.demo.sw5.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {


    HomePage homePage;
    ComponentsPage component;


    @BeforeMethod
    public void inIt() {

        homePage = new HomePage();
        component = new ComponentsPage();
    }

    @Test (groups = {"sanity", "regression"})
    public void userShouldNavigateToLaptopAndNotebookTabSuccessfully() {

        homePage.clickOnLaptopAndNotebooks();
    }

    @Test(groups = {"smoke", "regression"})
    public void userShouldNavigateToDesktopTabSuccessfully() {
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");

    }

    public void verifyCompnonenTopMenuTab(){
        component.clickOnHomePageButtons2();
        component.getMessage2();
    }

}

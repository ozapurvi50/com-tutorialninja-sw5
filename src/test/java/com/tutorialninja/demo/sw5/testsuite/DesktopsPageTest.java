package com.tutorialninja.demo.sw5.testsuite;

import com.tutorialninja.demo.sw5.pages.DesktopPage;
import com.tutorialninja.demo.sw5.pages.HomePage;
import com.tutorialninja.demo.sw5.pages.ProductPage;
import com.tutorialninja.demo.sw5.pages.ShoppingCartPage;
import com.tutorialninja.demo.sw5.testbase.BaseTest;
import com.tutorialninja.demo.sw5.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class DesktopsPageTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;

    ShoppingCartPage cartPage = new ShoppingCartPage();

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();

    }

    @Test (groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {

        Thread.sleep(3000);
        homePage.selectCurrency("£Pound Sterling");

        //Mousehover over Desktop
        homePage.mouseHoverOnDesktopsLinkAndClick();

        //Mousehover over Desktop and click on Show AllDesktop tab
        homePage.selectMenu("Show AllDesktops");

        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = desktopPage.getProductsNameList();

        // Sort By Reverse order
        Collections.reverse(originalProductsName);

        // Select sort by Name Z - A
        desktopPage.selectSortByOption("Name (Z - A)");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {

        homePage.selectCurrency("£Pound Sterling");

        homePage.mouseHoverOnDesktopsLinkAndClick();

        //Mousehover over Desktop and click on Show AllDesktop tab
        homePage.selectMenu("Show AllDesktops");

        //Select sortBy A to Z
        desktopPage.selectSortByOption("Name (A - Z)");

        // Select HP Product
        desktopPage.selectProductByName("HP LP3065");

        Assert.assertEquals(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");
        productPage.selectDeliveryDate("30", "November", "2023");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //productPage.enterQuantity("1");
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");
        productPage.clickOnShoppingCartLinkIntoMessage();

        //Verify text Shopping cart
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));

        //Verify text Product name
        Assert.assertEquals(cartPage.getProductName(), "HP LP3065", "Product name not matched");

        //Verify text delivery date
        Assert.assertEquals(cartPage.getDeliveryDate(),"Delivery Date:2011-04-22");

        //Verify product model name
        Assert.assertEquals(cartPage.getModel(), "Product 21", "Model not matched");

        //Verify product price total
        Assert.assertEquals(cartPage.getTotal(), "£74.73", "Total not matched");
    }
}



package com.tutorialninja.demo.sw5.testsuite;

import com.tutorialninja.demo.sw5.pages.*;
import com.tutorialninja.demo.sw5.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class LaptopsAndNotbooksPageTest extends BaseTest {

    HomePage homePage;
    LaptopAndNotebooksPage laptopAndNotebooksPage;
    ProductPage MacBook;
    ShoppingCartPage checkOutPage = new ShoppingCartPage();

    MyAccountPage page3 = new MyAccountPage();
    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        laptopAndNotebooksPage = new LaptopAndNotebooksPage();
        MacBook = new ProductPage();
    }

    @Test (groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        //Change currency to pounds
        homePage.selectCurrency("£Pound Sterling");

        //Mouse hover on Laptopsand Notebooks Tab and click on All Laptops and Notebooks
        homePage.clickOnLaptopAndNotebooks();

        // Get all the products price and stored into array list
        laptopAndNotebooksPage.arrangePriceWise();

        // Select sort by Price (High > Low)
        laptopAndNotebooksPage.sortOutPriceHighToLow();

        //Click on Macbook product
        laptopAndNotebooksPage.clickOnProduct();

        //Verify product name "MacBook
        Assert.assertEquals(laptopAndNotebooksPage.getMessage(), "MacBook", "MacBook Product not display");

        //Add Macbook to shopping cart
        MacBook.addToCart();

        // Verify the message “Shopping cart”
        Assert.assertEquals(laptopAndNotebooksPage.getMessage1(), "Success: You have added MacBook to your shopping cart!\n" + "×", "Product not added to cart");

        //Click on shopping cart
        laptopAndNotebooksPage.shoppingCart();

        // Verify the message “Shopping Cart”
        Assert.assertEquals(MacBook.getMessage2(), "Shopping Cart  (0.00kg)", "Product not added to cart");

        // Verify the message “MacBook”
        Assert.assertEquals(laptopAndNotebooksPage.getMessage3(), "MacBook", "MacBook Product not display");

        //Change quantity Macbook from 1 to 2
        laptopAndNotebooksPage.sendQuantity("2");

        //Click on update button to change quantity
        laptopAndNotebooksPage.update();

        // Verify the message “Cart update message”
        Assert.assertEquals(laptopAndNotebooksPage.getMessage4(), "Success: You have modified your shopping cart!\n" + "×", "Content doesn't match");

        // Verify the Price
        Assert.assertEquals(laptopAndNotebooksPage.getMessage5(), "£737.45", "Price doesn't match");

        // Click on Checkout
        laptopAndNotebooksPage.checkOut();

        // Verify the Checkout
        Assert.assertEquals(laptopAndNotebooksPage.getMessage6(), "Checkout", "Content doesn't match");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Click on continue button
        checkOutPage.clickOnContinueButton();

        checkOutPage.clickContinue();

        //Fill the mandatory name field
        checkOutPage.sendName("Pinks");

        //Fill the mandatory surname field
        checkOutPage.sendLastName("Shah");

        //Fill the mandatory email field
        checkOutPage.sendEmail("Prime9898@gmail.com");

        //Fill the mandatory phone field
        checkOutPage.sendTelephone("02083006879");

        //Fill the mandatory address field
        checkOutPage.sendAddress("14 Church Avenue");

        //Fill the mandatory city field
        checkOutPage.sendCity("London");

        //Fill the mandatory postcode field
        checkOutPage.sendPostCode("EC1V 7EP");

        //Fill the mandatory payzone field
        checkOutPage.enterRegion("Buckinghamshire");

        //Click on continue Registration button
        checkOutPage.continueRegister();

        //Click on Privacy policy button
        page3.clickOnPrivacyPolicy();

        //Add Comments About your order into text area
        page3.sendTextToTextbox("Please leave order at neighbours");

        //Check the Terms & Conditions check box/page3.clickContinue();
        page3.button();                                                                                                                                                                                                                              //Click on “Continue” Button
    }

}

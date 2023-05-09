package com.tutorialninja.demo.sw5.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.demo.sw5.customlisteners.CustomListeners;
import com.tutorialninja.demo.sw5.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccount;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
    WebElement register;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooksLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllLaptops & Notebooks']")
    WebElement laptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath="//span[contains(text(),'Currency')]")
    WebElement currencyTab;

    @CacheLookup
    @FindBy(xpath="//ul[@class = 'dropdown-menu']/li")
    List <WebElement> currencyList;

    @CacheLookup
    @FindBy (linkText = "Desktops")
    WebElement  desktopLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement desktopClick;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Show AllDesktops']")
    List<WebElement> topMenu;

    public void clickOnMyAccountLogin() {

        clickOnElement(myAccount);
        mouseHoverToElement(login);

        CustomListeners.test.log(Status.PASS, "click on My Account");
        Reporter.log("Click on My Account button " + myAccount.toString());

        CustomListeners.test.log(Status.PASS, "click on Login Button");
        Reporter.log("Click on login button " + login.toString());
    }

    public void clickOnMyAccountRegister(){

        clickOnElement(myAccount);
        mouseHoverToElement(register);

        CustomListeners.test.log(Status.PASS, "click on My Account");
        Reporter.log("Click on My Account button " + myAccount.toString());

        CustomListeners.test.log(Status.PASS, "click on Register Button");
        Reporter.log("Click on login button " + register.toString());

    }

    public void clickOnLaptopAndNotebooks(){
        clickOnElement(laptopsAndNotebooksLink);
        mouseHoverToElement(laptopsAndNotebooks);

        CustomListeners.test.log(Status.PASS, "click on LaptopandNotebookTab");
        Reporter.log("Click on LaptopAndNoteBook button " + laptopsAndNotebooksLink.toString());

        CustomListeners.test.log(Status.PASS, "click on AllLaptopAndNotebook Button");
        Reporter.log("Click on AllLaptopAndNotebook button " + laptopsAndNotebooks.toString());
    }

    public void selectCurrency(String currency) {
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = currencyList;
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() {

        mouseHoverToElement(desktopLink);
        //CustomListeners.test.log(Status.PASS, "click on Destop");
       // Reporter.log("Click on Desktop button " + desktopClick.toString());
    }
    public void selectMenu(String menu) {
        List<WebElement> topMenuList =  topMenu;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenu;
        }
    }


}

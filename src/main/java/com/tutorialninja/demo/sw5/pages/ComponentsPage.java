package com.tutorialninja.demo.sw5.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.demo.sw5.customlisteners.CustomListeners;
import com.tutorialninja.demo.sw5.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComponentsPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement message3;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;

    @CacheLookup
    @FindBy(linkText = "Show AllComponents")
    WebElement allcomponents;

    public void clickOnHomePageButtons2() {
        mouseHoverToElementAndClick(components);
        mouseHoverToElementAndClick(allcomponents);

        CustomListeners.test.log(Status.PASS, "Click on Components");
        Reporter.log("Click on Components ");

        CustomListeners.test.log(Status.PASS, "Click on All Components");
        Reporter.log("Click on All Components ");
    }
    public String getMessage2() {

        return getTextFromElement(message3);


    }
}

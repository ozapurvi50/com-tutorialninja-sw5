package com.tutorialninja.demo.sw5.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.demo.sw5.customlisteners.CustomListeners;
import com.tutorialninja.demo.sw5.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;


    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;


    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;


    public String getDesktopsText() {
        return getTextFromElement(desktopsText);
    }

    public ArrayList<String> getProductsNameList() {
        List<WebElement> products = productsList;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }

    public void selectProductByName(String product) {
        List<WebElement> products = productsList;
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) {

        selectByVisibleTextFromDropDown(sortBy, option);

        CustomListeners.test.log(Status.PASS, "Clcik on Sortby");
        Reporter.log("Click on Sortby button ");
    }
}


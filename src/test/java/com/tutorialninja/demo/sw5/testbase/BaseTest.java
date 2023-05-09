package com.tutorialninja.demo.sw5.testbase;

import com.tutorialninja.demo.sw5.propertyreader.PropertyReader;
import com.tutorialninja.demo.sw5.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


    public class BaseTest extends Utility {

        String browser = PropertyReader.getInstance().getProperty("browser");

        @BeforeMethod
        public void setUp(){
            selectBrowser(browser);
        }


//       @AfterMethod
//
//       public void tearDown(){
//
//       closeBrowser();
//
//        }
    }




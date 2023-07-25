package com.fujitsu.tests;

import java.util.Map;

import com.fujitsu.core.driver.Driver;
import com.fujitsu.core.report.AllureManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected BaseTest () {
    }

    @BeforeSuite(description = "Configure TestEnv details in Allure")
    public void beforeSuite(){
        System.setProperty ("webdriver.http.factory","jdk-http-client");
        AllureManager.setAllureEnvironmentInformation ();
    }
    /**
     * Invokes a new browser instance and loads the respective URL.   1
     *
     * @param data Have all the data feeded to the corresponding test method from data provider.In our case,it is a
     *     hashmap containing all the values from the Excel sheet.
     */
    @SuppressWarnings ("unchecked")
    @BeforeMethod(description = "Configuring the browser")
    protected void setUp (Object[] data) {
        System.out.println (data);
        Map<String, String> map = (Map<String, String>) data[0];
        System.out.println (map);
        Driver.initDriver (map.get ("Browser"));
    }

    /**
     * Terminates the browser instance
     */
    @AfterMethod(description = "Closing the browser")
    protected void tearDown () {
        Driver.quitDriver ();
    }

}

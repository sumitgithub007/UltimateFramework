package com.fujitsu.core.pages;

import static com.fujitsu.core.enums.WaitStrategy.PRESENCE;
import static com.fujitsu.core.enums.WaitStrategy.VISIBLE;

import java.time.Duration;
import java.util.List;

import com.fujitsu.core.constants.FrameworkConstants;
import com.fujitsu.core.driver.DriverManager;
import com.fujitsu.core.enums.WaitStrategy;
import com.fujitsu.core.factories.ExplicitWaitFactory;

import lombok.SneakyThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final Logger logger = LogManager.getLogger (BasePage.class);

    public void clear (By locator) {
        getWebElement (VISIBLE, locator).clear ();
    }

    public void click (By locator) {
        getWebElement (PRESENCE, locator).click ();
    }

    public void clickWithRetries (By locator) {
        int maxRetries = 3;
        int retryCount = 0;
        while (retryCount < maxRetries) {
            try {
                getWebElement (locator).click ();
                break;
            } catch (StaleElementReferenceException e) {
                retryCount++;
                logger.info ("StaleElementReferenceException occurred. Retrying...");
                refresh ();
            }
        }

    }

    /**
     * It will fetch text of element present on webpage
     *
     * @param locator
     */
    public String getTextValue (By locator) {
        return getWebElement (PRESENCE, locator).getText ();

    }

    public WebElement getWebElement (By locator) {
        return DriverManager.getDriver ()
            .findElement (locator);
    }

    /**
     * This method first call the wait method to check element is visible.
     * After that it will return webElement
     *
     * @param strategy
     * @param locator
     *
     * @return
     */
    public WebElement getWebElement (WaitStrategy strategy, By locator) {
        ExplicitWaitFactory.performExplicitWait (strategy, locator);
        logger.info ("Finding the locator [{}]", locator);
        return DriverManager.getDriver ()
            .findElement (locator);
    }

    /**
     * Return list of WebElements
     *
     * @param locator
     *
     * @return
     */
    public List<WebElement> getWebElements (WaitStrategy strategy, By locator) {
        ExplicitWaitFactory.performExplicitWait (strategy, locator);
        logger.info ("Finding the locators [{}]", locator);
        return DriverManager.getDriver ()
            .findElements (locator);
    }

    public boolean isAlertPresent () {
        logger.info ("Checking the alert presence");
        boolean foundAlert = false;
        try {
            WebDriverWait wait = new WebDriverWait (DriverManager.getDriver (),
                Duration.ofSeconds (FrameworkConstants.EXPLICITWAIT));
            wait.until (ExpectedConditions.alertIsPresent ());
            foundAlert = true;
        } catch (Exception exception) {
            foundAlert = false;
            logger.info ("Alert is not found");
        }
        return foundAlert;
    }

    public boolean isElementPresent (By by) {
        logger.info ("Checking the element presence");
        return !DriverManager.getDriver ()
            .findElements (by)
            .isEmpty ();
    }

    /**
     * Refresh the current Page
     */
    public void refresh () {
        DriverManager.getDriver ()
            .navigate ()
            .refresh ();
        logger.info ("refreshed the browser");
    }

    /**
     * scroll down page based on pixel value
     */
    public void scrollDownPage () {
        logger.info ("Scrolling down the page");
        ((JavascriptExecutor) DriverManager.getDriver ()).executeScript ("window.scrollBy(0,350)", "");
    }
    public void scrollIntoView (By locator) {
        ((JavascriptExecutor) DriverManager.getDriver ()).executeScript ("arguments[0].scrollIntoView(true)", getWebElement (locator));
    }
    @SneakyThrows
    public void sleep (int sec) {
        Thread.sleep (sec * 1000L);
    }

    /**
     * This method will type the desired text in textbox
     *
     * @param locator
     * @param text
     */

    public void type (By locator, String text) {
        clear (locator);
        getWebElement (VISIBLE, locator).sendKeys (text);
    }

    public void waitUntilPageLoadComplete () {
        WebDriverWait wait = new WebDriverWait (DriverManager.getDriver (),
            Duration.ofSeconds (FrameworkConstants.EXPLICITWAIT));
        wait.until (webDriver -> ((JavascriptExecutor) webDriver).executeScript ("return document.readyState")
            .equals ("complete"));
    }

    /**
     * This method will check if Alert visible and will accept alert
     */
    public void waitandAcceptAlert () {
        if (isAlertPresent ()) {
            DriverManager.getDriver ()
                .switchTo ()
                .alert ()
                .accept ();
        }
    }

    /**
     * Locates element by given wait strategy, performs the clicking operation on WebElement/
     *
     * @param by By Locator of the WebElement
     * @param waitstrategy Strategy to find WebElement. Known  strategies
     *{@link com.fujitsu.core.enums.WaitStrategy}
     *
     * @author Sumit Goyal
     */
    protected void click (By by, WaitStrategy waitstrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait (waitstrategy, by);
        element.click ();
    }

    /**
     * Return page title of webpage in String
     * @return Page title of the webpage where the selenium is currently interacting.
     * @author Sumit Goyal
     */
    protected String getPageTitle () {
        return DriverManager.getDriver ()
            .getTitle ();
    }

    /**
     * Locates element by given wait strategy, sends the value to located WebElement
     *
     * @param by By Locator of the WebElement
     * @param value value to be sent the text box
     * @param waitstrategy Strategy to find WebElement. Known  strategies
     *{@link com.fujitsu.core.enums.WaitStrategy}
     * @param elementname Name of the element that needs to be logged in the report.
     *
     * @author Sumit Goyal
     */
    protected void sendKeys (By by, String value, WaitStrategy waitstrategy, String elementname) {
        WebElement element = ExplicitWaitFactory.performExplicitWait (waitstrategy, by);
        element.sendKeys (value);
    }


    protected boolean waitForWebElementToPresent(By locator,int pooling){
        logger.info("Waiting for the element [{}]",locator);
        boolean isFound=false;
        for (int i=0;i<=pooling;i++){
            if(isElementPresent (locator)){
                logger.info("Element  [{}] is present in [{}] pooling",locator,i);
               return true;
            }
        }
        if(!isFound)
            logger.info ("Element  [{}] is not present in [{}] pooling", locator, pooling);
        return isFound;
    }
}

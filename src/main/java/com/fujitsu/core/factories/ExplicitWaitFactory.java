package com.fujitsu.core.factories;

import java.time.Duration;

import com.fujitsu.core.constants.FrameworkConstants;
import com.fujitsu.core.driver.DriverManager;
import com.fujitsu.core.enums.WaitStrategy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Explicit wait factory produces different waits before operating on webelement
 *
 * @author Sumit Goyal
 * @version 1.0
 * @since 1.0
 */
public final class ExplicitWaitFactory {

    /**
     * @param waitstrategy Strategy to be applied to find a WebElement
     * @param by By locator of the WebElement
     * @return WebElement Locates and return the WebElement
     * @author Sumit Goyal
     */
    public static WebElement performExplicitWait (WaitStrategy waitstrategy, By by) {
        WebElement element = null;
        if (waitstrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait (DriverManager.getDriver (),
                Duration.ofSeconds (FrameworkConstants.EXPLICITWAIT)).until (
                ExpectedConditions.elementToBeClickable (by));
        } else if (waitstrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait (DriverManager.getDriver (),
                Duration.ofSeconds (FrameworkConstants.EXPLICITWAIT)).until (
                ExpectedConditions.presenceOfElementLocated (by));
        } else if (waitstrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait (DriverManager.getDriver (),
                Duration.ofSeconds (FrameworkConstants.EXPLICITWAIT)).until (
                ExpectedConditions.visibilityOfElementLocated (by));
        } else if (waitstrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver ()
                .findElement (by);
        }
        return element;
    }

    private ExplicitWaitFactory () {
    }

}

package com.fujitsu.core.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fujitsu.core.driver.DriverManager;

/**
 * Utility to take base64 screenshot.
 *
 * @author Sumit Goyal
 * @version 1.0
 * @since 1.0
 */
public final class ScreenshotUtils {

    /**
     * Captures screenshot of the current page, constructs a base64 string
     * from the image and return to the caller.
     * There is no temporary screenshot image generated here.
     *
     * @return Image in the form of Base64 String which can be appended directly to report
     *
     * @author Sumit Goyal
     */
    public static String getBase64Image () {
        return ((TakesScreenshot) DriverManager.getDriver ()).getScreenshotAs (OutputType.BASE64);
    }

    /**
     * Private constructor to avoid external instantiation
     */
    private ScreenshotUtils () {
    }

}

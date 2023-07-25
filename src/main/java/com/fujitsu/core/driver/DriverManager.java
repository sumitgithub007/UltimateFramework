package com.fujitsu.core.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<> ();

    /**
     * @return {@link org.openqa.selenium.WebDriver} instance.
     *
     *  
     */
    public static WebDriver getDriver () {
        return driverThreadLocal.get ();
    }

    /**
     * Set the WebDriver instance to thread local variable
     * @param driver {@link org.openqa.selenium.WebDriver}
     *  
     */
    static void setDriver (WebDriver driver) {
        if (Objects.nonNull (driver)) {
            driverThreadLocal.set (driver);
        }
    }

    static void unload () {
        driverThreadLocal.remove ();
    }

    private DriverManager () {
    }

    public static String getInfo() {
        var cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        String browserName = cap.getBrowserName();
        String platform = cap.getPlatformName().toString();
        String version = cap.getBrowserVersion();
        return String.format("browser: %s v: %s platform: %s", browserName, version, platform);
    }
}

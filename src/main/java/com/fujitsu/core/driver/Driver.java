package com.fujitsu.core.driver;

import java.util.Objects;

import com.fujitsu.core.enums.ConfigProperties;
import com.fujitsu.core.factories.DriverFactory;
import com.fujitsu.core.util.PropertyUtils;

public final class Driver {

    /**
     * Gets the browser value and initialise the browser based on that
     *
     * @param browser Value will be passed BaseTest
     *     firefox or any supported browser
     *
     * @author Sumit Goyal 
     */
    public static void initDriver (String browser) {

        if (Objects.isNull (DriverManager.getDriver ())) {
            DriverManager.setDriver (DriverFactory.getDriver (browser));
            DriverManager.getDriver ()
                .get (PropertyUtils.get (ConfigProperties.URL));
        }
    }

    /**
     * Terminates the browser instance. Sets the threadlocal to default value, i.e null.
     */
    public static void quitDriver () {
        if (Objects.nonNull (DriverManager.getDriver ())) {
            DriverManager.getDriver ()
                .quit ();
            DriverManager.unload ();
        }
    }

    private Driver () {
    }

}

package com.fujitsu.core.listener;

import com.fujitsu.core.enums.ConfigProperties;
import com.fujitsu.core.util.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Sumit Goyal
 * @version 1.0
 * @since 1.0
 */
public class RetryFailedTests implements IRetryAnalyzer {

    private       int count   = 0;
    private final int retries = 2;

    /**
     * Return true when needs to be retried and false otherwise.
     * Maximum will retry for one time. Retry will happen if
     * user desires to and set the value in the property file
     */
    @Override
    public boolean retry (ITestResult result) {
        boolean value = false;

        if (PropertyUtils.get (ConfigProperties.RETRYFAILEDTESTS)
            .equalsIgnoreCase ("yes")) {
            value = count < retries;
            count++;
        }
        return value;
    }

}

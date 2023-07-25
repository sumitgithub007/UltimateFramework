package com.fujitsu.core.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.fujitsu.core.report.AllureManager;

/**
 * Implements {@link ITestListener} and {@link ISuiteListener} to leverage the abstract methods Mostly used to help in
 * extent report generation
 * <p>
 * Please make sure to add the listener details in the testng.xml file
 */
public class TestListener implements ITestListener, ISuiteListener {

    private static final Logger logger = LogManager.getLogger (TestListener.class);

    @Override
    public void onFinish (ISuite suite) {

    }

    @Override
    public void onFinish (ITestContext context) {

    }

    @Override
    public void onStart (ITestContext context) {

    }

    @Override
    public void onStart (ISuite suite) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage (ITestResult result) {

    }

    @Override
    public void onTestFailure (ITestResult result) {
        fail (result);
    }

    @Override
    public void onTestSkipped (ITestResult result) {
        logger.error (result.getThrowable ());
    }

    @Override
    public void onTestStart (ITestResult result) {

    }

    @Override
    public void onTestSuccess (ITestResult result) {
    	
    	 
    	
    }

    private void fail (ITestResult iTestResult) {
        logger.error (iTestResult.getTestClass ()
            .getTestName ());
        logger.error (iTestResult.getThrowable ());
        AllureManager.takeScreenshotToAttachOnAllureReport ();
    }

}

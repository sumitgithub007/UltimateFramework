package com.fujitsu.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.fujitsu.core.constants.Constants;
import com.fujitsu.core.listener.TestListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utility {

    private static final Logger logger = LogManager.getLogger (TestListener.class);

    public static Object[][] getData (String testName, XlsReader xls) {

    	

        int rows = xls.getRowCount (Constants.DATA_SHEET);
        logger.info ("Total rows - " + rows);

        // row number for testCase
        int testCaseRowNum = 1;
        for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
            String testNameXls = xls.getCellData (Constants.DATA_SHEET, 0, testCaseRowNum);
            if (testNameXls.equalsIgnoreCase (testName))
                break;
        }
        logger.info ("Test Starts from row Number - " + testCaseRowNum);
        int dataStartRowNum = testCaseRowNum + 2;
        int colStartRowNum = testCaseRowNum + 1;

        // rows of data
        int testRows = 1;
        while (!xls.getCellData (Constants.DATA_SHEET, 0, dataStartRowNum + testRows)
            .equals ("")) {
            testRows++;
        }
        logger.info ("Total rows of data are - " + testRows);

        // cols of data
        int testCols = 0;
        while (!xls.getCellData (Constants.DATA_SHEET, testCols, colStartRowNum)
            .equals ("")) {
            testCols++;
        }

        logger.info("Total cols " + testCols);
        Object[][] data = new Object[testRows][1];
        int r = 0;
        for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {
            Hashtable<String, String> table = new Hashtable<String, String> ();
            for (int cNum = 0; cNum < testCols; cNum++) {
                table.put (xls.getCellData (Constants.DATA_SHEET, cNum, colStartRowNum),
                    xls.getCellData (Constants.DATA_SHEET, cNum, rNum));
            }
            data[r][0] = table;
            r++;

        }
        return data;

    }

    public static List<Map<String, String>> getMapData (String testName, XlsReader xls) {
        int rows = xls.getRowCount (Constants.DATA_SHEET);
        logger.info ("Total rows - " + rows);

        int testCaseRowNum = 1;
        for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
            String testNameXls = xls.getCellData (Constants.DATA_SHEET, 0, testCaseRowNum);
            if (testNameXls.equalsIgnoreCase (testName))
                break;
        }
        logger.info ("Test Starts from row Number - " + testCaseRowNum);
        int dataStartRowNum = testCaseRowNum + 2;
        int colStartRowNum = testCaseRowNum + 1;

        int testRows = 1;
        while (!xls.getCellData (Constants.DATA_SHEET, 0, dataStartRowNum + testRows)
            .equals ("")) {
            testRows++;
        }
        logger.info ("Total rows of data are - " + testRows);

        int testCols = 0;
        while (!xls.getCellData (Constants.DATA_SHEET, testCols, colStartRowNum)
            .equals ("")) {
            testCols++;
        }

        logger.info ("Total cols " + testCols);

        List<Map<String, String>> data = new ArrayList<> ();

        for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {
            Map<String, String> map = new HashMap<> ();
            for (int cNum = 0; cNum < testCols; cNum++) {
                String key = xls.getCellData (Constants.DATA_SHEET, cNum, colStartRowNum);
                String value = xls.getCellData (Constants.DATA_SHEET, cNum, rNum);
                map.put (key, value);
            }
            data.add (map);
        }

        return data;
    }

    public static boolean isSuiteRunnable (String Suitename, XlsReader xls) {

        int rows = xls.getRowCount (Constants.SUITE_SHEET);

        for (int rNum = 2; rNum <= rows; rNum++) {
            String data = xls.getCellData (Constants.SUITE_SHEET, Constants.SUITENAME_COL, rNum);

            if (data.equals (Suitename)) {

                String runmode = xls.getCellData (Constants.SUITE_SHEET, Constants.RUNMODE_COL, rNum);

                return runmode.equals ("Y");
            }
        }

        return false;
    }

    public static boolean isTestCaseRunnable (String TestCase, XlsReader xls) {

        int rows = xls.getRowCount (Constants.TESTCASES_SHEET);

        for (int rNum = 2; rNum <= rows; rNum++) {
            String data = xls.getCellData (Constants.TESTCASES_SHEET, Constants.TESTCASES_COL, rNum);

            if (data.equalsIgnoreCase (TestCase)) {

                String runmode = xls.getCellData (Constants.TESTCASES_SHEET, Constants.RUNMODE_COL, rNum);

                return runmode.equals ("Y");
            }
        }

        return false;
    }

}

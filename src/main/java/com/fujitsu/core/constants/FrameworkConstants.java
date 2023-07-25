package com.fujitsu.core.constants;

/**
 * Framework Constants holds all the constant values used within the framework.
 * If some value needs to be changed or
 * modified often, then it should be stored in the property files
 *
 * @author Sumit Goyal
 * @version 1.0
 * @since 1.0
 */

public class FrameworkConstants {
    public static final int    EXPLICITWAIT       = 10;
    public static final String ITERATIONDATASHEET = "Data";
    public static final String RESOURCESPATH      = System.getProperty ("user.dir") + "/src/main/resources";
    public static final String CHROMEDRIVERPATH   = RESOURCESPATH + "/executables/chromedriver.exe";
    public static final String GECKODRIVERPATH    = RESOURCESPATH + "/executables/geckodriver.exe";
    public static final String EDGEDRIVERPATH   = RESOURCESPATH + "/executables/edgedriver.exe";
    public static final String CONFIGFILEPATH     = RESOURCESPATH + "/config/config.properties";
    public static final String JSONCONFIGFILEPATH = RESOURCESPATH + "/config/config.json";
    public static final String EXCELPATH          = RESOURCESPATH + "/excel/PortFolioTest.xlsx";
    public static final String EXCEL              = RESOURCESPATH + "/excel/%s";
    public static final String RUNMANGERSHEET     = "TestCase";

}

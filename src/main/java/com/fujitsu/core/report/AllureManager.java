package com.fujitsu.core.report;

import static org.openqa.selenium.OutputType.BYTES;

import java.util.HashMap;
import java.util.Map;

import com.fujitsu.core.driver.DriverManager;
import com.fujitsu.core.enums.ConfigProperties;
import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import com.fujitsu.core.util.PropertyUtils;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureManager {

    @Attachment (value = "Browser information", type = "text/plain")
    public static String addBrowserInformationOnAllureReport () {
        return DriverManager.getInfo ();
    }

    public static void setAllureEnvironmentInformation () {
        var basicInfo = new HashMap<> (
            Map.of ("Test URL", PropertyUtils.get (ConfigProperties.URL), "Retry Failed TestCase",
                PropertyUtils.get (ConfigProperties.RETRYFAILEDTESTS), "os.name", System.getProperty ("os.name")));
         System.out.println("test only" + basicInfo);
         
         
        AllureEnvironmentWriter.allureEnvironmentWriter (ImmutableMap.copyOf (basicInfo));
    }

    @Attachment (value = "Page screenshot", type = "image/png")
    public static byte[] takeScreenshot () {
        if (PropertyUtils.get (ConfigProperties.PASSEDSTEPSSCREENSHOTS)
            .equalsIgnoreCase ("yes")) {
            return ((TakesScreenshot) DriverManager.getDriver ()).getScreenshotAs (OutputType.BYTES);
        }
        return new byte[0];
    }

    @Attachment (value = "Failed test screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport () {
        return ((TakesScreenshot) DriverManager.getDriver ()).getScreenshotAs (BYTES);
    }

    private AllureManager () {
    }
}

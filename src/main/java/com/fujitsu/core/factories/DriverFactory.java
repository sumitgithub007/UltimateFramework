package com.fujitsu.core.factories;

import java.net.MalformedURLException;
import java.net.URL;

import com.fujitsu.core.constants.FrameworkConstants;
import com.fujitsu.core.enums.ConfigProperties;
import com.fujitsu.core.util.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

public final class DriverFactory {

    /**
     * @param browser
     * @return WebDriver
     * @throws MalformedURLException
     * @author Sumit Goyal
     */

	@SneakyThrows
    public static WebDriver getDriver (String browser) {

        WebDriver driver = null;

        String runmode = PropertyUtils.get (ConfigProperties.RUNMODE);
        if (browser.equalsIgnoreCase ("chrome")) {
            if (runmode.equalsIgnoreCase ("remote")) {
                ChromeOptions chromeOptions = new ChromeOptions ();
                chromeOptions.addArguments("--ignore-ssl-errors=yes");
                chromeOptions.addArguments("--ignore-certificate-errors");
                driver = new RemoteWebDriver (new URL (PropertyUtils.get (ConfigProperties.SELENIUMGRIDURLCHROME)),
                    chromeOptions);
            } else {
              
            	//System.setProperty("webdriver.chrome.driver", FrameworkConstants.CHROMEDRIVERPATH);            	
            	 WebDriverManager.chromedriver().setup();
             	driver = new ChromeDriver ();
            }
        } else if (browser.equalsIgnoreCase ("firefox")) {
            if (runmode.equalsIgnoreCase ("remote")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions (); 
                firefoxOptions.addArguments("--ignore-ssl-errors=yes");
                firefoxOptions.addArguments("--ignore-certificate-errors");

                
                driver = new RemoteWebDriver (new URL (PropertyUtils.get (ConfigProperties.SELENIUMGRIDURLFIREFOX)),
                    firefoxOptions);
            } else {
                WebDriverManager.firefoxdriver ()
                    .setup();
                driver = new FirefoxDriver ();
            }
        }
        
        else if (browser.equalsIgnoreCase ("edge")) {
            if (runmode.equalsIgnoreCase ("remote")) {
            	 
            	EdgeOptions edgeoptions = new EdgeOptions();
            	edgeoptions.addArguments("--ignore-ssl-errors=yes");
            	edgeoptions.addArguments("--ignore-certificate-errors");
            
            	
            	
            	driver = new RemoteWebDriver (new URL (PropertyUtils.get (ConfigProperties.SELENIUMGRIDURLEDGE)),
                		edgeoptions);
            } else {
            	//System.setProperty("webdriver.edge.driver", FrameworkConstants.EDGEDRIVERPATH);   
                WebDriverManager.edgedriver().setup();
            	driver = new EdgeDriver();
                driver.manage().window().maximize();
            }
        }
        
        
        return driver;
    }

    private DriverFactory () {
    }

}


package com.fujitsu.core.pages;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;

/**
 * @author Sumit Goyal
 * @since 26/06/23 2:47 pm
 */

public final class HomePage extends BasePage {

    private final By loggedInPerson = xpath ("//a[@style='display: block;'][@id='nameofuser']");

    public String getLoginUser () {
        return getTextValue (loggedInPerson);
    }
}

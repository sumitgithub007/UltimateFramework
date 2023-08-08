package com.fujitsu.tests;

import static com.fujitsu.core.factories.PageFactory.createPage;

import java.util.Map;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.fujitsu.core.pages.LandingPage;

/**
 * @author Sumit Goyal
 * @since 26/06/23 12:38 pm
 */
@Epic ("Login Epic for demo Blaze")
@Feature ("Login the demoblaze Application using the username and password")
public final class LoginTest5 extends BaseTest {
	 
    private LoginTest5 () {
    }
    
    @Test ()
    @Description ("Login with different credentials")
    @Severity (SeverityLevel.NORMAL)
    public void loginTest5 (Map<String, String> data) {

        String loggedInUser = createPage (LandingPage.class).Login (data.get ("UserName"), data.get ("Password"))
            .getLoginUser ();
        Assertions.assertThat (loggedInUser).isEqualTo ("Welcolme" + " " + data.get ("UserName"));

    }
}
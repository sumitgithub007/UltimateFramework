package com.fujitsu.tests;

import static com.fujitsu.core.factories.PageFactory.createPage;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.fujitsu.core.pages.LandingPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic ("SignUp Epic for demo Blaze")
@Feature ("Filling the signUp form for demoblaze")
public final class SignUpTest extends BaseTest {

	private SignUpTest()
	{
		
	}
	    @Test()
	    @Description ("Signup a new user with different credentials")
	    @Severity (SeverityLevel.MINOR)
	    public void signUpTest_MethodName  (Map<String, String> data) {

	         createPage (LandingPage.class).signUp (data.get ("UserName"), data.get ("Password"));
	        
	       //  Assertions.assertThat ("welcome").isEqualTo ("Welcome" + " " + data.get ("UserName"));

	    }
	
	
	
	
	
	 
	
}

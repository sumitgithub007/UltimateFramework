package com.fujitsu.core.pages;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import lombok.SneakyThrows;


public class LandingPage extends BasePage {

    private final By cart             = xpath ("//*[text()='Cart']");
    private final By loggedPerson     = id ("nameofuser");
    private final By loginButton      = xpath ("//div[@class='modal-footer'] //*[@onclick='logIn()']");
    private final By loginModalOpen   = xpath ("//*[@id='login2']");
    private final By loginPassword    = xpath ("//input[@id='loginpassword']");
    private final By password         = xpath ("//input[@id='sign-password']");
    private final By signUp           = xpath ("//*[starts-with(@id,'signin')]");
    private final By signupButton     = xpath ("//div[@class='modal-footer'] //*[@onclick='register()']");
    private final By username         = xpath ("//input[@id='loginusername']");
    private final By userNameSignUp   = xpath ("//input[@id='sign-username']");
    private final By passwordSignUp = xpath ("//input[@id='sign-password']");
    private final By welcome          = xpath ("//*[contains(text(),'Welcome')]");

    @SneakyThrows
    @Step ("Login to the application using  {username} and {password}")
    public HomePage Login (String username, String password) {
        clickLoginModal ();
        enterUserName (username);
        enterPassword (password);
        return clickLogin ();
    }

    @Step ("Clicked the login button")
    public HomePage clickLogin () {
        click (this.loginButton);
        sleep (10);
        return new HomePage ();
    }

    @Step ("Clicked the login Modal to open login popup")
    public LandingPage clickLoginModal () {
        click (this.loginModalOpen);
        return this;
    }

    @Step ("Enter the login password as {password}")
    public LandingPage enterPassword (String password) {
        type (this.loginPassword, password);
        return this;
    }

    @Step ("Enter the login username as {username}")
    public LandingPage enterUserName (String username) {
        type (this.username, username);
        return this;
    }
    
    @Step("SignUp a new user using {usernameSignUp} and {passwordSignUp}")
    public HomePage signUp(String usernameSignUp,String passwordSignUp)
    {
    	clickSignUpModal();
    	enterUserNameSingUp(usernameSignUp);
    	enterPasswordSignUp(passwordSignUp);
    	return clickSignUp();
    	 
    }
    
    @Step ("Clicked the SignUp Modal to open SignUp popup")
    public LandingPage clickSignUpModal () {
        click (this.signUp);
        return this;
    }
    
    @Step ("Enter the SignUp password as {passwordSignUp}")
    public LandingPage enterPasswordSignUp (String passwordSignUp) {
        type(this.passwordSignUp, passwordSignUp);
        return this;
    }
    
    

    @Step ("Enter the SignUp username as {userNameSignUp}")
    public LandingPage enterUserNameSingUp(String userNameSignUp) {
        type (this.userNameSignUp, userNameSignUp);
        return this;
    }
    
    
    @Step ("Clicked the SignUp button")
    public HomePage clickSignUp () {
        click (this.signupButton);
        return new HomePage();
    }
    

    
    
}

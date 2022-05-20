package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement userName;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordfield;

    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginButton;

    public void loginWithCorrectCredentials(String user, String password){
        sendTextToElement(userName, user);
        sendTextToElement(passwordfield, password);
        log.info("Enter username and password" + userName.toString() + passwordfield.toString());
    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        log.info("Click on login button" + loginButton.toString());
    }
}

package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage extends Utility {

    private static final Logger log = LogManager.getLogger(CheckoutPage.class.getName());

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "first-name")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "last-name")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "postal-code")
    WebElement postalCode;

    @CacheLookup
    @FindBy(id = "continue")
    WebElement continueButton;

    @CacheLookup
    @FindBy(id = "finish")
    WebElement finishButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    WebElement message;


    public void enterPersonalInformationOnCheckOutPage(String name, String lastname, String postcode){
        sendTextToElement(firstName, name);
       sendTextToElement(lastName, lastname);
        sendTextToElement(postalCode, postcode);
        log.info("Enter personal information" + firstName.toString() + lastName.toString() +postalCode.toString());
    }

    public void clickOnContinueButton(){
        clickOnElement(continueButton);
        log.info("Click on continue button" + continueButton.toString());
    }

    public void clickOnFinishButton(){
        clickOnElement(finishButton);
        log.info("Click on finish button" + finishButton.toString());
    }

    public void verifyMessage(String expectedMessage){
        Assert.assertTrue(message.getText().equalsIgnoreCase(expectedMessage));
        log.info("Verify message" + message.toString());
    }
}

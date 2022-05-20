package com.saucedemo.steps;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.pages.YourCartPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PurchaseSteps {
    @Given("^I am on SauceDemo page$")
    public void iAmOnSauceDemoPage() {
    }

    @When("^I login with credential username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginWithCredentialUsernameAndPassword(String userName, String passWord)  {
        new LoginPage().loginWithCorrectCredentials(userName, passWord);
    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @And("^I filter the products by Price \"([^\"]*)\"$")
    public void iFilterTheProductsByPrice(String priceFilter)  {
       new ProductPage().selectOptionFromDropdown(priceFilter);
    }

    @And("^I select cheapest & costliest products and add to basket \"([^\"]*)\"$")
    public void iSelectCheapestCostliestProductsAndAddToBasket(String selection) {
        new ProductPage().selectCostliestProductAndAddToTheBasket(selection);
        new ProductPage().selectCheapestProductAndAddToTheBasket(selection);
    }

    @And("^I open shopping cart$")
    public void iOpenShoppingCart() {
        new ProductPage().openShoppingCart();
    }

    @And("^I go to checkout$")
    public void iGoToCheckout() {
        new YourCartPage().clickOnCheckoutTab();
    }

    @And("^I enter details firstname \"([^\"]*)\", lastName \"([^\"]*)\" and zipPostalCode \"([^\"]*)\"$")
    public void iEnterDetailsFirstnameLastNameAndZipPostalCode(String name, String surname, String postcode)  {
        new CheckoutPage().enterPersonalInformationOnCheckOutPage(name,surname,postcode);
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
        new CheckoutPage().clickOnContinueButton();
    }

    @And("^I click on finish button$")
    public void iClickOnFinishButton() {
        new CheckoutPage().clickOnFinishButton();
    }

    @Then("^I should be able to see message \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeMessage(String expectedmessage) {
        new CheckoutPage().verifyMessage(expectedmessage);
    }
}

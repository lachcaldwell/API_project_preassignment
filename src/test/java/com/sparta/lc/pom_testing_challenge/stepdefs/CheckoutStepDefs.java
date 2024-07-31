package com.sparta.lc.pom_testing_challenge.stepdefs;

import com.sparta.lc.pom_testing_challenge.Config;
import com.sparta.lc.pom_testing_challenge.pages.*;
import com.sparta.lc.pom_testing_challenge.pages.CartPage;
import com.sparta.lc.pom_testing_challenge.pages.Checkout1;
import com.sparta.lc.pom_testing_challenge.pages.Checkout2;
import com.sparta.lc.pom_testing_challenge.pages.Checkout3;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CheckoutStepDefs extends StepDefsSuper{


    @And("I have added a product to my cart")
    public void iHaveAddedAProductToMyCart() {
        viewProductsPage.addProductToCart("1");

    }

    @And("I have navigated to my cart")
    public void iHaveNavigatedToMyCart() {
        cartPage = new CartPage(viewProductsPage.clickCartButton());
    }

    @When("I press checkout")
    public void iPressCheckout() {
        checkout1 = new Checkout1(cartPage.clickCheckout());
    }

    @And("Enter my {string}, {string} and {string}")
    public void enterMyAnd(String firstName, String lastName, String zipCode) {
        checkout1.inputDetails(firstName,lastName,zipCode);
    }

    @And("press the continue button")
    public void pressTheContinueButton() {
        webDriver = checkout1.pressContinue();
        if (webDriver.getCurrentUrl().equals(Config.getCheckoutStepTwoURL())){
            checkout2 = new Checkout2(webDriver);
        }

    }

    @And("press the finish button")
    public void pressTheFinishButton() {
        checkout3 = new Checkout3(checkout2.clickFinish());
    }

    @Then("I will be told my order has been dispatched")
    public void iWillBeToldMyOrderHasBeenDispatched() {
        Assertions.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkout3.getDispatchNotification());
    }

    @Then("I will be told I need to enter a first name")
    public void iWillBeToldINeedToEnterAFirstName() {
        Assertions.assertEquals("Error: First Name is required", checkout1.getInputErrorMessage());

    }

    @Then("I will be told I need to enter a second name")
    public void iWillBeToldINeedToEnterASecondName() {
        Assertions.assertEquals("Error: Last Name is required", checkout1.getInputErrorMessage());
    }

    @Then("I will be told I need to enter a Zip code")
    public void iWillBeToldINeedToEnterAZipCode() {
        Assertions.assertEquals("Error: Postal Code is required", checkout1.getInputErrorMessage());
    }

    @And("Enter my first name {string}, last name {string} and postcode {string}")
    public void enterMyFirstNameLastNameAndPostcode(String firstName, String lastName, String zipCode) {
        checkout1.inputDetails(firstName,lastName,zipCode);
    }

    @Then("I will be presented with an error code stating {string}")
    public void iWillBePresentedWithAnErrorCodeStating(String errorCode) {
        Assertions.assertEquals(errorCode, checkout1.getInputErrorMessage());
    }
}

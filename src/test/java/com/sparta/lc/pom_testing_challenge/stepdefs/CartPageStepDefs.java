package com.sparta.lc.pom_testing_challenge.stepdefs;

import com.sparta.lc.pom_testing_challenge.pages.CartPage;
import com.sparta.lc.pom_testing_challenge.pages.ViewProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class CartPageStepDefs extends StepDefsSuper{


    @And("I click the cart button")
    public void iClickTheCartButton() {
        viewProductsPage = new ViewProductsPage(webDriver);
        cartPage = new CartPage(viewProductsPage.clickCartButton());
    }


    @Then("The item with the link id {string} and name {string} will be displayed in the cart")
    public void theItemWithTheLinkIdAndNameWillBeDisplayedInTheCart(String linkID, String name) {
        Assertions.assertEquals(name,cartPage.isItemThere(linkID));
    }
}

package com.sparta.lc.pom_testing_challenge.stepdefs;

import com.sparta.lc.pom_testing_challenge.Config;
import com.sparta.lc.pom_testing_challenge.pages.ProductPage;
import com.sparta.lc.pom_testing_challenge.pages.LoginPage;
import com.sparta.lc.pom_testing_challenge.pages.ViewProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProductsStepDefs extends StepDefsSuper{


    @Given("I have logged in and am on the products page with User {string}")
    public void iHaveLoggedInAndAmOnTheProductsPage(String user) {
        webDriver.get(Config.getLoginURL());
        loginPage = new LoginPage(webDriver);
        loginPage.enterDetails(user, Config.getMasterPassword());
        viewProductsPage = new ViewProductsPage(loginPage.clickLogin());

    }

    @When("I click the product with the {string}")
    public void iClickTheProductWithThe(String iD) {
        productPage = new ProductPage(viewProductsPage.clickOnProduct(iD), iD);

    }

    @Then("I will be navigated to the individual {string} page")
    public void iWillBeNavigatedToTheIndividualPage(String productName) {
        Assertions.assertEquals(productName, productPage.getProductName());
    }

    @When("I click the add to cart button for the product with id {string}")
    public void iClickTheAddToCartButtonForTheProductWithId(String productID) {
        viewProductsPage.addProductToCart(productID);
    }

    @Then("The cart iterator will increase by one")
    public void theCartIteratorWillIncreaseByOne() {
        Assertions.assertEquals("1", viewProductsPage.getCartNumber());
    }

    @When("I click add to cart on all the products")
    public void iClickAddToCartOnAllTheProducts() {
        viewProductsPage.addAllProductsToCart();
    }


    @Then("The cart iterator will increase by six")
    public void theCartIteratorWillIncreaseBySix() {
        Assertions.assertEquals("6", viewProductsPage.getCartNumber());
    }

}

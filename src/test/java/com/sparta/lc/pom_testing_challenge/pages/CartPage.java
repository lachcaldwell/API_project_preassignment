package com.sparta.lc.pom_testing_challenge.pages;

import com.sparta.lc.pom_testing_challenge.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    private static final String CART_PAGE_URL = Config.getCartURL();
    private final By productLink0 = By.id("item_0_title_link");
    private final By productLink1 = By.id("item_1_title_link");
    private final By productLink2 = By.id("item_2_title_link");
    private final By productLink3 = By.id("item_3_title_link");
    private final By productLink4 = By.id("item_4_title_link");
    private final By productLink5 = By.id("item_5_title_link");
    private final By checkoutButton = By.linkText("CHECKOUT");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().equals(CART_PAGE_URL);
    }


    public String isItemThere(String productID){

        switch (productID){
            case "0":
                return webDriver.findElement(productLink0).getText();
            case "1":
                return webDriver.findElement(productLink1).getText();
            case "2":
                return webDriver.findElement(productLink2).getText();
            case "3":
                return webDriver.findElement(productLink3).getText();
            case "4":
                return webDriver.findElement(productLink4).getText();
            case "5":
                return webDriver.findElement(productLink5).getText();
            default:
                return "false";
        }

    }

    public WebDriver clickCheckout(){
        webDriver.findElement(checkoutButton).click();
        return webDriver;
    }
}

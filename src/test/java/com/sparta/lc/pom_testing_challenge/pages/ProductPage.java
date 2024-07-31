package com.sparta.lc.pom_testing_challenge.pages;

import com.sparta.lc.pom_testing_challenge.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{


    private static final String BaseProductURL = Config.getIndividualProductBaseURL();
    private final By productNameField = By.cssSelector(".inventory_details_name");

    public ProductPage(WebDriver webDriver, String productNumber) {
        super(webDriver, productNumber);

    }

    @Override
    protected boolean isCorrectPage() {
        System.out.println(BaseProductURL + productNumber);
        return webDriver.getCurrentUrl().equals(BaseProductURL + productNumber);
    }

    public String getProductName(){
        return webDriver.findElement(productNameField).getText();
    }
}

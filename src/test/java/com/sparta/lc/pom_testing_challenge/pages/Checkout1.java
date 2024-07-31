package com.sparta.lc.pom_testing_challenge.pages;

import com.sparta.lc.pom_testing_challenge.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout1 extends BasePage{

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By continueButton = By.cssSelector(".btn_primary");
    private final By inputErrorMessage = By.cssSelector("h3");

    public Checkout1(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().equals(Config.getCheckoutStepOneURL());
    }

    public void inputDetails(String firstName, String lastName, String zipCode){
        webDriver.findElement(firstNameField).sendKeys(firstName);
        webDriver.findElement(lastNameField).sendKeys(lastName);
        webDriver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public WebDriver pressContinue(){
        webDriver.findElement(continueButton).click();
        return webDriver;
    }

    public String getInputErrorMessage(){
        return webDriver.findElement(inputErrorMessage).getText();
    }
}

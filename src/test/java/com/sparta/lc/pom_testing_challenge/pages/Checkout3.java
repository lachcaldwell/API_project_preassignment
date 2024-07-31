package com.sparta.lc.pom_testing_challenge.pages;

import com.sparta.lc.pom_testing_challenge.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout3 extends BasePage{

    private final By dispatchedNotification = By.className("complete-text");

    public Checkout3(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().equals(Config.getCheckoutFinalStepURL());
    }

    public String getDispatchNotification(){
        return webDriver.findElement(dispatchedNotification).getText();
    }
}

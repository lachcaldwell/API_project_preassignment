package com.sparta.lc.pom_testing_challenge.pages;

import com.sparta.lc.pom_testing_challenge.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout2 extends BasePage{

    private final By finishButton = By.linkText("FINISH");
    private final By cancelButton = By.linkText("CANCEL");

    public Checkout2(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().equals(Config.getCheckoutStepTwoURL());
    }

    public WebDriver clickFinish(){
        webDriver.findElement(finishButton).click();
        return webDriver;
    }
}

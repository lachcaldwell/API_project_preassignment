package com.sparta.lc.pom_testing_challenge.pages;

import com.sparta.lc.pom_testing_challenge.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private static final String LOGIN_PAGE_URL = Config.getLoginURL();
    private static final String STANDARD_USER = Config.getStandardUser();
    private static final String MASTER_PASSWORD = Config.getMasterPassword();

    private By usernameField = By.name("user-name");
    private By passwordField = By.name("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().equals(LOGIN_PAGE_URL);
    }

    public void enterDetails(String username, String password){
        webDriver.findElement(usernameField).sendKeys(username);
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public String getErrorMessage(){
        return webDriver.findElement(errorMessage).getText();
    }

    public WebDriver clickLogin(){
        webDriver.findElement(loginButton).click();
        return webDriver;
    }
}

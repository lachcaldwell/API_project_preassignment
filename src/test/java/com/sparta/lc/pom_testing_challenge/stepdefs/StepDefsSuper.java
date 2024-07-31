package com.sparta.lc.pom_testing_challenge.stepdefs;

import com.sparta.lc.pom_testing_challenge.pages.*;
import com.sparta.lc.pom_testing_challenge.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefsSuper {
    protected static ChromeDriverService service;
    protected static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    protected static WebDriver webDriver;

    static LoginPage loginPage;
    static ViewProductsPage viewProductsPage;
    static ProductPage productPage;
    static CartPage cartPage;
    static Checkout1 checkout1;
    static Checkout2 checkout2;
    static Checkout3 checkout3;

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        return chromeOptions;
    }
}

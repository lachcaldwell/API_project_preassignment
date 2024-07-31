package com.sparta.lc.pom_testing_challenge.pages;

import com.sparta.lc.pom_testing_challenge.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewProductsPage extends BasePage{

    private static final String PRODUCTS_PAGE_URL = Config.getProductsURL();
    private By productLinkText;
    private final By addToCartButtonProduct1 = By.xpath("//div[@id='inventory_container']/div/div/div[3]/button");
    private final By addToCartButtonProduct2 = By.xpath("//div[@id='inventory_container']/div/div[2]/div[3]/button");
    private final By addToCartButtonProduct3 = By.xpath("//div[@id='inventory_container']/div/div[3]/div[3]/button");
    private final By addToCartButtonProduct4 = By.xpath("//div[@id='inventory_container']/div/div[4]/div[3]/button");
    private final By addToCartButtonProduct5 = By.xpath("//div[@id='inventory_container']/div/div[5]/div[3]/button");
    private final By addToCartButtonProduct6 = By.xpath("//div[@id='inventory_container']/div/div[6]/div[3]/button");
    private final By cartIterator = By.cssSelector(".fa-layers-counter");
    private final By cartButton = By.cssSelector("path");

    public ViewProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().equals(PRODUCTS_PAGE_URL);
    }

    public WebDriver clickOnProduct(String productID){
        productLinkText = By.id(String.format("item_%s_title_link", productID));
        webDriver.findElement(productLinkText).click();
        return webDriver;
    }

    public void addProductToCart(String productID){
        switch (productID){
            case "1":
                webDriver.findElement(addToCartButtonProduct1).click();
               break;

            case "2":
                webDriver.findElement(addToCartButtonProduct2).click();
                break;

            case "3":
                webDriver.findElement(addToCartButtonProduct3).click();
                break;

            case "4":
                webDriver.findElement(addToCartButtonProduct4).click();
                break;

            case "5":
                webDriver.findElement(addToCartButtonProduct5).click();
                break;

            case "6":
                webDriver.findElement(addToCartButtonProduct6).click();
                break;

            default:
                break;
        }
    }

    public void addAllProductsToCart(){
        webDriver.findElement(addToCartButtonProduct1).click();
        webDriver.findElement(addToCartButtonProduct2).click();
        webDriver.findElement(addToCartButtonProduct3).click();
        webDriver.findElement(addToCartButtonProduct4).click();
        webDriver.findElement(addToCartButtonProduct5).click();
        webDriver.findElement(addToCartButtonProduct6).click();

    }

    public WebDriver clickCartButton(){
        webDriver.findElement(cartButton).click();
        return webDriver;
    }

    public String getCartNumber(){
        return webDriver.findElement(cartIterator).getText();
    }
}

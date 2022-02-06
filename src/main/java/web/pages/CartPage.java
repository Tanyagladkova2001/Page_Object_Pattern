package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
  public static final String BASE_URL = "https://www.saucedemo.com/cart.html";

    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Your Cart']");
    private static final By REMOVE_BUTTON_LOCATOR = By.xpath("//button[@name='remove-test.allthethings()-t-shirt-(red)']");
    private static final By CHECKOUT_LOCATOR = By.cssSelector("button[name='checkout']");


    public CartPage(WebDriver driver) {
        super(driver);
        this.baseUrl=BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    public CartPage removeProductFromCart() {
      driver.findElement(REMOVE_BUTTON_LOCATOR).click();
      return this;
    }

    public CheckoutPage checkoutInCartPage(){
        driver.findElement(CHECKOUT_LOCATOR).click();
        return new CheckoutPage(driver);
    }

    @Override
    public BasePage open() {
        driver.get(BASE_URL);
        return this;
    }
}


package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{
    private static final By TITLE_LOCATOR = By.id("back-to-products");
    private static final By ADD_TO_CART = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    private static final By CART = By.xpath("//a[@class='shopping_cart_link']");



    public ProductPage(WebDriver driver) {
        super(driver);
        this.baseUrl=BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    public ProductPage addToCartOnProductPage(){
        driver.findElement(ADD_TO_CART).click();
        driver.findElement(CART).click();
        return this;

    }
    @Override
    public BasePage open() {
        driver.get(BASE_URL);
        return this;
    }
}

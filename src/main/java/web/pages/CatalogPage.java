package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class CatalogPage extends BasePage{

    public CatalogPage(WebDriver driver) {
        super(driver);
        this.baseUrl=BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }
    public static final String BASE_URL = "https://www.saucedemo.com/inventory.html";

    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Products']");

    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";

    private static final By THREE_LINES_THING = By.id("react-burger-menu-btn");
    private static final By LOGOUT = By.id("logout_sidebar_link");

    private static final By BACKPACK_LOCATOR = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
    private static final By ONE_OF_ALL_PRODUCTS = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");

    private static final By CART_BADGE = By.xpath("//span[@class='shopping_cart_badge']");
    private static final By PRODUCT_SORT = By.xpath("//select[.//option]");
    public static final By PRODUCT_SORT_A_Z = By.xpath("//select[.//option]/option[contains(.,'Name (A to Z)')]");
    public static final By PRODUCT_SORT_Z_A= By.xpath(" //select[.//option]/option[contains(.,'Name (Z to A)')]");
    public static final By PRICE_LOW_TO_HIGH = By.xpath("//select/option[@value='lohi']");
    public static final By PRICE_HIGH_TO_LOW= By.xpath("//select/option[@value='hilo']");


    private static final By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");


    public CatalogPage addProductToCart(String partialProductTitle) {
        driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();
        return this;
    }

    public boolean openMenu(){
        driver.findElement(THREE_LINES_THING).click();
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotInteractableException.class);
        WebElement crossButton = fluent.until(driver -> {
            System.out.println(" FLUENT WAIT ");
            driver.findElement(THREE_LINES_THING).sendKeys("");
            return driver.findElement(THREE_LINES_THING);
        });
        return crossButton.isDisplayed();
    }

    public CatalogPage Logout(){
        openMenu();
        driver.findElement(LOGOUT).click();
        return this;
    }

    public CatalogPage switchToProductPage(){
        driver.findElement(BACKPACK_LOCATOR).click();
        return this;

    }
    public ArrayList<String> allProducts(){
        ArrayList<String> arraylist = new ArrayList<>();
        List<WebElement> allProducts = driver.findElements(ONE_OF_ALL_PRODUCTS);
        for (WebElement products: allProducts){
            arraylist.add(products.getText());
        }
        return arraylist;
    }
    public CatalogPage  sortContainerAZ() {
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(PRODUCT_SORT_A_Z).click();
        allProducts();
        return this;
    }
    public ArrayList<String>  productSortContainerAZ() {
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(PRODUCT_SORT_A_Z).click();
        ArrayList<String> list = new ArrayList<>(allProducts());
            Collections.sort(list) ;
            return list;
        }
    public CatalogPage  sortContainerZA() {
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(PRODUCT_SORT_Z_A).click();
        allProducts();
        return this;
    }
    public ArrayList<String>  productSortContainerZA() {
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(PRODUCT_SORT_A_Z).click();
        ArrayList<String> list = new ArrayList<>(allProducts());
        Collections.reverse(list); ;
        return list;
    }
    public CatalogPage  sortContainerLowHigh() {
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(PRICE_LOW_TO_HIGH).click();
        allProducts();
        return this;
    }
    public ArrayList<String>  productSortContainerLowHigh() {
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(PRICE_LOW_TO_HIGH).click();
        ArrayList<String> list = new ArrayList<>(allProducts());
        Collections.sort(list); ;
        return list;
    }
    public CatalogPage  sortContainerHighLow() {
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(PRICE_HIGH_TO_LOW).click();
        allProducts();
        return this;
    }
    public ArrayList<String>  productSortContainerHighLow() {
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(PRICE_HIGH_TO_LOW).click();
        ArrayList<String> list = new ArrayList<>(allProducts());
        Collections.reverse(list); ;
        return list;
    }

    public CatalogPage isBadgeChanges(){
        driver.findElement(CART_BADGE).getText();
        return this;

    }
    public boolean isBadgeDisplayed(int durationOfSeconds) throws InterruptedException {
        for (int i = 0; i < durationOfSeconds; i++) {
            try {
                driver.findElement(SHOPPING_CART_BADGE);
                return true;
            } catch (NoSuchElementException ex) {
                Thread.sleep(1000);
                System.out.printf("%s seconds left\n", durationOfSeconds - i);
            }
        }
        return false;
    }
    @Override
    public BasePage open() {
        driver.get(BASE_URL);
        return this;
    }

}

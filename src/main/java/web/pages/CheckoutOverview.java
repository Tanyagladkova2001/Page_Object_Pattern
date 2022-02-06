package web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverview extends BasePage{
    public CheckoutOverview(WebDriver driver) {
        super(driver);
        this.baseUrl=BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }
    private static final By TITLE_LOCATOR = By.xpath("//span[contains(text(),'Checkout: Overview')]");

    public static final String BASE_URL = "https://www.saucedemo.com/checkout-step-two.html";

    private static final By FINISH_LOCATOR = By.id("finish");
    private static final By BACK_HOME = By.cssSelector("button[name='back-to-products']");
    private static final By BACK_HOME_PAGE = By.id("checkout_complete_container");


    public CheckoutOverview FinishProcess(){
        driver.findElement(FINISH_LOCATOR).click();
        driver.findElement(BACK_HOME_PAGE);
        driver.findElement(BACK_HOME).click();
        return this;

    }
    @Override
    public BasePage open() {
        driver.get(BASE_URL);
        return this;
    }
    }


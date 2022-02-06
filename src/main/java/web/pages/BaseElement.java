package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseElement {
    protected String baseUrl;
    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    protected By basePageElementId;

    public static final String ERROR_USERNAME_PATTERN = "//h3[contains(.,'Epic sadface: Username is required')]";
    public static final String ERROR_PASSWORD_PATTERN= "//h3[contains(.,'Epic sadface: Password is required')]";

    public BaseElement(WebDriver driver) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isPageLoaded() {
        return driver.findElement(basePageElementId).isDisplayed();
    }

}


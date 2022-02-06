package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class LoginWithoutCreditsPage extends BasePage {
    private static final By USERNAME_TEXT_FIELD = By.id("user-name");
    private static final By PASSWORD_TEXT_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR = By.xpath("//div[@class='error-message-container error']");



    private static final By TITLE_LOCATOR =  By.id("login-button");


    public LoginWithoutCreditsPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    public LoginWithoutCreditsPage login(String username, String password) {
        driver.findElement(USERNAME_TEXT_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginWithoutCreditsPage UsernameErrorEnter() {
        List<WebElement> credentials = driver.findElements(USERNAME_TEXT_FIELD);
        if (credentials.isEmpty()) {
            driver.findElement(ERROR).isDisplayed();
        }
        return this;
    }

    public LoginWithoutCreditsPage errorMessageForUsername() {
       driver.findElement(By.xpath(ERROR_USERNAME_PATTERN)).getText();
        return this;
    }

    public LoginWithoutCreditsPage errorMessageForPassword() {
        driver.findElement(By.xpath(ERROR_PASSWORD_PATTERN)).getText();
        return this;
    }

    @Override
 public BasePage open() {
    driver.get(BASE_URL);
    return this;
}
}

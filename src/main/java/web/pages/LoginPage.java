package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        this.baseUrl=BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    private static final By TITLE_LOCATOR =  By.id("login-button");

    private static final By USERNAME_TEXT_FIELD = By.id("user-name");
    private static final By PASSWORD_TEXT_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");

    public static final String USERNAME_TEXT_FIELD_PLACEHOLDER = "Username";
    public static final String PASSWORD_TEXT_FIELD_PLACEHOLDER = "Password";

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    public LoginPage login(String username, String password) {
        driver.findElement(USERNAME_TEXT_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
    public LoginPage openWithValidation() {
        open();
        isPageLoaded();
        login(USERNAME,PASSWORD);
        return this;
    }
    public String getUsernamePlaceholder() {
        return driver.findElement(USERNAME_TEXT_FIELD).getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return driver.findElement(PASSWORD_TEXT_FIELD).getAttribute("placeholder");
    }

    public LoginPage usernameValidation(String username, String password){
        login(username,password);
        driver.findElement(By.xpath(ERROR_PASSWORD_PATTERN)).getText();
        return this;
    }
    public LoginPage passwordValidation(String username, String password){
        login(username,password);
        driver.findElement(By.xpath(ERROR_USERNAME_PATTERN)).getText();
        return this;
    }

    @Override
    public BasePage open() {
        driver.get(BASE_URL);
        return this;
    }

}

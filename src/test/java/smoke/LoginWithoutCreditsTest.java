package smoke;


import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginWithoutCreditsTest extends BaseTest {
    WebDriver driver;

    @Test
    public void LOGIN_WITHOUT_CREDITS(){
        Assert.assertTrue(loginPage
                        .open()
                        .isPageLoaded(),
                "Login page is not loaded");
        loginWithoutCreditsPage.login("","")
                               .UsernameErrorEnter();

    }
    @Test
    public void LOGIN_WITHOUT_USERNAME(){
        Assert.assertTrue(loginPage
                        .open()
                       .isPageLoaded(),
                "Login page is not loaded");
        loginWithoutCreditsPage
                .login("","secret_sauce")
                .UsernameErrorEnter()
                .errorMessageForUsername();

    }
    @Test
    public void LOGIN_WITHOUT_PASSWORD(){
        Assert.assertTrue(loginPage
                .open()
                .isPageLoaded(),
                "Login page is not loaded");
        loginWithoutCreditsPage
                .login("standard_user","")
                .UsernameErrorEnter()
                .errorMessageForPassword();

    }
    @Test
    public void validationWithUsernameStepTest(){
        loginPage.open();
        validationSteps.validationWithUsernameStep();
    }
}

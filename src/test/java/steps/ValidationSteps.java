package steps;

import org.openqa.selenium.By;
import org.testng.Assert;
import web.pages.*;

public class ValidationSteps extends BaseStep {
    public ValidationSteps(CatalogPage catalogPage, LoginPage loginPage) {
        super(catalogPage, loginPage);
    }
    public void validationWithUsernameStep(){
        Assert.assertEquals(
                loginPage.usernameValidation("standard_user",""),
                loginPage.openWithValidation(),
                "Username input is incorrect"
        );
        catalogPage.Logout();
        Assert.assertEquals(
                loginPage.passwordValidation("","secret_sauce"),
                loginPage.openWithValidation(),
                "Password input is incorrect"
        );
        catalogPage.Logout();
        Assert.assertEquals(
                loginPage.passwordValidation("",""),
                loginPage.openWithValidation(),
                "Input without credits is incorrect"
        );

    }



}

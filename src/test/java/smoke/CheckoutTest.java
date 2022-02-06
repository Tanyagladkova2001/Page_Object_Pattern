package smoke;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {

    @BeforeMethod
    private void login() {
        Assert.assertNotNull(loginPage
                        .openWithValidation(),
                "Login page is not loaded");
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");

    }

    @Test
    public void PurchaseCheckoutTest(){
        Assert.assertTrue(cartPage
                        .open()
                        .isPageLoaded(),
                "CartPage page is not loaded");
        cartPage.checkoutInCartPage();
        checkoutPage.CredentialsInput("Tanya","Gladkova","12345");
        checkoutOverview.FinishProcess();
    }
    @Test
    public void PlaceholdersTest(){
        cartPage.open()
                .isPageLoaded();
        cartPage.checkoutInCartPage();
        checkoutPage.checkoutPlaceholder();
    }
}

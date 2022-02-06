package smoke;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @BeforeMethod
    private void login() {
        Assert.assertNotNull(loginPage
                        .openWithValidation(),
                "Login page is not loaded");
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");

    }

    @Test
    public void removeProductFromCartTest() {
        Assert.assertTrue(catalogPage
                        .addProductToCart(TEST_PRODUCT_TITLE)
                        .isPageLoaded(),
        "Catalog page is not loaded");

        Assert.assertTrue(cartPage
                        .open()
                        .isPageLoaded(),
                "CartPage is not loaded");
              cartPage .removeProductFromCart();

    }
    @Test
    public void CheckoutButton(){
        Assert.assertTrue(cartPage
                .open()
                .isPageLoaded(),
                "Checkout page is not loaded");
        cartPage.checkoutInCartPage();


    }


}

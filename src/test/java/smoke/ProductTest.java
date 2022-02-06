package smoke;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @BeforeMethod
    private void login() {
        Assert.assertNotNull(loginPage
                        .openWithValidation(),
                "Login page is not loaded");
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");

    }

    @Test
    public void addToCartOnProductPageTest(){
        Assert.assertTrue(catalogPage
                        .switchToProductPage()
                        .isPageLoaded(),
                "Product page is not loaded");
        productPage.addToCartOnProductPage();
        Assert.assertTrue(cartPage.isPageLoaded(), "Product page is not loaded");


    }
}

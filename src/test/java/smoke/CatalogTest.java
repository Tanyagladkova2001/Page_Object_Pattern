package smoke;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.CatalogPage;

import java.util.ArrayList;


public class CatalogTest extends BaseTest {

    @BeforeMethod
    private void login() {
        Assert.assertNotNull(loginPage
                        .openWithValidation(),
                "Login page is not loaded");
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");

    }

    @Test
    public void addProductToCartTest() {
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        cartPage.open();
        Assert.assertTrue(cartPage.isPageLoaded(), "Cart page is not loaded");
    }
    @Test
    public void openMenuTest(){
         Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
         catalogPage.openMenu();
    }
    @Test
    public void LogoutTest(){
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
         catalogPage.Logout();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
    }
    @Test
    public void switchToProductPageTest(){
         catalogPage.switchToProductPage();
         Assert.assertTrue(productPage.isPageLoaded(), "Product page is not loaded");

    }

    @Test
    public void isBadgeChangesTest() throws InterruptedException {
        Assert.assertTrue(catalogPage
                .addProductToCart(TEST_PRODUCT_TITLE)
                .isPageLoaded(),
                "Catalog page is not loaded");
         catalogPage.isBadgeChanges()
                 .isBadgeDisplayed(5);
    }
    @Test
    public void productSortContainerAZTest() {
        ArrayList<String> sorting = catalogPage.productSortContainerAZ();
        Assert.assertEquals(
                catalogPage
                        .sortContainerAZ()
                        .allProducts(),
                         sorting,
                "Sort of A to Z is incorrect"
        );
    }
    @Test
    public void productSortContainerZATest() {
        ArrayList<String> sorting = catalogPage.productSortContainerZA();
        Assert.assertEquals(
                catalogPage
                        .sortContainerZA()
                        .allProducts(),
                sorting,
                "Sort of Z to A is incorrect"
        );
    }

    @Test
    public void productSortContainerLowHighTest() {
        ArrayList<String> sorting = catalogPage.productSortContainerLowHigh();
        Assert.assertEquals(
                catalogPage
                        .sortContainerLowHigh()
                        .allProducts(),
                sorting,
                "Sort of low to high is incorrect"
        );
    }
    @Test
    public void productSortContainerHighLowTest() {
        ArrayList<String> sorting = catalogPage.productSortContainerHighLow();
        Assert.assertEquals(
                catalogPage
                        .sortContainerHighLow()
                        .allProducts(),
                sorting,
                "Sort of high to low is incorrect"
        );
    }
    }


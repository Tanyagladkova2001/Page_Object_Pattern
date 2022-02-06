package steps;

import web.pages.CatalogPage;
import web.pages.CheckoutPage;
import web.pages.LoginPage;
import web.pages.ProductPage;

public class BaseStep {
    protected ProductPage productPage;
    protected CatalogPage catalogPage;
    protected LoginPage loginPage;

    public BaseStep(CatalogPage catalogPage, LoginPage loginPage) {
        this.catalogPage = catalogPage;
        this.loginPage = loginPage;
    }

    public BaseStep(ProductPage productPage) {
        this.productPage = productPage;
    }
}

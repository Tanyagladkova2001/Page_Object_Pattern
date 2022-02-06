package web.pages;

import org.openqa.selenium.WebDriver;


public  abstract class BasePage extends BaseElement{
    public static final String BASE_URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
    super(driver);
    this.baseUrl=BASE_URL;

}
    public abstract BasePage open();
}

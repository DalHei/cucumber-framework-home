package pl.coderslab.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopSearchResults {
    private final WebDriver driver;

    public ShopSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#js-product-list > div.products.row > div:nth-child(1) > article > div > div.thumbnail-top > a > img")
    private WebElement product;

    public ShopSearchResults(WebDriver driver, WebElement product) {
        this.driver = driver;
        this.product = product;
    }

    public void productSelection () {
        product.click();
    }

}
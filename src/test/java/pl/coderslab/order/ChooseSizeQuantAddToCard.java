package pl.coderslab.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ChooseSizeQuantAddToCard {
    private final WebDriver driver;
    private WebDriver wait;

    public ChooseSizeQuantAddToCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "group[1]")
    private WebElement sizeDropdown;

    @FindBy(css = ".btn.btn-touchspin.js-touchspin.bootstrap-touchspin-up")
    private WebElement quantityUpBtn;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToCartBtn;

    public ChooseSizeQuantAddToCard(WebDriver driver, WebElement sizeDropdown, WebElement quantityUpBtn, WebElement proceedToCheckoutBtnLightBox, WebElement addToCartBtn) {
        this.driver = driver;
        this.sizeDropdown = sizeDropdown;
        this.quantityUpBtn = quantityUpBtn;
        this.addToCartBtn = addToCartBtn;
        this.proceedToCheckoutBtnLightBox = proceedToCheckoutBtnLightBox;

    }

    public void chooseProduct(String size,Integer quantity) {
        Select sizeSelect = new Select(sizeDropdown);
        sizeSelect.selectByVisibleText(size);

        for (int i = 0; i < quantity; i++) {
            quantityUpBtn.click();
        }

        addToCartBtn.click();
    }

    @FindBy(css = "a.btn.btn-primary[ href$='controller=cart&action=show']")
    private WebElement proceedToCheckoutBtnLightBox;

    public void clickProceedCheckoutLightBox() {
        proceedToCheckoutBtnLightBox.click();
    }


}
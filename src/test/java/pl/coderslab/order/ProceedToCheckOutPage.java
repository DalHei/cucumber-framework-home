package pl.coderslab.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedToCheckOutPage {
    private final WebDriver driver;

    public ProceedToCheckOutPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "a.btn.btn-primary")
    private WebElement proceedToCheckoutBtn;

    public void ProceedToCheckOutPage () {
        proceedToCheckoutBtn.click();
    }
}
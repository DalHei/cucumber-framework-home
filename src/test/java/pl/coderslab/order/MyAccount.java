package pl.coderslab.order;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
    private final WebDriver driver;
    public MyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (name = "s")
    private WebElement searchInputField;

    public MyAccount(WebDriver driver, WebElement searchInputField) {
        this.driver = driver;
        this.searchInputField = searchInputField;
    }
    public void searchInput (String request) {
        searchInputField.clear();
        searchInputField.sendKeys(request);
        searchInputField.sendKeys(Keys.RETURN);
    }
}
package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PageObjectSteps {
    private WebDriver driver;

    @Given("I'm on the shop authentication page")
    public void imOnTheShopAuthPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?");
        driver.findElement(By.className("user-info")).click();
    }

    public PageObjectSteps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageObjectSteps() {
    }


    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String login, String passwd) {
        AuthenticationPage authPage = new AuthenticationPage(driver);
        authPage.loginAs(login, passwd);
    }

    @And("I go to my addresses page")
    public void iGoToMyAddressPage() {
        ShopMyAccount myAccountPage = new ShopMyAccount(driver);
        myAccountPage.goToMyAddressPage();
        CreatingNewAddress myAddressesPage = new CreatingNewAddress(driver);
    }

    @And("I attempt to add a new address")
    public void clickingAddNewAddressBtn() {
        driver.findElement(By.cssSelector("#content > div.addresses-footer > a > span")).click();
    }

    @And("I enter new address {word}, {string}, {string}, {word}, {word}")
    public void newAddressFilled(String alias, String address, String city, String postCode, String phone) {
        CreatingNewAddress newaddress = new CreatingNewAddress(driver);
        newaddress.enterNewAddress(alias, address, city, postCode, phone);
    }

    @Then("I can see a new address")
    public void newAddressIsVisible () {
        MyAddresses myAddress = new MyAddresses(driver);
        Assert.assertNotNull(myAddress.alert);
        Assert.assertTrue(myAddress.isAlertVisible());
    }

    @Then ("I verify created address has {word}, {string}, {string}, {word}, {word}")
    public void verifyAddress(String alias, String address, String city, String postCode, String phone) {
        MyAddresses myAddress = new MyAddresses(driver);
        String[] listOfFields = myAddress.address.findElement(By.tagName("address")).getText().split("\n");
        String aliasFromPage = myAddress.address.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(aliasFromPage, alias);
        Assert.assertEquals(listOfFields[1], address);
        Assert.assertEquals(listOfFields[2], city);
        Assert.assertEquals(listOfFields[3], postCode);
        Assert.assertEquals(listOfFields[5], phone);
    }

    @And("I close the browser")
    public void closeBrowser () {
        driver.quit();
    }
}
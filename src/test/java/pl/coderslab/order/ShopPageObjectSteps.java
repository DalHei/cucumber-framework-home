package pl.coderslab.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShopPageObjectSteps {
    private WebDriver driver;

    @Given("I'm on the shop authentication page")
    public void ShopAuthPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?");
        driver.findElement(By.className("user-info")).click();
    }

    @When("I login using {string} and {string}")
    public void Login(String login, String passwd) {
        AuthPage authPage = new AuthPage(driver);
        authPage.loginAs(login, passwd);
    }

    @And("I'm looking for a product {string}")
    public void SendRequest(String request) {
        MyAccount myAccount = new MyAccount(driver);
        myAccount.searchInput(request);
    }


    @And("I choose a product")
    public void ChooseProduct() {
        ShopSearchResults myRequest = new ShopSearchResults(driver);
        myRequest.productSelection();
    }

    @Then("I choose size {word}, quantity {int} and add to cart")
    public void SizeQuantityAddToCart(String size, Integer quantity) {
        ChooseSizeQuantAddToCard myProductChoice = new ChooseSizeQuantAddToCard(driver);
        myProductChoice.chooseProduct(size,quantity);
        myProductChoice.clickProceedCheckoutLightBox();
    }

    @And("I click on option checkout")
    public void ClickOptionCheckout() {
        ProceedToCheckOutPage myProceedToCheckout = new ProceedToCheckOutPage(driver);
        myProceedToCheckout.ProceedToCheckOutPage();
    }

    @And("I choose the address, shipping and payment methods and I agree to the terms")
    public void ChooseAddressShippingPaymentIAgreeToTheTerms() {
        AddressShipPayPage myAddressShippingPayment = new AddressShipPayPage(driver);
        myAddressShippingPayment.clickConfirmAddressBtn();
        myAddressShippingPayment.clickConfirmShippingBtn();
        myAddressShippingPayment.selectPaymentMethod();
        myAddressShippingPayment.selectAgreeTerms();
    }

    @And("Click Place order")
    public void PlaceOrder() {
        AddressShipPayPage clickPlaceOrder = new AddressShipPayPage(driver);
        clickPlaceOrder.placeOrder();
    }

    @And("Take a screenshot with order confirmation and price")
    public void ScreenshotWithOrderConfirmationAndPrice() {
        ConfirmOrder screenshot = new ConfirmOrder(driver);
        screenshot.takeScreenshot();
    }

    @Then("I close the browser")
    public void CloseTheBrowser() {
        driver.close();
    }
}

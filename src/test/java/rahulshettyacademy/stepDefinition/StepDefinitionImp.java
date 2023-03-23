package rahulshettyacademy.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalog;

public class StepDefinitionImp extends BaseTest{
	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public CheckOutPage checkOut;
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException {
		
		landingPage = launchApp();
		//code
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		productCatalog = landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) {
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
	}

	@When("^Checkout (.+)  and submit order$")
	public void checkout_product_and_submit_order(String productName) {
		CartPage cartPage = productCatalog.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkOut = cartPage.goToCheckOut();
		checkOut.SelectCountryAndPlaceOrder();
	}
	
	@Then("{string} message is displayed on confirmation page")
	public void message_displayed_confirmation(String string) {
		String confirmMsg = checkOut.Confirmation();
		Assert.assertEquals(confirmMsg, string);
	}
	
	@Then("{stringmsg} message is displayed")
	public void error_message_is_dispalyed(String stringmsg) {
		Assert.assertEquals(stringmsg, landingPage.getErrorMessage());
	}

}

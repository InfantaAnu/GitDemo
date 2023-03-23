package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalog;

public class ErrorValidationTest extends BaseTest {

	@Test(groups = { "Error Validation" })
	public void LoginErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		landingPage.loginApplication("ia@gmail.com", "Anumika");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

	@Test
	public void productErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		ProductCatalog productCatalog = landingPage.loginApplication("ia@gmail.com", "Anumika**07");
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
}

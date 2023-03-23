package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ProductCatalog;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException {
		// TODO Auto-generated method stub
		// String productName = "ZARA COAT 3";
		ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalog.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage checkOut = cartPage.goToCheckOut();
		checkOut.SelectCountryAndPlaceOrder();
		String confirmMsg = checkOut.Confirmation();
		Assert.assertEquals(confirmMsg, "THANKYOU FOR THE ORDER.");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		/*
		 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
		 * "ia@gmail.com"); map.put("password", "Anumika**07"); map.put("productName",
		 * "ZARA COAT 3");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("email", "shetty@gmail.com"); map1.put("password", "Iamking@000");
		 * map1.put("productName", "ADDIDAS ORIGINAL");
		 */

		List<HashMap<String, String>> data = getJsonDataToMap();

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}

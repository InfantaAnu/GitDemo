package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	// constructor
	public CheckOutPage(WebDriver driver) {
		super(driver);
		// initialized first
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page factory

	@FindBy(css = "[placeholder='Select Country']")
	WebElement selCountry;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement india;

	@FindBy(css = ".action__submit")
	WebElement placeOrder;

	@FindBy(className = "hero-primary")
	WebElement confirmMsg;

	By dropdown = By.cssSelector(".ta-results");

	public void SelectCountryAndPlaceOrder() {
		Actions a = new Actions(driver);
		a.sendKeys(selCountry, "India").build().perform();
		WaitForElementToAppear(dropdown);
		india.click();
		placeOrder.click();

	}

	public String Confirmation() {
		String confirmation = confirmMsg.getText();
		return confirmation;
	}

}

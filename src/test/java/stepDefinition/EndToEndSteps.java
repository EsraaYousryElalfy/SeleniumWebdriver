package stepDefinition;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddToCartPage;
import pageObjects.CheckoutPage;
import pageObjects.OrderDetailsPage;
import pageObjects.ProductsPage;
import pageObjects.SearchPage;
import tests.TestBase;

public class EndToEndSteps extends TestBase{
	
	SearchPage searchObject;
	ProductsPage productsObject;
	AddToCartPage addToCartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderDetailsObject;
	String productName="Apple MacBook Pro 13-inch";
	@Given("^the user is on home page$")
	public void the_user_is_on_home_page() {
	
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String productName)  throws InterruptedException{
		searchObject = new  SearchPage(driver);
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest(productName);
	}

	@When("^choose to buy two items$")
	public void choose_to_buy_two_items() throws InterruptedException {
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		productsObject.addToCart();
		
	}

	@When("^moves to checkout cart and enter personal details on checkout page and place the order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() {
		productsObject.goToShoppingCart();
	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		addToCartObject = new AddToCartPage(driver);
		Thread.sleep(5000);
		addToCartObject.openCheckoutPage();
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(8000);
		checkoutObject.goToCheckoutAsGuest();
		checkoutObject.checkoutAsGuest("Esraa", "Elalfy", "esraa11jsss5@gmail.com", "Egypt", "Cairo", "11355", "Test", "01255445154", productName);
		checkoutObject.confirmOrder();
		Thread.sleep(5000);
		Assert.assertTrue(checkoutObject.notification.getText().contains("Your order has been successfully processed!"));
		Thread.sleep(5000);
		checkoutObject.goToPrintpdfInvoice();
		orderDetailsObject = new OrderDetailsPage(driver);
		Thread.sleep(5000);
		orderDetailsObject.PDFInvoice();
		System.out.println(downloadPath);
		Thread.sleep(5000);
		orderDetailsObject.printInvoice();
	}
}

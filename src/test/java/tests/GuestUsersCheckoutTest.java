package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CheckoutPage;
import pageObjects.OrderDetailsPage;
import pageObjects.ProductsPage;
import pageObjects.SearchPage;

public class GuestUsersCheckoutTest extends TestBase{
	SearchPage searchObject;
	ProductsPage productsObject;
	AddToCartPage addToCartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderDetailsObject;
	String productTxt="MacBook";
	String productValue="Apple MacBook Pro 13-inch";
	String productName="Apple MacBook Pro 13-inch";
	
	@Test(priority=1)
	public void searchAutoSuggest() throws InterruptedException
	{
		searchObject = new  SearchPage(driver);
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest(productTxt);
	}
	//3.add to cart
	@Test(priority=2)
	public void addProductToCart() throws InterruptedException
	{
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		productsObject.addToCart();
		productsObject.goToShoppingCart();
	}
	//4.checkout
	@Test(priority=3)
	public void checkout() throws InterruptedException
	{	
		addToCartObject = new AddToCartPage(driver);
		Thread.sleep(5000);
		addToCartObject.openCheckoutPage();
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(8000);
		checkoutObject.goToCheckoutAsGuest();
		checkoutObject.checkoutAsGuest("Esraa", "Elalfy", "esraa115@gmail.com", "Egypt", "Cairo", "11355", "Test", "01255445154", productName);
		checkoutObject.confirmOrder();
		Thread.sleep(5000);
		Assert.assertTrue(checkoutObject.notification.getText().contains("Your order has been successfully processed!"));
		checkoutObject.goToPrintpdfInvoice();
		orderDetailsObject = new OrderDetailsPage(driver);
		orderDetailsObject.PDFInvoice();
		System.out.println(downloadPath);
		orderDetailsObject.printInvoice();
		//checkoutObject.continuePage();
	}
}

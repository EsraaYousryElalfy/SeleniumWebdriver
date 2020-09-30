package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.OrderDetailsPage;
import pageObjects.ProductsPage;
import pageObjects.SearchPage;
import pageObjects.UserRegistrationPage;

public class RegistreredUsersCheckoutTest extends TestBase{
	//1.register
	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	SearchPage searchObject;
	ProductsPage productsObject;
	AddToCartPage addToCartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderDetailsObject;
	String productTxt="MacBook";
	String productValue="Apple MacBook Pro 13-inch";
	String productName="Apple MacBook Pro 13-inch";
	@Test(priority=1)
	public void testRegistration() throws InterruptedException
	{
		HomePageObject=new HomePage(driver);
		Thread.sleep(5000);
		HomePageObject.openRegistrationPage();
		userRegistrationPageObject=new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userRegistrationPageObject.userRegistration("Esraa","Elalfy","esraa142@gmail.com","123456789");
	}
	//2.search product
	@Test(priority=2)
	public void searchAutoSuggest() throws InterruptedException
	{
		searchObject = new  SearchPage(driver);
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest(productTxt);
	}
	//3.add to cart
	@Test(priority=3)
	public void addProductToCart() throws InterruptedException
	{
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		productsObject.addToCart();
		productsObject.goToShoppingCart();
	}
	//4.checkout
	@Test(priority=4)
	public void checkout() throws InterruptedException
	{	
		addToCartObject = new AddToCartPage(driver);
		Thread.sleep(5000);
		addToCartObject.openCheckoutPage();
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(5000);
		checkoutObject.RegisteredUsersCheckout("Egypt", "Cairo", "11335", "Test", "015348745484", productName);
		Thread.sleep(5000);
		//Assert.assertTrue(checkoutObject.paymentInfoTextAssertion.getText().contains("You can edit this text from"));
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
	//6.logout
	@Test(priority=5)
	public void testLogout()
	{
		userRegistrationPageObject.userLogout();
	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.ProductsPage;
import pageObjects.SearchPage;

public class AddToCartTest extends TestBase {
	
	AddToCartPage addToCartObject;
	ProductsPage productsObject;
	SearchPage searchObject;
	String productTxt="MacBook";
	String productName="Apple MacBook Pro 13-inch";
	String subTotal="$3,600.00";
	
	@Test(priority=1)
	public void searchAutoSuggest() throws InterruptedException
	{
		searchObject = new  SearchPage(driver);
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest(productTxt);
		Thread.sleep(5000);
		Assert.assertTrue(productsObject.productAssertValue.getText().equalsIgnoreCase(productName));
	}
	@Test(priority=2)
	public void addProductToCart() throws InterruptedException
	{
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		productsObject.addToCart();
		productsObject.goToShoppingCart();
		addToCartObject= new AddToCartPage(driver);
		Assert.assertTrue(addToCartObject.productName.getText().contains(productName));
		Assert.assertTrue(addToCartObject.ProductSubTotal.getText().equals(subTotal));
	}
	@Test(priority=3)
	public void removeProductFromCart() throws InterruptedException
	{
		addToCartObject = new AddToCartPage(driver);
		Thread.sleep(5000);
		addToCartObject.removeFromShoppingCart();
	}
}

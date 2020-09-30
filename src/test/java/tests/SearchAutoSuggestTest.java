package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductsPage;
import pageObjects.SearchPage;

public class SearchAutoSuggestTest extends TestBase{
	String productValue="Apple MacBook Pro 13-inch";
	String productTxt="MacBook";
	SearchPage searchObject;
	ProductsPage productsObject;
	@Test
	public void searchAutoSuggest() throws InterruptedException
	{
		searchObject = new  SearchPage(driver);
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest(productTxt);
		Thread.sleep(5000);
		Assert.assertTrue(productsObject.productAssertValue.getText().equalsIgnoreCase(productValue));
	}
}

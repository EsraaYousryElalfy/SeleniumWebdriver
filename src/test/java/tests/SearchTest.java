package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductsPage;
import pageObjects.SearchPage;

public class SearchTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductsPage productsObject;
	@Test
	public void searchingForProduct() throws InterruptedException
	{
		searchObject=new SearchPage(driver);
		productsObject=new ProductsPage(driver);
		Thread.sleep(6000);
		searchObject.productSearch(productName);
		Thread.sleep(6000);
		searchObject.clickOnProductTitle();
		Thread.sleep(5000);
		Assert.assertTrue(productsObject.productAssertValue.getText().equalsIgnoreCase(productName));
		//Assert.assertEquals(productsObject.productAssertValue.getText(), productName);
	}
}

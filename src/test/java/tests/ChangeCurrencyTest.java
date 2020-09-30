package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	HomePage homePageObject;
	ProductsPage productPageObject;
	String productValue="Apple MacBook Pro 13-inch";
	String productTxt="MacBook";
	SearchPage searchObject;
	
	
	@Test
	public void changeCurrency() throws InterruptedException
	{
		homePageObject=new HomePage(driver);
		Thread.sleep(5000);
		homePageObject.currencyTransfer();		
	}
	
	@Test
	public void searchAutoSuggest() throws InterruptedException
	{
		searchObject = new  SearchPage(driver);
		productPageObject = new ProductsPage(driver);
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest(productTxt);
		Thread.sleep(5000);
		Assert.assertTrue(productPageObject.productAssertValue.getText().equalsIgnoreCase(productValue));
		Assert.assertTrue(productPageObject.productPriceLabel.getText().contains("€"));
	}
}

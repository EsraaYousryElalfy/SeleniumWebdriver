package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCompareListPage;
import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.SearchPage;

public class AddToCompareListTest extends TestBase{
	SearchPage searchObject;
	ProductsPage productsObject;
	HomePage homePageObject;
	AddToCompareListPage addToCompareObject;
	String firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";
	String firstProductValue;
	
	@Test(priority=1)
	public void canCompareProducts() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest("macB");
		
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue(productsObject.productAssertValue.getText().contains(firstProductName));
		productsObject.addToCompareList();
		
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest("asus");
		Assert.assertTrue(productsObject.productAssertValue.getText().contains(secondProductName));
		Thread.sleep(5000);
		productsObject.addToCompareList();
		productsObject.goToCompareList();
		
		addToCompareObject = new AddToCompareListPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue(addToCompareObject.firstProductName.isDisplayed());
		Assert.assertTrue(addToCompareObject.secondProductName.isDisplayed());
		
		addToCompareObject.compareProducts();
	}
	@Test(priority=2)
	public void clearCompareList() throws InterruptedException
	{
		addToCompareObject = new AddToCompareListPage(driver);
		Thread.sleep(5000);
		addToCompareObject.clearList();
		Assert.assertTrue(addToCompareObject.notification.getText().contains("no items"));
	}
	
}
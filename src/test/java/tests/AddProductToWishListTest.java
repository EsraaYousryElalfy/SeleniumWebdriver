package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductsPage;
import pageObjects.SearchPage;
import pageObjects.WishListPage;

public class AddProductToWishListTest extends TestBase{
	SearchPage searchObject;
	ProductsPage productsObject;
	WishListPage wishListObject;
	String productValue="Apple MacBook Pro 13-inch";
	String productTxt="MacBook";
	
	@Test(priority=1)
	public void searchAutoSuggest() throws InterruptedException
	{
		searchObject = new  SearchPage(driver);
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest(productTxt);
		Thread.sleep(5000);
		Assert.assertTrue(productsObject.productAssertValue.getText().equalsIgnoreCase(productValue));
	}
	@Test(priority=2)
	public void addToWishList() throws InterruptedException
	{
		productsObject=new ProductsPage(driver);
		Thread.sleep(5000);
		productsObject.addToWishList();
		wishListObject=new WishListPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue(wishListObject.pageHeader.isDisplayed());
		Thread.sleep(5000);
		Assert.assertTrue(wishListObject.wishListCell.getText().contains(productValue));
	}
	@Test(priority=3)
	public void removeFromWishList() throws InterruptedException
	{
		wishListObject=new WishListPage(driver);
		Thread.sleep(5000);
		wishListObject.removeProductFromWishList();
		Thread.sleep(5000);
		Assert.assertTrue(wishListObject.notification.getText().contains("empty"));
	}
}

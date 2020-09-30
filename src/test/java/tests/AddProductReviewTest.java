package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddProductReviewPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.SearchPage;
import pageObjects.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{

	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	LoginPage loginPageObject;
	SearchPage searchObject;
	ProductsPage productsObject;
	AddProductReviewPage reviewObject;
	String productValue="Apple MacBook Pro 13-inch";
	String productTxt="MacBook";
	String reviewTitle="Send preview";
	String reviewText="review very good.";

	// 1.user registration
	@Test(priority=1)
	public void testRegistration() throws InterruptedException
	{
		Thread.sleep(5000);
		HomePageObject=new HomePage(driver);
		HomePageObject.openRegistrationPage();
		userRegistrationPageObject=new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userRegistrationPageObject.userRegistration("Esraa","Elalfy","esraa145@gmail.com","123456789");
		Assert.assertTrue(userRegistrationPageObject.successMessage.getText().contains("Your registration completed"));
	}

	// 2.search for product
	@Test(priority=2)
	public void searchAutoSuggest() throws InterruptedException
	{
		searchObject = new  SearchPage(driver);
		productsObject = new ProductsPage(driver);
		Thread.sleep(5000);
		searchObject.ProductAutoSuggest(productTxt);
		Thread.sleep(5000);
		Assert.assertTrue(productsObject.productAssertValue.getText().equalsIgnoreCase(productValue));
	}
	// 3.send email to friend
	@Test(priority=3)
	public void addReview() throws InterruptedException
	{
		Thread.sleep(5000);
		productsObject.addReview();
		reviewObject=new AddProductReviewPage(driver);
		Thread.sleep(5000);
		reviewObject.reviewSubmitting(reviewTitle,reviewText);
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added"));
	}
	// 4.log out
	@Test(priority=4)
	public void testLogout()
	{
		userRegistrationPageObject.userLogout();
	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmailFriendPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.SearchPage;
import pageObjects.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	LoginPage loginPageObject;
	EmailFriendPage emailFriendObject;
	SearchPage searchObject;
	ProductsPage productsObject;
	String productValue="Apple MacBook Pro 13-inch";
	String productTxt="MacBook";
	String FriendEmail="test@test.com";
	String msg="Hello dear, Esraa.";

	// 1.user registration
	@Test(priority=0)
	public void testRegistration() throws InterruptedException
	{
		Thread.sleep(5000);
		HomePageObject=new HomePage(driver);
		HomePageObject.openRegistrationPage();
		userRegistrationPageObject=new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userRegistrationPageObject.userRegistration("Esraa","Elalfy","esraa144@gmail.com","123456789");
		Assert.assertTrue(userRegistrationPageObject.successMessage.getText().contains("Your registration completed"));
	}
	
	// 2.search for product
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
	// 3.send email to friend
	@Test(priority=2)
	public void emailFriend() throws InterruptedException
	{
		Thread.sleep(5000);
		productsObject=new ProductsPage(driver);
		productsObject.emailFriend();
		Thread.sleep(5000);
		emailFriendObject=new EmailFriendPage(driver);
		Thread.sleep(5000);
		emailFriendObject.emailFriend(FriendEmail, msg);
		Thread.sleep(5000);
		Assert.assertTrue(emailFriendObject.Result.getText().contains("Your message has been sent"));
	}
	// 4.log out
	@Test(priority=3)
	public void testLogout()
	{
		userRegistrationPageObject.userLogout();
	}
}

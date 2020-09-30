package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	LoginPage loginPageObject;
	String email="esraa141@gmail.com";
	String password="123456789";
	
	@Test(priority=1)
	public void testRegistration() throws InterruptedException
	{
		HomePageObject=new HomePage(driver);
		HomePageObject.openRegistrationPage();
		userRegistrationPageObject=new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userRegistrationPageObject.userRegistration("Esraa","Elalfy", email ,password);
		Assert.assertTrue(userRegistrationPageObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void testLogoutAfterRegistration() throws InterruptedException
	{
		Thread.sleep(5000);
		userRegistrationPageObject.userLogout();
	}
	@Test(priority=3)
	public void registeredUserLogin() throws InterruptedException
	{
		Thread.sleep(5000);
		HomePageObject.openLoginPage();
		loginPageObject=new LoginPage(driver);
		Thread.sleep(5000);
		loginPageObject.userLogin(email, password);
		Assert.assertTrue(userRegistrationPageObject.logoutBtn.getText().contains("Log out"));
	}
	@Test(priority=4)
	public void testLogoutAfterLogin() throws InterruptedException
	{
		Thread.sleep(5000);
		userRegistrationPageObject.userLogout();
	}
}

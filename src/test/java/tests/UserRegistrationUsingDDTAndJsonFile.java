package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserRegistrationPage;

public class UserRegistrationUsingDDTAndJsonFile extends TestBase {
	
	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	LoginPage loginPageObject;
	String email="esraa141@gmail.com";
	String password="123456789";
	
	@Test
	public void testRegistration() throws InterruptedException
	{
		HomePageObject=new HomePage(driver);
		HomePageObject.openRegistrationPage();
		userRegistrationPageObject=new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userRegistrationPageObject.userRegistration("Esraa","Elalfy", email ,password);
		Assert.assertTrue(userRegistrationPageObject.successMessage.getText().contains("Your registration completed"));
		Thread.sleep(5000);
		userRegistrationPageObject.userLogout();
		Thread.sleep(5000);
		HomePageObject.openLoginPage();
		loginPageObject=new LoginPage(driver);
		Thread.sleep(5000);
		loginPageObject.userLogin(email, password);
		Assert.assertTrue(userRegistrationPageObject.logoutBtn.getText().contains("Log out"));
		Thread.sleep(5000);
		userRegistrationPageObject.userLogout();
	}
}

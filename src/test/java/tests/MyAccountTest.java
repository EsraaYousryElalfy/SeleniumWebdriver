package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.UserRegistrationPage;

public class MyAccountTest extends TestBase{
	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	MyAccountPage myAccoountObject;
	String oldPassword="123456789";
	String newPassword="12345678910";
	String firstName="Esraa";
	String lastName="Elalfy";
	String email="esraa143@gmail.com";
	LoginPage loginPageObject;
	@Test(priority=1)
	public void testRegistration() throws InterruptedException
	{
		HomePageObject=new HomePage(driver);
		Thread.sleep(5000);
		HomePageObject.openRegistrationPage();
		userRegistrationPageObject=new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userRegistrationPageObject.userRegistration(firstName,lastName,email,oldPassword);
		Thread.sleep(5000);
		Assert.assertTrue(userRegistrationPageObject.successMessage.getText().contains("Your registration completed"));
	}
	@Test(priority=2)
	public void myAccountChangePasswordPage() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		Thread.sleep(5000);
		HomePageObject.myAccountPage();
		myAccoountObject=new MyAccountPage(driver);
		myAccoountObject.clickOnChangePassword();
		Thread.sleep(5000);
		myAccoountObject.changePassword(oldPassword, newPassword);
		Thread.sleep(5000);
		Assert.assertTrue(myAccoountObject.newPasswordResult.getText().contains("Password was changed"));
	}
	
	
	@Test(priority=3)
	public void testLogout()
	{
		userRegistrationPageObject.userLogout();
	}
	@Test(priority=4)
	public void registeredUserLogin() throws InterruptedException
	{
		Thread.sleep(5000);
		HomePageObject.openLoginPage();
		loginPageObject=new LoginPage(driver);
		Thread.sleep(5000);
		loginPageObject.userLogin(email, newPassword);
		Assert.assertTrue(userRegistrationPageObject.logoutBtn.getText().contains("Log out"));
	}
	@Test(priority=5)
	public void testLogoutFinally()
	{
		userRegistrationPageObject.userLogout();
	}
}

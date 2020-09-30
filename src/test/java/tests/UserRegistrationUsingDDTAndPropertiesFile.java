package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserRegistrationPage;
import testData.LoadProperties;

public class UserRegistrationUsingDDTAndPropertiesFile extends TestBase {
	
	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	LoginPage loginPageObject;
	
	String fName=LoadProperties.userData.getProperty("firstName");
	String lNAme=LoadProperties.userData.getProperty("lastName");
	String eMail=LoadProperties.userData.getProperty("email");
	String passWord=LoadProperties.userData.getProperty("password");
	
	@Test(priority=1)
	public void testRegistration() throws InterruptedException
	{
		System.out.println(LoadProperties.userData);
		HomePageObject=new HomePage(driver);
		HomePageObject.openRegistrationPage();
		userRegistrationPageObject=new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userRegistrationPageObject.userRegistration(fName,lNAme,eMail,passWord);
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
		loginPageObject.userLogin(eMail, passWord);
		Assert.assertTrue(userRegistrationPageObject.logoutBtn.getText().contains("Log out"));
	}
	@Test(priority=4)
	public void testLogoutAfterLogin() throws InterruptedException
	{
		Thread.sleep(5000);
		userRegistrationPageObject.userLogout();
	}
}

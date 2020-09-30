package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserRegistrationPage;

public class UserRegistrationUsingDDTAndDataProvider extends TestBase {

	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	LoginPage loginPageObject;

	@DataProvider(name="testdata")
	public static Object [] [] testData()
	{
		return new Object [] [] {
		{"Esraa" ,"Elalfy" , "esraa541464dfld1@gmail.com" , "123456789"}
		,
		{"Esraa" , "Elalfy" , "esraa414546884dcmkd@gmail.com" , "123456789"}};
	}

	@Test(priority=1,dataProvider="testdata")
	public void testRegistration(String firstName,String lastName,String eMail,String passWord) throws InterruptedException
	{
		HomePageObject=new HomePage(driver);
		HomePageObject.openRegistrationPage();
		
		userRegistrationPageObject=new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userRegistrationPageObject.userRegistration(firstName,lastName,eMail,passWord);
		Assert.assertTrue(userRegistrationPageObject.successMessage.getText().contains("Your registration completed"));
		Thread.sleep(5000);
		userRegistrationPageObject.userLogout();
		Thread.sleep(5000);
		HomePageObject.openLoginPage();
		loginPageObject=new LoginPage(driver);
		Thread.sleep(5000);
		loginPageObject.userLogin(eMail, passWord);
		Assert.assertTrue(userRegistrationPageObject.logoutBtn.getText().contains("Log out"));
		Thread.sleep(5000);
		userRegistrationPageObject.userLogout();
	}

}

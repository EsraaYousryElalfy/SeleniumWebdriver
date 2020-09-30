package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserRegistrationPage;
import testData.ExcelReader;

public class UserRegistrationUsingDDTAndExcelFile extends TestBase {

	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	LoginPage loginPageObject;

	@DataProvider(name="ExcelData")
	public Object[] [] registrationExcellFileData() throws IOException
	{
		// read data from excel file
		ExcelReader ex=new ExcelReader();
		return ex.getExcelData();
	}

	@Test(dataProvider="ExcelData")
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

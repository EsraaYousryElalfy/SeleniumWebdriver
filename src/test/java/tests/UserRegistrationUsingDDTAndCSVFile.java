package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserRegistrationPage;

public class UserRegistrationUsingDDTAndCSVFile extends TestBase {

	HomePage HomePageObject;
	UserRegistrationPage userRegistrationPageObject;
	LoginPage loginPageObject;
	CSVReader reader;

	@Test
	public void testRegistration() throws InterruptedException, CsvValidationException, IOException
	{
		String csvFilePath=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\TestData.csv";
		reader = new CSVReader(new FileReader(csvFilePath));
		String[] csvCell;
		while ((csvCell = reader.readNext()) != null)
		{
			String firstName=csvCell[0];
			String lastName=csvCell[1];
			String email=csvCell[2];
			String passWord=csvCell[3];
			
			HomePageObject=new HomePage(driver);
			HomePageObject.openRegistrationPage();
			userRegistrationPageObject=new UserRegistrationPage(driver);
			Thread.sleep(5000);
			userRegistrationPageObject.userRegistration(firstName,lastName,email,passWord);
			Thread.sleep(5000);
			Assert.assertTrue(userRegistrationPageObject.successMessage.getText().contains("Your registration completed"));
			Thread.sleep(5000);
			userRegistrationPageObject.userLogout();
			Thread.sleep(5000);
			HomePageObject.openLoginPage();
			loginPageObject=new LoginPage(driver);
			Thread.sleep(5000);
			loginPageObject.userLogin(email, passWord);
			Thread.sleep(5000);
			Assert.assertTrue(userRegistrationPageObject.logoutBtn.getText().contains("Log out"));
			Thread.sleep(5000);
			userRegistrationPageObject.userLogout();
		}
	}
}

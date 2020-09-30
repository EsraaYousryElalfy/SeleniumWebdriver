package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;

public class ContactUsTest extends TestBase{
	HomePage homePage;
	ContactUsPage contactUsPage;
	String fullName="Esraa ELalfy";
	String email="esraa.yousry.elalfy@gmail.com";
	String enquiry="Hello dear, Esraa.";
	@Test
	public void contactUs() throws InterruptedException
	{
		homePage=new HomePage(driver);
		contactUsPage=new ContactUsPage(driver);
		Thread.sleep(5000);
		homePage.contactUsPage();
		Thread.sleep(5000);
		contactUsPage.contactUs(fullName, email, enquiry);
		Thread.sleep(5000);
		Assert.assertTrue(contactUsPage.Result.getText().contains("Your enquiry has been successfully sent to the store owner"));
	}
}

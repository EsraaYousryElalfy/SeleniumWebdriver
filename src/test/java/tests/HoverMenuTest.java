package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class HoverMenuTest extends TestBase{
	HomePage homePageObject;
	@Test
	public void hoverMenu()
	{
		homePageObject=new HomePage(driver);
		homePageObject.hovenOnMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}

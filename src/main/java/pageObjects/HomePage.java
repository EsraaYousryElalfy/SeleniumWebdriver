package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		actions=new Actions(driver);
	}
	
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	@FindBy(linkText="My account")
	WebElement MyAccountLink;
	
	@FindBy(linkText="Contact us")
	WebElement contactUS;
	
	@FindBy(id="customerCurrency")
	WebElement currencyDropDownList;
	
	@FindBy(linkText="Computers")
	WebElement computerMenu;
	
	@FindBy(linkText="Notebooks")
	WebElement notebooksMenu;
	
	public void openRegistrationPage()
	{
		 ClickOnLink(registerLink);
	}
	public void openLoginPage()
	{
		ClickOnLink(loginLink);
	}
	public void myAccountPage()
	{
		ClickOnLink(MyAccountLink);
	}
	public void contactUsPage()
	{
		scrollToBottom();
		ClickOnLink(contactUS);
	}
	public void currencyTransfer()
	{
		select = new Select(currencyDropDownList);
		select.selectByIndex(1);
	}
	public void hovenOnMenu()
	{
		actions.moveToElement(computerMenu).moveToElement(notebooksMenu).click().build().perform();
	}
}

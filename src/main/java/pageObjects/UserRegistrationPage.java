package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {
	
	public UserRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	// finding elements
	@FindBy(id="gender-male")
	WebElement genderRadioBtn;
	
	@FindBy(id="FirstName")
	WebElement FirstNameTextBox;
	
	@FindBy(id="LastName")
	WebElement LastNameTextBox;
	
	@FindBy(id="Email")
	WebElement emailTextBox;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	@FindBy(linkText="Log out")
	public WebElement logoutBtn;
	
	@FindBy(linkText="My account")
	WebElement myAccountLink;
	
	public void userRegistration(String firstName,String lastName,String email,String Password)
	{
		
		waitUntilElementLoaded(genderRadioBtn, 1200);
		ClickOnLink(genderRadioBtn);
		
		waitUntilElementLoaded(FirstNameTextBox, 1200);
		SendTextElement(FirstNameTextBox,firstName);
		
		waitUntilElementLoaded(LastNameTextBox, 120);
		SendTextElement(LastNameTextBox,lastName);
		
		waitUntilElementLoaded(emailTextBox, 120);
		SendTextElement(emailTextBox,email);
		
		waitUntilElementLoaded(password, 120);
		SendTextElement(password,Password);
		
		waitUntilElementLoaded(confirmPassword, 120);
		SendTextElement(confirmPassword,Password);
		
		waitUntilElementLoaded(registerBtn, 120);
		ClickOnLink(registerBtn);
	}
	public void userLogout()
	{
		ClickOnLink(logoutBtn);
	}
	/*public void myAccount()
	{
		ClickOnLink(myAccountLink);
	}*/
}

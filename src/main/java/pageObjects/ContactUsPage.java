package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FullName")
	WebElement fullName;
	@FindBy(id="Email")
	WebElement Email;
	@FindBy(id="Enquiry")
	WebElement Enquiry;
	@FindBy(css="input.button-1.contact-us-button")
	WebElement submitBtn;
	@FindBy(css="div.result")
	public WebElement Result;
	
	public void contactUs(String name, String email,String enquiry)
	{
		SendTextElement(fullName, name);
		SendTextElement(Email, email);
		SendTextElement(Enquiry, enquiry);
		ClickOnLink(submitBtn);
	}
}

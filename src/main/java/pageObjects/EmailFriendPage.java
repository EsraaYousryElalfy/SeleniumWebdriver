package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FriendEmail")
	WebElement FriendEmail;
	@FindBy(id="YourEmailAddress")
	WebElement YourEmail;
	@FindBy(id="PersonalMessage")
	WebElement PersonalMsg;
	@FindBy(css="input.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	@FindBy(css="div.result")
	public WebElement Result;
	
	public void emailFriend(String email,String msg)
	{
		SendTextElement(FriendEmail, email);
		SendTextElement(PersonalMsg, msg);
		ClickOnLink(sendEmailBtn);
	}

}

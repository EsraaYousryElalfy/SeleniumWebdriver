package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText="Change password")
	WebElement changePassword;
	@FindBy(id="OldPassword")
	WebElement oldPassword;
	@FindBy(id="NewPassword")
	WebElement newPassword;
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPassword;
	@FindBy(css="input.button-1.change-password-button")
	public WebElement newPasswordBtn;
	@FindBy(css="div.result")
	public WebElement newPasswordResult;
	
	public void clickOnChangePassword()
	{
		ClickOnLink(changePassword);
	}
	public void changePassword(String oldAccountPassword,String newAccountPassword) throws InterruptedException
	{
		Thread.sleep(5000);
		SendTextElement(oldPassword, oldAccountPassword);
		SendTextElement(newPassword, newAccountPassword);
		SendTextElement(confirmPassword, newAccountPassword);
		ClickOnLink(newPasswordBtn);
	}

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitle;
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewText;
	@FindBy(id="addproductrating_4")
	WebElement ratingBtn;
	@FindBy(name="add-review")
	WebElement submitBtn;
	@FindBy(css="div.result")
	public WebElement reviewNotification;
	public void reviewSubmitting(String title,String text)
	{
		SendTextElement(reviewTitle, title);
		SendTextElement(reviewText, text);
		ClickOnLink(ratingBtn);
		ClickOnLink(submitBtn);
	}
}

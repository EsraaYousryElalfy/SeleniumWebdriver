package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="a.product-name")
	public WebElement wishListCell;
	
	@FindBy(css="h1")
	public WebElement pageHeader;
	
	@FindBy(name="removefromcart")
	WebElement removeSelection;
	
	@FindBy(name="updatecart")
	WebElement updateBtn;
	
	@FindBy(css="div.no-data")
	public WebElement notification;
	
	public void removeProductFromWishList()
	{
		ClickOnLink(removeSelection);
		ClickOnLink(updateBtn);
	}
}

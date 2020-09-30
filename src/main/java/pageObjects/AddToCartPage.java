package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends PageBase{

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="div.page-title")
	WebElement title;
	
	@FindBy(css="dic.no-data")
	WebElement notification;
	
	@FindBy(name="updatecart")
	WebElement updateShoppingCartBtn;
	
	@FindBy(name="removefromcart")
	WebElement removeCheckBox;
	
	@FindBy(css="input.qty-input")
	WebElement qty;
	
	@FindBy(css="a.product-name")
	public WebElement productName;
	
	@FindBy(css="span.product-subtotal")
	public WebElement ProductSubTotal;
	
	@FindBy(id="checkout")
	WebElement chechoutBtn;
	
	@FindBy(id="termsofservice")
	WebElement acceptTermsAndConditions;
	
	public void removeFromShoppingCart()
	{
		ClickOnLink(removeCheckBox);
		ClickOnLink(updateShoppingCartBtn);
	}
	public void updateShoppingCart(String Qty)
	{
		clearElement(qty);
		SendTextElement(qty, Qty);
		ClickOnLink(updateShoppingCartBtn);
	}
	public void openCheckoutPage()
	{
		ClickOnLink(acceptTermsAndConditions);
		ClickOnLink(chechoutBtn);
	}
}

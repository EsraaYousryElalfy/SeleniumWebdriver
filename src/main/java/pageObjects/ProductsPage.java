package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends PageBase{

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="strong.current-item")
	public WebElement productAssertValue; 
	
	@FindBy(xpath="//input[@value='Email a friend']")
	public WebElement emailFriendBtn;
	
	@FindBy(css="span.price-value-4")
	public WebElement productPriceLabel;
	
	@FindBy(linkText="Add your review")
	public WebElement addReviewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	public WebElement addToWishList;
	
	@FindBy(linkText="wishlist")
	public WebElement wishListHyperLink;
	
	@FindBy(xpath="//input[@value='Add to compare list']")
	public WebElement compareProductsBtn;
	
	@FindBy(id="add-to-cart-button-4")
	public WebElement addToCartBtn;
	
	@FindBy(linkText="product comparison")
	public WebElement compareListHyperLink;
	
	@FindBy(linkText="shopping cart")
	public WebElement shoppingCartHyperLink;
	
	public void emailFriend()
	{
		ClickOnLink(emailFriendBtn);
	}
	public void addReview()
	{
		ClickOnLink(addReviewLink);
	}
	public void addToWishList()
	{
		ClickOnLink(addToWishList);
		ClickOnLink(wishListHyperLink);
	}
	public void addToCompareList()
	{
		ClickOnLink(compareProductsBtn);
	}
	public void addToCart()
	{
		ClickOnLink(addToCartBtn);
	}
	public void goToCompareList()
	{
		ClickOnLink(compareListHyperLink);
	}
	public void goToShoppingCart()
	{
		ClickOnLink(shoppingCartHyperLink);
	}
}

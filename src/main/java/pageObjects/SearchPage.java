package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchField;
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void productSearch(String searchProductName)
	{
		SendTextElement(searchField, searchProductName);
		ClickOnLink(searchBtn);
	}
	public void clickOnProductTitle()
	{
		ClickOnLink(productTitle);
	}
	public void ProductAutoSuggest(String autoSuggestProductName) throws InterruptedException
	{
		SendTextElement(searchField, autoSuggestProductName);
		Thread.sleep(5000);
		productList.get(0).click();
	}
}

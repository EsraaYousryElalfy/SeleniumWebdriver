package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCompareListPage extends PageBase{

	public AddToCompareListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="table.compare-products-table")
	private WebElement compareTable;
	
	@FindBy(tagName="tr")
	public List<WebElement> compareTableRows;
	
	@FindBy(tagName="td")
	public List<WebElement> compareTableColumns;
	
	@FindBy(css="a.clear-list")
	private WebElement clearListBtn;
	
	@FindBy(css="div.no-data")
	public WebElement notification;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement firstProductName;
	
	@FindBy(linkText="Asus N551JK-XO076H Laptop")
	public WebElement secondProductName;
	
	public void clearList()
	{
		ClickOnLink(clearListBtn);
	}
	public void compareProducts()
	{
		System.out.println(compareTableRows.size());
		for(WebElement row : compareTableRows)
		{
			System.out.println(row.getText() + "\t");
			for(WebElement col : compareTableColumns)
			{
				System.out.println(col.getText() + "\t");
			}
		}
	}
}

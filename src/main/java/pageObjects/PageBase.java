package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	// create constructor for initialization
	protected static WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions actions;
	public PageBase (WebDriver driver)
	{
		PageBase.driver=driver;
		// this class that you in, you can read from it
		PageFactory.initElements(driver, this);
	}
	
	protected static void waitUntilElementLoaded(WebElement element, int timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOut*1000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected static void ClickOnLink(WebElement clickElement)
	{
		clickElement.click();
	}
	
	protected static void SendTextElement(WebElement sendingElement, String textElement)
	{
		sendingElement.sendKeys(textElement);
	}
	public void scrollToBottom()
	{
		jse.executeScript("scrollBy(0,1500)");
	}
	public void clearElement(WebElement clearElement)
	{
		clearElement.clear();
	}
	
}


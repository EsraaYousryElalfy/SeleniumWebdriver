package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText="PDF Invoice")
	WebElement pdfInvoiceBtn;
	@FindBy(linkText="Print")
	WebElement printBtn;
	public void PDFInvoice() throws InterruptedException
	{
		Thread.sleep(5000);
		ClickOnLink(pdfInvoiceBtn);
	}
	public void printInvoice()
	{
		ClickOnLink(printBtn);
	}
	
}

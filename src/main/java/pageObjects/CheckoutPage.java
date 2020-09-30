package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement checkoutAsGuest;
	@FindBy(id="ShipToSameAddress")
	WebElement shipToSameAddressRadioBtn;
	@FindBy(id="billing-address-select")
	WebElement addressDropDown;
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement FirstNameTxt;
	@FindBy(id="BillingNewAddress_LastName")
	WebElement LastNameTxt;
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxt;
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement CountryDropdown;
	@FindBy(id="BillingNewAddress_City")
	WebElement CityTxt;
	@FindBy(id="BillingNewAddress_Address1")
	WebElement addressoneTxt;
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxt;
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxt;
	@FindBy(css="input.button-1.new-address-next-step-button")
	WebElement billingAddressContinueBtn;
	@FindBy(id="shippingoption_1")
	WebElement shippingMethodOption;
	@FindBy(css="input.button-1.shipping-method-next-step-button")
	WebElement shippingMethodContinueBtn;
	@FindBy(id="paymentmethod_0")
	WebElement paymentMethodRadioBtnOption;
	@FindBy(css="input.button-1.payment-method-next-step-button")
	WebElement paymentMethodContinueBtn;
	@FindBy(xpath="//*[@id=\"checkout-payment-info-load\"]/div/div/div/table/tbody/tr/td/p[4]")
	public WebElement paymentInfoTextAssertion;
	@FindBy(css="input.button-1.payment-info-next-step-button")
	WebElement paymentInfoContinueBtn;
	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmOrderBtn;
	@FindBy(css="strong")
	public WebElement notification;
	@FindBy(linkText="Click here for order details.")
	WebElement orderDetailsHyperLink;
	@FindBy(css="input.button-1.order-completed-continue-button")
	WebElement continueBtn;

	public void RegisteredUsersCheckout(String Country,String City,String ZipCode,String Address,String PhoneNum,String ProductName) throws InterruptedException
	{
		
		select = new Select(CountryDropdown);
		Thread.sleep(5000);
		select.selectByValue("123");
		Thread.sleep(5000);
		SendTextElement(CityTxt,City);
		SendTextElement(addressoneTxt, Address);
		SendTextElement(zipCodeTxt, ZipCode);
		SendTextElement(phoneNumberTxt, PhoneNum);
		Thread.sleep(5000);
		ClickOnLink(billingAddressContinueBtn);
		Thread.sleep(5000);
		ClickOnLink(shippingMethodContinueBtn);
		Thread.sleep(5000);
		ClickOnLink(paymentMethodContinueBtn);
		Thread.sleep(5000);
		ClickOnLink(paymentInfoContinueBtn);
	}
	public void confirmOrder() throws InterruptedException {

		Thread.sleep(5000);
		ClickOnLink(confirmOrderBtn);
	}
	public void goToPrintpdfInvoice() throws InterruptedException 
	{
		Thread.sleep(5000);
		ClickOnLink(orderDetailsHyperLink);
	}
	public void continuePage()
	{
	ClickOnLink(continueBtn);
	}
	public void goToCheckoutAsGuest() throws InterruptedException
	{
		Thread.sleep(5000);
		ClickOnLink(checkoutAsGuest);
	}
	public void checkoutAsGuest(String FirstName,String LastName,String Email,String Country,String City,String ZipCode,String Address,String PhoneNum,String ProductName) throws InterruptedException
	{
		Thread.sleep(5000);
		SendTextElement(FirstNameTxt, FirstName);
		SendTextElement(LastNameTxt, LastName);
		SendTextElement(emailTxt, Email);
		select = new Select(CountryDropdown);
		Thread.sleep(5000);
		Thread.sleep(5000);
		select.selectByValue("123");
		Thread.sleep(5000);
		SendTextElement(CityTxt,City);
		SendTextElement(addressoneTxt, Address);
		SendTextElement(zipCodeTxt, ZipCode);
		SendTextElement(phoneNumberTxt, PhoneNum);
		Thread.sleep(5000);
		ClickOnLink(billingAddressContinueBtn);
		Thread.sleep(5000);
		ClickOnLink(shippingMethodContinueBtn);
		Thread.sleep(5000);
		ClickOnLink(paymentMethodContinueBtn);
		Thread.sleep(5000);
		ClickOnLink(paymentInfoContinueBtn);
	}
}

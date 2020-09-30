package stepDefinition;

import org.testng.Assert;

//import com.github.javafaker.Faker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.UserRegistrationPage;
import tests.TestBase;

public class UserRegistrationSteps extends TestBase{
	HomePage homePageObject;
	UserRegistrationPage userReistrationObject;
	/*Faker fakeData=new Faker();
	String firstName=fakeData.name().firstName();
	String lastName=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String password=fakeData.number().digits(10).toString();*/
	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() {
		homePageObject = new HomePage(driver);
		homePageObject.openRegistrationPage();
	}

	@When("^i click on register link$")
	public void i_click_on_register_link(){
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*@When("^i entered the user data$")
	public void i_entered_the_user_data() throws Throwable {
		userReistrationObject = new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userReistrationObject.userRegistration(firstName, lastName, email, password);
	}*/
	
	@When("^i entered the \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered_the(String firstName, String lastName, String email, String password) throws InterruptedException {
		userReistrationObject = new UserRegistrationPage(driver);
		Thread.sleep(5000);
		userReistrationObject.userRegistration(firstName, lastName, email, password);
	}

	@Then("^the registration page displayed successfully$")
	public void the_registration_page_displayed_successfully() throws InterruptedException {
		Thread.sleep(5000);
		userReistrationObject.userLogout();
	}
	
}

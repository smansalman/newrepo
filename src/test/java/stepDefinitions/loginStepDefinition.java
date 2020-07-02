package stepDefinitions;

import org.junit.Assert;


import core.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPageObj;

public class loginStepDefinition extends Base {
	// create Obj of LoginPageObj
	LoginPageObj loginPageObj = new LoginPageObj();
	
	@Given("^User is on TEST Environment page$")
	public void user_is_on_TEST_Environment_page() throws Throwable {
		Base.initializeDriver();
	
	}
	@When("^User click on MyAccount$")
	public void user_click_on_MyAccount() throws Throwable {
		loginPageObj.clickOnMyAccount();
	  
	}
	@When("^User click on Login$")
	public void user_click_on_Login() throws Throwable {
		loginPageObj.clickOnLogin();
	}
	// (.+)  - using this special characters we can parameterize the method so we can use same method with different values
	
	@When("^User enters username '(.+)' and Password '(.+)'$")
	public void user_enters_username_sdet_tekschool_us_and_Password_sdet(String userName, String passWord) throws Throwable {
		loginPageObj.enterEmail(userName);
		loginPageObj.enterPassword(passWord);
	
	}
	@When("^User click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		loginPageObj.clickOnLoginButton();
	 
	}
	@Then("^User Should be logged in to user Dashboard$")
	public void user_Should_be_logged_in_to_user_Dashboard() throws Throwable {
		
		String expectedPageTitle = "My Account";
		String actualPageTitle = loginPageObj.getPageTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		
		
	
	}

}

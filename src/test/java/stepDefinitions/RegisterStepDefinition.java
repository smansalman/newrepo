package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Assert;

import core.Base;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.RegisterPageObj;
import utilities.DriverUtility;

public class RegisterStepDefinition extends Base {
	RegisterPageObj registerPageObj = new RegisterPageObj();
	@When("^User click on Register$")
	public void user_click_on_Register() throws Throwable {
		try {
			registerPageObj.clickOnRegister();
			Logger.info("click on register");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		DriverUtility.screenShot();
	}
	@When("^User fills Register form with below information$")
	public void user_fills_Register_form_with_below_information(DataTable personalInfo) throws Throwable {
//		List<List<String>> dataValues = personalInfo.raw(); // .raw will return string value of list of list
//		registerPageObj.enterFNameValue(dataValues.get(0).get(0));
//		registerPageObj.enterLNameValue(dataValues.get(0).get(1));
//		registerPageObj.enterEmailValue(dataValues.get(0).get(2));
//		registerPageObj.enterTelephoneValue(dataValues.get(0).get(3));
//		registerPageObj.enterpasswordValue(dataValues.get(0).get(4));
//		registerPageObj.enterConfirmPassValue(dataValues.get(0).get(4));
		
		// When use List<List> for processing data tables we use .raw method
		// when we use list<map> for processing data tables we use .asMaps(String.class, String.class)
		List<Map<String, String>> dataValues = personalInfo.asMaps(String.class, String.class);
		registerPageObj.enterFNameValue(dataValues.get(0).get("firstName"));
		registerPageObj.enterLNameValue(dataValues.get(0).get("LastName"));
		registerPageObj.enterEmailValue(dataValues.get(0).get("E-mail"));
		registerPageObj.enterTelephoneValue(dataValues.get(0).get("Telephone"));
		registerPageObj.enterpasswordValue(dataValues.get(0).get("password"));
		registerPageObj.enterConfirmPassValue(dataValues.get(0).get("password"));
		Logger.info("Register form was filled successfully");
	}
	@When("^User select '(.+)' for Subscribe$")
	public void user_select_yes_for_Subscribe(String yesNo) throws Throwable {
		if (yesNo.equalsIgnoreCase("yes")) {
			if(registerPageObj.noIsSelected()) {
				registerPageObj.selectYesonSubscribe();
				Logger.info("yes to subscribe is selected");
			}
		}else {
			if(!registerPageObj.noIsSelected()) {
				registerPageObj.selectNoSubscribe();
				Logger.info("No to subscribe is selected");
			}
		}
	}
	@When("^User click privacy and policy button$")
	public void user_click_privacy_and_policy_button() throws Throwable {
		Assert.assertTrue(registerPageObj.isPrivacyPolicyDisplayed());
		registerPageObj.clickonPrivacyPolicy();
		Logger.info("privacy policy is selected");
		DriverUtility.screenShot();
	}
	@When("^User click Continue button$")
	public void user_click_Continue_button() throws Throwable {
		try {
			registerPageObj.clickonContinueButtonREG();
			Logger.info("Continue button is clicked");
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	@Then("^User should see message  '(.+)'$")
	public void user_should_see_message_Your_Account_Has_Been_Created(String message) throws Throwable {
		DriverUtility.wait(5000);
		Assert.assertEquals(registerPageObj.getSuccessfullAcctCreationMessage(),message);
		Logger.info("Assertion passed");
		DriverUtility.screenShot();
	}
	

}

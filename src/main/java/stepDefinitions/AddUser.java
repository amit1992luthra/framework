package stepDefinitions;

import org.openqa.selenium.support.ui.Wait;

import com.ContextInjection.ScenarioContext;
import com.core.Apputils;
import com.seleniumFuctions.SeleniumFunctions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class AddUser extends SeleniumFunctions {

	ScenarioContext ScenarioContext;

	public AddUser(ScenarioContext scenarioContext) {
		this.ScenarioContext = scenarioContext;
	}

	@And("^user clicks on Add user button$")
	public void user_clicks_on_Add_user_button() {
		try {
			Page("HomePage").clickElement("AddUser");
		} catch (Exception ex) {
		}
	}

	@Then("^user Add new user with existing user details \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Add_new_user_with_and(String firstname, String lastname, String email) {

		try {
			Apputils.getInstance().Adduser(firstname, lastname, email);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// user again add the same details

	@Then("^user again add the same details and verify \"([^\"]*)\" message$")
	public void user_again_add_the_same_details_and_verify_message(String expected) {
		try {
			expected = Page("AddUser").GetElementText("popuptitle");

			Assert.assertTrue(expected.contains("This user already exists."));

		} catch (Exception ex) {
		}
	}

	@Then("^Verify \"([^\"]*)\"link$")
	public void verify_link(String expected) {
		try {

			expected = Page("AddUser").GetElementText("viewExistingUser");
			Assert.assertTrue(expected.contains("View existing user"));

		} catch (Exception ex) {
		}
	}

	@Then("^Click on Edit User button$")
	public void click_on_Edit_User_button() {
		try {

			Page("AddUser").clickElement("editUser");

		} catch (Exception ex) {
		}
	}

	@Given("^user is on dashboard$")
	public void user_is_on_dashboard() {
		try {

			Assert.assertTrue(Page("HomePage").verifyTitle("GS1 Activate: Dashboard"));

		} catch (Exception ex) {
		}
	}

	@When("^user enter first name \"([^\"]*)\"$")
	public void user_enter_first_name(String firstname) {
		try {

			Page("AddUser").ClearTextWithsendKeys("firstName", firstname, true, "");

		} catch (Exception ex) {
		}
	}

	@Then("^verify save button should be disabled$")
	public void verify_save_button_should_be_disabled() {

		try {

			Assert.assertFalse(Page("AddUser").checkElementEnabled("saveButton"));

		} catch (Exception ex) {
		}
	}
	
	//verify save button should be enabled
	
	@Then("^verify save button should be enabled$")
	public void verify_savebutton_should_be_enabled() {

		try {

			Assert.assertTrue(Page("AddUser").checkElementEnabled("saveButton"));

		} catch (Exception ex) {
		}
	}

	@When("^user enter last name \"([^\"]*)\"$")
	public void user_enter_last_name(String Lastname) {

		try {

			Page("AddUser").ClearTextWithsendKeys("lastName", Lastname, true, "");

		} catch (Exception ex) {
		}

	}
	
	
	@When("^user enter Email Address \"([^\"]*)\"$")
	public void user_enter_Email_Address(String Email) {

		try {

			Page("AddUser").ClearTextWithsendKeys("emailAddress", Email, true, "");

		} catch (Exception ex) {
		}

	}
	
	@When("^user enter Company name$")
	public void user_enter_Company_name() {

		try {

			Page("AddUser").ClearTextWithsendKeys("companyName", "abc limited", true, "");
			Page("AddUser").clickElement("companyNamedropdown");

		} catch (Exception ex) {
		}

	}

	@Then("^user Add new user with new user details \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Add_new_user_with_new(String firstname, String lastname, String email) {

		try {
			Apputils.getInstance().Adduser(firstname, lastname, email);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Then("^go to dashboard button$")
	public void go_to_dashboard_button() {

		try {	
			
			Page("AddUser").clickElement("clickongotodashboard");

		} catch (Exception ex) {
		}
	}
	
	@When("^verify first name field$")
	public void verify_first_name_field() {
		try {

			Assert.assertTrue(Page("AddUser").checkElementEnabled("firstName"));

		} catch (Exception ex) {
		}
	}
	
	@When("^verify last name field$")
	public void verify_last_name_field() {
		try {

			Assert.assertTrue(Page("AddUser").checkElementEnabled("lastName"));

		} catch (Exception ex) {
		}
	}
	
	@When("^verify Email Address field$")
	public void verify_Email_Address_field() {
		try {

			Assert.assertTrue(Page("AddUser").checkElementEnabled("emailAddress"));

		} catch (Exception ex) {
		}
	}
	
	@When("^verify Company name field$")
	public void verify_Comapany_name_field() {
		try {

			Assert.assertTrue(Page("AddUser").checkElementEnabled("companyName"));

		} catch (Exception ex) {
		}
	}
	
	@When("^verify Reference Number field$")
	public void verify_Reference_Number_field() {
		try {

			Assert.assertTrue(Page("AddUser").checkElementEnabled("referencenumber"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
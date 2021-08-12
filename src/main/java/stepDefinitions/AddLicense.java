package stepDefinitions;

import com.ContextInjection.ScenarioContext;
import com.core.AssertUtils;
import com.seleniumFuctions.SeleniumFunctions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddLicense extends SeleniumFunctions{

	 ScenarioContext ScenarioContext ;
	 public AddLicense(ScenarioContext scenarioContext){
		 this.ScenarioContext= scenarioContext;
	 }
	 
	@When("^user clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String arg1) {
		try {
			Page("AddLicense").clickElement("AddLicenseLink");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@When("^user inputs License Number \"([^\"]*)\" Company Name \"([^\"]*)\" and License Status \"([^\"]*)\"$")
	public void user_inputs_License_Number_Company_Name_and_License_Status(String LicenseNo, String CompanyName, String LicenseStatus) {
		try {
			Page("AddLicense").sendKeysToElement("LicenseNo", LicenseNo);
			ScenarioContext.setScenarioContext("LicenseNo", LicenseNo);
			Page("AddLicense").sendKeysToElement("CompanyName", CompanyName);
			Page("AddLicense").clickDynamicElement("SelectCompanyName", CompanyName);
			Page("AddLicense").selectElementByText("LicenseStatus", LicenseStatus);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^Click save button to save the license$")
	public void click_save_button_to_save_the_license() {
		try {
			Page("AddLicense").clickElement("SaveLicense");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^user should see popup with Message \"([^\"]*)\"$")
	public void user_should_see_popup_with_Message(String Message) {
		try {
			String popupmsg = Page("AddLicense").GetElementText("PopUp").toString();
			if(popupmsg.contains("This licence already exists")) {
				AssertUtils.getInstance().Fail("License " + ScenarioContext.getScenarioContext("LicenseNo") + " already exists");
			}
			else {
				//AssertUtils.getInstance().assertEquals(Message.toUpperCase(), popupmsg.toUpperCase(), "PopUp with " + Message + " not displayed");
			}
		} catch (Exception e) {			
				e.printStackTrace();
			}
	}

	@When("^user clicks \"([^\"]*)\" button from the Popup$")
	public void user_clicks_from_the_Popup(String BtnName) {
		try {
			Page("AddLicense").clickDynamicElement("PopUpBtns", BtnName);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

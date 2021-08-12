package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.ContextInjection.FeatureContext;
import com.ContextInjection.ScenarioContext;
import com.core.AssertUtils;
import com.core.CommonUtils;
import com.core.Hooks;
import com.core.ReportsUtils;
import com.core.TestProperties;
import com.core.WebDriverUtils;
import com.seleniumFuctions.SeleniumFunctions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;

public class LicenceNotifications extends SeleniumFunctions {

	ScenarioContext ScenarioContext;
	FeatureContext FeatureContext;

	public LicenceNotifications(ScenarioContext scenarioContext) {
		this.ScenarioContext = scenarioContext;
	}	

	@Then("verify that {string} message appears")
	public void verify_that_message_appears(String msgText) {
		try {		
			
			CommonUtils.pause(3);
			Page("LicensePage").checkDynamicElementVisibility("licenceMessage", msgText);
		
			} catch (Exception e) {
				
				AssertUtils.getInstance().Fail(e.getMessage());
			
		}	
	}

	@Then("user Activate a Licence with capacity available")
	public void user_Activate_a_Licence_with_capacity_available() {
		
		try {			
			
			CommonUtils.pause(3);
			Page("LicensePage").clickToElementByJS("ToggleLicence");
		
			} catch (Exception e) {
				
				AssertUtils.getInstance().Fail(e.getMessage());
			
		}	
	    
	}

	@Then("user clicks on the {string} link in the menu")
	public void user_clicks_on_the_link_in_the_menu(String menuLink) {
		try {			
			
			Page("HomePage").clickElement(menuLink);
		
			} catch (Exception e) {
				
				AssertUtils.getInstance().Fail(e.getMessage());
			
		}	
	}

	@When("user clicks on {string} button")
	public void user_clicks_on_button(String msgButton) {
		try {			
			
			Page("LicensePage").clickDynamicElement("NextStepButton", msgButton);
			
			} catch (Exception e) {
					
				AssertUtils.getInstance().Fail(e.getMessage());
				
			}
	}

	@Then("verify that the user is navigated to {string} page")
	public void verify_that_the_user_is_navigated_to_page(String pageText) {
		try {	
			
			assertEquals(Page("GenericControls").GetDynamicElementText("PageVerification", pageText), pageText); 
		
			//WebDriverUtils.CloseBrowser();
			} catch (Exception e) {
				
				AssertUtils.getInstance().Fail(e.getMessage());			
		}	
	}
	
	@When("user clicks draft product named {string}")
	public void user_clicks_draft_product_named(String productName) {
		try {	
			
			CommonUtils.pause(3);
			Page("LicensePage").clickDynamicElement("DraftProduct", productName);		
			//Page("LicensePage").clickElement("DraftProduct");
			
			} catch (Exception e) {	
				
				AssertUtils.getInstance().Fail(e.getMessage());		
		}	
	}
	
	@When("user clicks on Finalise button")
	public void user_clicks_on_Finalise_button() {
		try {			
			
			CommonUtils.pause(5);
			Page("LicensePage").scrollToEnd();
			CommonUtils.pause(2);
			Page("LicensePage").clickToElementByJS("FinaliseDraft");
			CommonUtils.pause(2);
			
			} catch (Exception e) {		
				
				AssertUtils.getInstance().Fail(e.getMessage());				
			}
	}
	
	@When("user clicks button named {string}")
	public void user_clicks_button_named(String productButton) {
		try {			
			
			Page("SearchPage").clickDynamicElement("addProduct", productButton);	
			
			} catch (Exception e) {					
				
				AssertUtils.getInstance().Fail(e.getMessage());				
			}
	}
	
	@Then("user search the product {string}")
	public void user_search_the_product(String productName) {
		try {			
			
			Page("SearchPage").sendKeysToElement("searchfield", productName);
			Page("SearchPage").clickDynamicElement("clickonresult", productName);	
			
			} catch (Exception e) {					
				
				AssertUtils.getInstance().Fail(e.getMessage());				
			}
	}

}

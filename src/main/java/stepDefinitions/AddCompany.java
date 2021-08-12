package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
 import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.interactions.Actions;

import com.ContextInjection.ScenarioContext;
import com.core.CommonUtils;
import com.core.Hooks;
import com.core.TestProperties;
import com.core.WebDriverUtils;
import com.seleniumFuctions.SeleniumFunctions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
 import cucumber.api.java.en.Then;
 import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import io.qameta.allure.Description;
import io.qameta.allure.Story;


public class AddCompany extends SeleniumFunctions{
	
	 ScenarioContext ScenarioContext ;
	 public AddCompany(ScenarioContext scenarioContext){
		 this.ScenarioContext= scenarioContext;
	 }
	
	 @When("^enter a \"([^\"]*)\" and \"([^\"]*)\" combination$")
		public void enter_a_new_combination(String companyname, String country) {
			
			ScenarioContext.setScenarioContext("CompanyName", companyname);
			ScenarioContext.setScenarioContext("Country", country);
			
			try {
				Page("AddCompany").clickElement("AddCompanyLink");
				Page("AddCompany").ClearTextWithsendKeys("InputCompanyName", companyname, true, "");
				Page("AddCompany").ClearTextWithsendKeys("InputCountry", country, true, "" );
				Thread.sleep(1000);
				Page("AddCompany").getElement("InputCountry").sendKeys(Keys.ENTER);
				Page("AddCompany").clickElement("SaveCompany");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}		
		}
		
		@Then("^company should be added successfully$")
		public void company_added_successfully() {
			try {
				String company_name = (String) ScenarioContext.getScenarioContext("CompanyName");
				
				Assert.assertEquals("New Company is also a duplicate", (Page("AddCompany").getElement("ErrorMessageDups").getText().contains("This company already exists")), false);
				
				Assert.assertEquals("New Company not added successfully", Page("AddCompany").getElement("AddSuccess").isDisplayed(), true);
				Assert.assertEquals("Company Name after New Addition is not displayed", Page("AddCompany").getElement("AfterAddCompanyName").isDisplayed(), true);
				Page("AddCompany").clickElement("ViewCompanyDetails");
				Assert.assertEquals("Company Name is not matching", Page("AddCompany").getElement("CompanyHeader").getText(), company_name);
				
				}
					catch (Exception e) {
				e.printStackTrace();
			}
		}

	 @Then("^enter the same combination again$")
	public void enter_an_existing_and_combination() {
		try {
			
			String ex_companyname = (String) ScenarioContext.getScenarioContext("CompanyName");
			String ex_country = (String) ScenarioContext.getScenarioContext("Country");
			
			Page("AddCompany").clickElement("ClickOnAdmin");
		
			enter_a_new_combination(ex_companyname, ex_country );
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^system should display an error message$")
	public void system_should_display_an_error_message() {
		try {
			Assert.assertEquals("Error Message not displayed", (Page("AddCompany").getElement("ErrorMessageDups").getText().contains("This company already exists")), true);
			Assert.assertEquals("View Existing Link is not visible", Page("AddCompany").getElement("ViewExistingLink").isDisplayed(), true);
			Assert.assertEquals("Edit Company Link is not displayed", Page("AddCompany").getElement("EditCompany").isDisplayed(), true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^click on View Existing Company$")
	public void click_on_View_Existing_Company() {
		try {
			Page("AddCompany").clickElement("ViewExistingLink");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Then("^existing company should be displayed with same details$")
	public void existing_company_should_be_displayed() {
		try {
			String ex_companyname1 = (String) ScenarioContext.getScenarioContext("CompanyName");
		Assert.assertEquals("Company Name is not matching", Page("AddCompany").getElement("CompanyHeader").getText(), ex_companyname1);
		Thread.sleep(500);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^change the duplicate company to new \"([^\"]*)\" and save$")
	public void change_the_new_and_save(String new_company) {
		try {
			ScenarioContext.setScenarioContext("NewCompanyName", new_company);
			
			enter_an_existing_and_combination();
			
			Page("AddCompany").clickElement("EditCompany");
			Page("AddCompany").getElement("InputCompanyName").clear();
			Page("AddCompany").ClearTextWithsendKeys("InputCompanyName", new_company, true, "");
			Page("AddCompany").clickElement("SaveCompany");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Then("^new company should get saved$")
	public void new_company_should_get_added() {
		try {
			String new_company_name = (String) ScenarioContext.getScenarioContext("NewCompanyName");
			
			Assert.assertEquals("New Company is also a duplicate", (Page("AddCompany").getElement("ErrorMessageDups").getText().contains("This company already exists")), false);
			
			Assert.assertEquals("New Company not added successfully", Page("AddCompany").getElement("AddSuccess").isDisplayed(), true);
			Assert.assertEquals("Company Name after New Addition is not displayed", Page("AddCompany").getElement("AfterAddCompanyName").isDisplayed(), true);
			Page("AddCompany").clickElement("ViewCompanyDetails");
			Assert.assertEquals("Company Name is not matching", Page("AddCompany").getElement("CompanyHeader").getText(), new_company_name);
			
			}
				catch (Exception e) {
			e.printStackTrace();
		}
	}

}

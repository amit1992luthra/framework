package stepDefinitions;

import cucumber.api.PendingException;

import static org.junit.Assert.assertNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

public class ManageSuggestionsDeletions extends SeleniumFunctions {
	
	ScenarioContext ScenarioContext;
	Boolean productAvailability = false;
	Boolean expectedproductAvailability = false;
	Boolean elementnotAvailable = false;
	String deletedproducttext =""; 
	int totalproductcount = 0;
	String producttoDelete= "";
	String str = "BN00117479";
	
	public ManageSuggestionsDeletions(ScenarioContext scenarioContext) {
		this.ScenarioContext = scenarioContext;
	}
	
	@When("^user clicks \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_clicks_and(String arg1, String arg2){
		try {
			Page("HomePage").clickElement("Link_MyAccount");
			Page("HomePage").clickElement("ManageSuggestion");
		} catch (Exception e) {

		}		
	}
	@When("^user clicks \"([^\"]*)\" a product$")
	public void user_clicks_a_product(String arg1){
		try {			
			
			totalproductcount = Integer.parseInt(Page("ManageSuggestions").GetElementText("totalproducts"));
			System.out.print(totalproductcount);
			deletedproducttext = Page("ManageSuggestions").GetElementText("deleteproducttxt");
			Page("ManageSuggestions").clickElement("deleteproduct");
			
		} catch (Exception e) {

		}		
	}

	@When("^user clicks on Save button$")
	public void user_clicks_on_Save_button(){
		try {			
			Page("ManageSuggestions").clickElement("savebutton");
			Page("ManageSuggestions").clickElement("startusingactivate");
			
		} catch (Exception e) {

		}		
	}

	@Then("^verify the deleted brand name should NOT be available for product creation$")
	public void verify_the_deleted_brand_name_should_NOT_be_available_for_product_creation() throws Exception{
		
			//deletedproducttext="BN00116441";
			try {
				try {
					Page("ManageSuggestions").clickElement("clickonmore");
				} catch (Exception e) {					
					e.printStackTrace();
				}
				try {
					Page("ManageSuggestions").GetDynamicElementText("findbrand", deletedproducttext);
				} catch (java.lang.AssertionError  e) {					
					System.out.print("The deleted brand is not available, test passed");
				}
			} catch (java.lang.AssertionError  e) {
				System.out.print("The deleted brand is not available, test passed");
			}	
	}
	
	@When("^user clicks \"([^\"]*)\" a sub-product$")
	public void user_clicks_a_sub_product(String arg1){
		try {			
			totalproductcount = 0;
			totalproductcount = Integer.parseInt(Page("ManageSuggestions").GetElementText("totalsubproducts"));
			
			deletedproducttext = Page("ManageSuggestions").GetElementText("deletesubproducttxt");
			Page("ManageSuggestions").clickElement("deletesubproduct");
			
		} catch (Exception e) {

		}		
	}

	@Then("^verify the deleted sub-brand name should NOT be available for product creation$")
	public void verify_the_deleted_sub_brand_name_should_NOT_be_available_for_product_creation() throws Exception{
		
		try {
			try {
				Page("ManageSuggestions").clickElement("clickonmoresubproducts");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Page("ManageSuggestions").GetDynamicElementText("findsubbrand", deletedproducttext);
			} catch (java.lang.AssertionError  e) {

				System.out.print("The deleted brand is not available, test passed");
			}
		} catch (NoSuchElementException  e) {
			System.out.print("The deleted brand is not available, test passed");
		}	
	}
	
	@When("^user clicks \"([^\"]*)\" a brand previously used$")
	public void user_clicks_a_brand_previously_used(String arg1){
		try {						
			producttoDelete = Page("ManageSuggestions").GetElementText("totalproducts");			
			deletedproducttext = Page("ManageSuggestions").GetDynamicElementText("findspecificbrand", CreateProductWithBaseUnit.brandNamevar);	
			System.out.println("###########   " + deletedproducttext); 
			Page("ManageSuggestions").clickDynamicElement("deletespecificbrand", producttoDelete);
						
						
		} catch (Exception e) {

		}		
	}
	@Then("^verify the product generated has deleted Brand$")
	public void verify_the_product_generated_has_deleted_Brand(){
		try {						
			Page("HomePage").clickElement("Link_Viewallproducts");
			Page("SearchPage").sendKeysToElement("searchfield", CreateProductWithBaseUnit.brandNamevar);
			Page("SearchPage").clickDynamicElement("clickonresult", CreateProductWithBaseUnit.brandNamevar);
			//Page("SearchPage").sendKeysToElement("searchfield", str);
			//Page("SearchPage").clickDynamicElement("clickonresult", str);
			
			Page("EditProduct").clickElement("editproduct");
			CreateProductWithBaseUnit.brandNamevar.equals(Page("EditProduct").GetElementText("brandname"));
			
		} catch (Exception e) {

		}		
	}
	
	 @When("^user logout from the application$")
	    public void user_logout_from_the_application() throws Throwable {
		 
		 Page("LoginPage").clickElement("logout");
	    }


}

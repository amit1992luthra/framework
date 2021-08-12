package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.joda.time.DateTime;
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
import com.core.AssertUtils;
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


public class BrandSynchronization extends SeleniumFunctions{
	
	ScenarioContext ScenarioContext ;
	public BrandSynchronization(ScenarioContext scenarioContext){
		this.ScenarioContext= scenarioContext;
	}

	
	@When("^user adds new \"([^\"]*)\" name$")
	public void user_adds_new_names(String arg1)  {
		
		
		try {
			ScenarioContext.setScenarioContext("Runparameter", arg1);
			
			if (arg1.contains("Sub-Brand")){
				Page("LoginPage").clickDynamicElement("ToHighlightGeneric", "Brand name");
				
				Page("LoginPage").clickDynamicElement("btnGeneric", "Create a new sub brand");
				String SBN = "SBN001" + DateTime.now().getSecondOfDay();
				Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", SBN, true, "Sub-brand");
				Page("LoginPage").clickDynamicElement("btnGeneric","Add");
				
				ScenarioContext.setScenarioContext("Highlighted_Value_SubBrand", Page("PageHeader").getElementDynamically("HighlightGeneric", "Sub-brand").getText());
			}
			else
			{
				Page("LoginPage").clickDynamicElement("btnGeneric", "Create a new brand");
				String BN = "BN001" + DateTime.now().getSecondOfDay();
				Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", BN, true, "Brand name");
				Page("LoginPage").clickDynamicElement("btnGeneric","Add");
				
				ScenarioContext.setScenarioContext("Highlighted_Value_Brand", Page("PageHeader").getElementDynamically("HighlightGeneric", "Brand name").getText());
			}

			
		String FSBN = "BN001" + DateTime.now().getSecondOfDay();
		Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric","FN"+ FSBN, true, "Functional name");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^Country as \"([^\"]*)\" and Global product category as \"([^\"]*)\"$")
	public void country_as_and_Global_product_category_as(String Country, String product_category) {
		try {
			
			Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", Country, true, "Countries of Sale");
			Page("LoginPage").clickDynamicElement("optionCountry", Country);
			
			Page("LoginPage").ClearTextWithsendKeys("productCategory", product_category, true, "");	
			Page("LoginPage").EnterPress();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("^creates the product with net content value as \"([^\"]*)\" Unit of Measure as \"([^\"]*)\"$")
	public void creates_the_product_with_net_content_value_as_Unit_of_Measure_as(String netContent, String UOM){
		try {
			String GTIN = "GTIN";
			
			Page("LoginPage").clickElement("netContent");
			Page("LoginPage").ClearTextWithsendKeys("netContent", netContent,true,"");
			//Page("LoginPage").selectElementByIndex("selectUOM",1);
			Page("LoginPage").selectElementByText("selectUOM", UOM);
			Page("LoginPage").clickDynamicElement("btnGeneric","Next");
			Page("LoginPage").clickDynamicElement("btnGeneric","Finalise");
			
			ScenarioContext.setScenarioContext(GTIN, Page("LoginPage").GetElementText("labelGTIN"));
			
			//ScenarioContext.setScenarioContext(GTIN, Page("LoginPage").GetElementText("labelGTIN", "text"));
			//Page("LoginPage").clickDynamicElement("btnGeneric","Get a barcode image/symbol");
			//file will be downloaded in downloads with name containing GTIN
			//GTIN will be part of pdf file name to be downloaded and the barcode will be same as GTIN
			//Page("LoginPage").clickElement("downloadBarcodePDF");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Then("^verify the product code generated on Recent product on home page$")
	public void verify_the_product_generated() {

		// GTIN will be part of pdf file name to be downloaded and the barcode will be
		// same as GTIN
		try {
			
			Page("GenericControls").clickDynamicElement("tabGeneric", "Home");
			String productCodeGenerated = ScenarioContext.getScenarioContext("GTIN").toString();
			String gtinPdf = Page("GenericControls").GetDynamicElementText("productGTIN",productCodeGenerated );
			String verifygtinpdf = gtinPdf;
			String verifygtnpdf2= verifygtinpdf;
			
		} catch (Exception e) {
			
			AssertUtils.getInstance().Fail("The product is not found on home page. Either its not created or not shown on home page.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@When("^select Manage Suggestions from My Account dropdown$")
	public void select_Manage_Suggestions_from_My_Account_dropdown() {
		try {
		Page("PageHeader").clickElement("MyAccountClick");
		Page("PageHeader").clickElement("ManageSuggestions");
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	

	@Then("^values created above should be visible in \"([^\"]*)\"$")
	public void Brands_and_Sub_Brands_created_above_should_be_visible_in(String arg2) {
		
		try {
			
			String Testparameter = (String) ScenarioContext.getScenarioContext("Runparameter");
			
			if (Testparameter.contains("Sub-Brand")){
				String SubBrandName = (String) ScenarioContext.getScenarioContext("Highlighted_Value_SubBrand");
				Assert.assertEquals("Sub-Brand name is not present", (Page("PageHeader").getElementDynamically("Values_Subbrand", SubBrandName )).isDisplayed(), true);
				System.out.println("End of Sub Brand Test");
			}
			else {
				String BrandName = (String) ScenarioContext.getScenarioContext("Highlighted_Value_Brand");
			Assert.assertEquals("Brand name is not present", (Page("PageHeader").getElementDynamically("Values_brand", BrandName)).isDisplayed(), true);
			System.out.println("End of Brand Test");
			}
			
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}

package stepDefinitions;

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

public class CreateProductWithBaseUnit extends SeleniumFunctions {

	ScenarioContext ScenarioContext;
	FeatureContext FeatureContext;
	Boolean productFixed = false;
	public static String brandNamevar ="";

	public CreateProductWithBaseUnit(ScenarioContext scenarioContext) {
		this.ScenarioContext = scenarioContext;
	}

	@When("^user clicks \"([^\"]*)\" named \"([^\"]*)\"$")
	public void user_clicks_named(String elementType, String elementText) {
		try {
			CommonUtils.pause(5);
			Page("HomePage").clickElement("btnAddProduct");

		} catch (Exception e) {

		}
	}

	@When("^user clicks Vcard with option \"(.*)\"$")
	public void user_clicks_Vcard_with_option(String vcardText) {

		try {
			Page("ProductPage").clickDynamicElement("vCard", vcardText);
			if (vcardText.toLowerCase().contains("unit price is fixed")) {
				productFixed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("^user uploads product image as \"(.*)\"$")
	public void user_uploads_product_image_as(String image) {

		try {
			if(Page("ProductPage").checkElementVisibility("UploadImage"))
			{
				uploadFileDialog("UploadImage",image);
				
			}
			CommonUtils.pause(2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("^user uploads product image URL as \"([^\"]*)\" and Language as \"([^\"]*)\"$")
	//@When("^user uploads product image URL as \"(.*)\"$")
	public void user_uploads_product_image_URL_as(String image, String language) {

		try {
			int count = 0;
			if(ScenarioContext.isContain("ProductImageCount"))
			{
				user_clicks_Next_to_create_the_product("Add product image URLs", "URL");				
			}
			else
			{
				ScenarioContext.setScenarioContext("ProductImageCount", 1);
				ScenarioContext.setScenarioContext("ImageUploaded", image);
			}
			    count = (int) ScenarioContext.getScenarioContext("ProductImageCount");
				Page("ProductPage").sendKeysToElement("AddImageURL" +String.valueOf(count) , image);
				Page("ProductPage").clickElement("LanguageImageURL"+String.valueOf(count));
				//Page("ProductPage").scrollTo("1000");
				//Page("ProductPage").SlideTo("LanguageScroll", 10, "H");
				Page("ProductPage").clickDynamicElement("LanguageSelectGeneric", language);
				ScenarioContext.setScenarioContext("ProductImageCount", count+1);
				
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^user clicks \"(.*)\" to \"(.*)\"$")
	public void user_clicks_Next_to_create_the_product(String btnName, String action) {

		try {
			Page("LoginPage").clickDynamicElement("btnGeneric", btnName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("^user creates the brand with name as \"(.*)\" net content value as \"(.*)\" country as \"(.*)\" and Global product category as \"(.*)\"$")
	public void user_create_the_brand(String brandName, String netContent, String Country, String productCategory) {
		String GTIN = "GTIN";
		try {
			//Page("ProductPage").clickElement("CreateBrandName");
			String BN = "BN001" + DateTime.now().getSecondOfDay();
			ScenarioContext.setScenarioContext("brandname", BN);
			//CreateProductWithBaseUnit.brandNamevar=BN;
			Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", BN, true, "Brand name");
			
			Page("LoginPage").clickDynamicElement("btnGeneric", "Add");
			Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", "FN" + BN, true, "Functional name");

			if (productFixed)
				Page("LoginPage").ClearTextWithsendKeys("netContent", netContent, true, "");
			Page("LoginPage").selectElementByIndex("selectUOM", 1);

			Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", Country, true, "Countries of Sale");
			Page("LoginPage").clickDynamicElement("optionCountry", Country);
			Page("LoginPage").TabPress();
			Page("LoginPage").clickElement("netContent");

			Page("LoginPage").ClearTextWithsendKeys("productCategory", "Milk", true, "");
			Page("LoginPage").EnterPress();

			Page("LoginPage").clickDynamicElement("btnGeneric", "Next");
			CommonUtils.pause(5);
			Page("ProductPage").clickElement("finalize");
			
			ScenarioContext.setScenarioContext(GTIN, Page("LoginPage").GetElementText("labelGTIN"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^verify the product generated on Recent product on home page with images$")
	public void verify_the_product_generated_with_images() {

		// GTIN will be part of pdf file name to be downloaded and the barcode will be
		// same as GTIN
		String GTIN = "GTIN";
		try {
			
			if(Page("ProductPage").checkDynamicElementVisibility("VerifyImage",(String)ScenarioContext.getScenarioContext("ImageUploaded")))
			{
				int i = 0;
			}
		//	Page("LoginPage").clickDynamicElement("btnGeneric", "Finalise");
			
			ScenarioContext.setScenarioContext(GTIN, Page("LoginPage").GetElementText("labelGTIN"));
			
			Page("HomePage").clickDynamicElement("tabGeneric", "Home");
			String productCodeGenerated = ScenarioContext.getScenarioContext("GTIN").toString();
			String gtinPdf = Page("GenericControls").GetDynamicElementText("productGTIN",productCodeGenerated );

			
			
		} catch (Exception e) {
			
			AssertUtils.getInstance().Fail("The product is not found on home page. Either its not created or not shown on home page.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^user clicks \"([^\"]*)\" to Finalise the Product$")
    public void user_clicks_something_to_finalise_the_product(String strArg1) throws Throwable {
		Page("LoginPage").clickDynamicElement("btnGeneric", "Finalise");
    }
	
	@Then("^verify the product generated on Recent product on home page$")
	public void verify_the_product_generated() {

		// GTIN will be part of pdf file name to be downloaded and the barcode will be
		// same as GTIN
		
		try {
			
			Page("GenericControls").clickDynamicElement("tabGeneric", "Home");
			String productCodeGenerated = ScenarioContext.getScenarioContext("GTIN").toString();
			String gtinPdf = Page("GenericControls").GetDynamicElementText("productGTIN",productCodeGenerated );

			
			
		} catch (Exception e) {
			
			AssertUtils.getInstance().Fail("The product is not found on home page. Either its not created or not shown on home page.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("verify the image {string} is uploaded successfully")
	public void verify_the_image_is_uploaded_successfully(String imagePath) {
	   
		try {
			if (Page("ProductPage").checkDynamicElementVisibility("VerifyImage","no-image")) {
				AssertUtils.getInstance().Fail("Image Not uploaded successfully");
			}
			else{
				ReportsUtils.AttachImagetoReport(imagePath);
				ReportsUtils.AddToReport("Image Uploaded Successfully:-", imagePath);
			}
			
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}
		
	}
	
	@When("User enters language {string}")
	public void user_enters_language(String Language) {
	  try {
		  Page("ProductPage").clickElement("ImageLangDropDown");
		  Page("ProductPage").clickDynamicElement("LanguageSelectGeneric", Language);
	} catch (Exception e) {
		
	}
	
	}
	
	@Then("verify the brand name is generated Welcome to Activate Page")
	public void verify_the_brand_name_is_generated_Welcome_to_Activate_Page() {
		try {
			Thread.sleep(3000);
			Page("ManageSuggestions").clickElement("Myaccount");
			Page("ManageSuggestions").clickElement("ManageSuggestion");
			String brandname = ScenarioContext.getScenarioContext("brandname").toString();
			Page("ProductPage").GetDynamicElementText("brandname", brandname);
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("user creates the Sub brand with name {string} net content value as {string} country as {string} and Global product category as {string}")
	public void user_creates_the_Sub_brand_with_name_net_content_value_as_country_as_and_Global_product_category_as(String brandName, String netContent, String Country, String productCategory) {
		
		try {
			//Page("ProductPage").clickElement("CreateBrandName");
			String BN = "BN001" + DateTime.now().getSecondOfDay();
			CreateProductWithBaseUnit.brandNamevar = BN;
			//FeatureContext.setFeatureContext("brandname", BN);
			Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", BN, true, "Brand name");
			Page("LoginPage").clickDynamicElement("btnGeneric", "Add");
			//Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", "FN" + BN, true, "Functional name");
			
			
			
			
			Page("ProductPage").clickElement("CreateSubBrandName");
			String SBN = "SN001" + DateTime.now().getSecondOfDay();
			ScenarioContext.setScenarioContext("subbrandname", SBN);
			//FeatureContext.setFeatureContext("subbrandname", SBN);
			
			Page("ProductPage").sendKeysToElement("SubbrandText", SBN);
			Page("ProductPage").clickElement("AddSubBrandNameButton");
			Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", "FN" + BN, true, "Functional name");

			if (productFixed)
				Page("LoginPage").ClearTextWithsendKeys("netContent", netContent, true, "");
			Page("LoginPage").selectElementByIndex("selectUOM", 1);

			Page("LoginPage").ClearTextWithsendKeys("inputTextGeneric", Country, true, "Countries of Sale");
			Page("LoginPage").clickDynamicElement("optionCountry", Country);
			Page("LoginPage").clickElement("netContent");

			Page("LoginPage").ClearTextWithsendKeys("productCategory", "Milk", true, "");
			Page("LoginPage").EnterPress();

			Page("LoginPage").clickDynamicElement("btnGeneric", "Next");
			Thread.sleep(2000);
			Page("ProductPage").clickElement("finalize");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("verify the Sub brand name is generated Welcome to Activate Page")
	public void verify_the_Sub_brand_name_is_generated_Welcome_to_Activate_Page() {
		try {
			Thread.sleep(3000);
			Page("ManageSuggestions").clickElement("Myaccount");
			Page("ManageSuggestions").clickElement("ManageSuggestion");
			String subbrandname =ScenarioContext.getScenarioContext("subbrandname").toString();
			Page("ProductPage").GetDynamicElementText("brandname", subbrandname);
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("user delete the brand name")
	public void user_delete_the_brand_name() {
		try {
			//test
			
			String brandname = ScenarioContext.getScenarioContext("brandname").toString();
			Page("ManageSuggestions").clickDynamicElement("close", brandname);
			
			Page("ManageSuggestions").clickElement("save");
			Page("ManageSuggestions").clickElement("ActivateButton");
			
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("user delete the sub brand name")
	public void user_delete_the_sub_brand_name() {
		try {
			//test
			
			String Subbrandname = ScenarioContext.getScenarioContext("subbrandname").toString();
			Page("ManageSuggestions").clickDynamicElement("close", Subbrandname);
			
			Page("ManageSuggestions").clickElement("save");
			Page("ManageSuggestions").clickElement("ActivateButton");
			
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

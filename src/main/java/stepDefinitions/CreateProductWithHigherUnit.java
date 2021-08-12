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
import org.openqa.selenium.Point;
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
import io.qameta.allure.Description;
import io.qameta.allure.Story;


public class CreateProductWithHigherUnit extends SeleniumFunctions{
	
	ScenarioContext ScenarioContext ;
	Boolean productFixed = false;
	
	public CreateProductWithHigherUnit(ScenarioContext scenarioContext){
		this.ScenarioContext= scenarioContext;
	}
	
	@When("^user selects \"([^\"]*)\" products from the list and clicks \"([^\"]*)\"$")
	public void user_selects_products_from_the_list_and_clicks(int numberofproducts, String Next) {
		
		ScenarioContext.setScenarioContext("Counts", numberofproducts);
		
		try {
			Thread.sleep(6000);
		Assert.assertNotNull("No products returned", Page("ProductAdd").getElement("ListofProducts"));
		
		for (int i=1; i < numberofproducts+1; i++) {
			Page("ProductAdd").clickDynamicElement("SelectProduct", String.valueOf(i));
		}
		Page("ProductAdd").clickDynamicElement("btnGeneric", Next);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^enters the quantity as \\\"([^\\\"]*)\\\" for products$")
	public void enters_the_quantity_for_products(String quantities) {
		
		try {
		int Counts = (int) ScenarioContext.getScenarioContext("Counts");
		String[] splitQty = quantities.split(",");
		Assert.assertEquals("Please pass the quantity matching with the products selected", Counts, splitQty.length);
		
		for (int i=1; i <= Counts; i++) {
				WebElement Qty = Page("ProductAdd").getElementDynamically("EnterQtyofProduct", String.valueOf(i));
				Qty.clear();
				for (int j=i-1; j < i; j++)
				{
					Qty.sendKeys(splitQty[j]);
				}
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^enters the Pack Name as \\\"([^\\\"]*)\\\" and clicks \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enters_the_and_clicks_and(String HigherUnitPack, String Next, String Finalise) {
		String GTIN = "GTIN";
		try {
			String Packname = HigherUnitPack + " " + DateTime.now().getMillisOfDay();
			
		Page("ProductAdd").ClearTextWithsendKeys("EnterPackName", Packname, true, "");
		Page("ProductAdd").clickDynamicElement("btnGeneric", Next);
		Page("ProductAdd").clickDynamicElement("btnGeneric", Finalise);
		
		ScenarioContext.setScenarioContext(GTIN, Page("LoginPage").GetElementText("labelGTIN"));
		String GTIN1 = ScenarioContext.getScenarioContext(GTIN).toString();
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^verify the barcode generated with \"([^\"]*)\"$")
	public void verify_the_barcode_generated_with(String GTIN) {

		// GTIN will be part of pdf file name to be downloaded and the barcode will be
		// same as GTIN
		
		try {
			CommonUtils.pause(4);
			//Page("LoginPage").clickDynamicElement("btnGeneric", "Finalise");
			Page("LoginPage").clickDynamicElement("btnGeneric", "Get a barcode image/symbol");

			
			// file will be downloaded in downloads with name containing GTIN
			Page("LoginPage").clickElement("downloadBarcodePDF");

			CommonUtils.pause(10);
			
			String gtinPdf = CommonUtils.getInstance().commonPdfReader(ScenarioContext.getScenarioContext(GTIN).toString());
			ReportsUtils.AttachFiletoReport(ScenarioContext.getScenarioContext(GTIN).toString());
			ReportsUtils.AddToReport(GTIN, gtinPdf);
            AssertUtils.getInstance().verifyTextContainsCaseInsensitive(gtinPdf, ScenarioContext.getScenarioContext(GTIN).toString(),
					"The Barcode generated does not Match:-" + " Expected" + GTIN + "| Actual:-" + gtinPdf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

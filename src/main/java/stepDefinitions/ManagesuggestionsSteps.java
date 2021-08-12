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

import com.ContextInjection.ScenarioContext;
import com.core.Apputils;
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


public class ManagesuggestionsSteps extends SeleniumFunctions{

ScenarioContext ScenarioContext ;
public ManagesuggestionsSteps(ScenarioContext scenarioContext){
this.ScenarioContext= scenarioContext;
}

@When("^user click on my account drop down$")
public void user_click_on_my_account_drop_down()
{

try {
Page("ManageSuggestions").clickElement("Myaccount");
}
catch (Exception e) {
e.printStackTrace();
}
}

@When("^user clicks on manage suggestions$")
public void user_clicks_on_manage_suggestions()
{

try {
Page("ManageSuggestions").clickElement("ManageSuggestion");
}
catch (Exception e) {
e.printStackTrace();
}
}

@Then("^verify the \"([^\"]*)\" page$")
public void verify_the_page(String pagename){

try {
String Activatepagename = Page("ManageSuggestions").getElement("Activatepage").getText();
AssertUtils.getInstance().assertEquals(pagename, Activatepagename, "Activate page name not matched with launched page");
}
catch(Exception e) {
e.printStackTrace();
}

}
//Add Sub-brand Names
@Then("^add sub brand \"([^\"]*)\" in field$")
public void add_sub_brand_in_field(String brandname){
String test1 = (Apputils.getInstance().randomnumber());
String test2 = (Apputils.getInstance().randomnumber());
String test3 = (Apputils.getInstance().randomnumber());
String test4 = (Apputils.getInstance().randomnumber());
String test5 = (Apputils.getInstance().randomnumber());
String test6 = (Apputils.getInstance().randomnumber());
try {
ScenarioContext.setScenarioContext("value1", test1);
ScenarioContext.setScenarioContext("value2", test2);
ScenarioContext.setScenarioContext("value3", test3);
ScenarioContext.setScenarioContext("value4", test4);
ScenarioContext.setScenarioContext("value5", test5);
ScenarioContext.setScenarioContext("value6", test6);

Page("ManageSuggestions").clickElement("SubBrand");
Page("ManageSuggestions").sendKeysToElement("SubBrand" , test1);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("SubBrand" , test2);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("SubBrand" , test3);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("SubBrand" , test4);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("SubBrand" , test5);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("SubBrand" , test6);
Page("ManageSuggestions").EnterPress();
}
catch(Exception e) {
e.printStackTrace();
}

}
@When("^click on save button$")
public void click_on_save_button()
{
try {
Page("ManageSuggestions").clickElement("Savebutton");
}
catch(Exception e) {
e.printStackTrace();
}

}
@When("^verify the \"([^\"]*)\" message for adding sub brand$")
public void verify_the_Thank_you_message_for_adding_subbrand(String SubmitMessage)
{
try {
String Message = Page("ManageSuggestions").getElement("Message").getText();
AssertUtils.getInstance().assertEquals(SubmitMessage, Message, "Sub Product name not saved");
}
catch(Exception e) {
e.printStackTrace();
}
}

@When("^click on \"([^\"]*)\" button$")
public void click_on_Start_Using_Activate(String StartUsingActivate)
{
try {
Page("ManageSuggestions").clickElement("ActivateButton");
}
catch(Exception e) {
e.printStackTrace();
}

}

@When("^Verify the Values add in \"([^\"]*)\" from manage suggestions$")
public void Verify_the_Values_add_in_from_manage_suggestions(String subbrand)
{
try {
	CommonUtils.pause(3);
	Page("ManageSuggestions").clickElement("clickonmore");
	
	String BrandName1 = (String) ScenarioContext.getScenarioContext("value1");
	Page("ManageSuggestions").GetDynamicElementText("findbrand", BrandName1);
	String BrandName2 = (String) ScenarioContext.getScenarioContext("value2");
	Page("ManageSuggestions").GetDynamicElementText("findbrand", BrandName2);
	String BrandName3 = (String) ScenarioContext.getScenarioContext("value3");
	Page("ManageSuggestions").GetDynamicElementText("findbrand", BrandName3);
	String BrandName4 = (String) ScenarioContext.getScenarioContext("value4");
	Page("ManageSuggestions").GetDynamicElementText("findbrand", BrandName4);
	String BrandName5 = (String) ScenarioContext.getScenarioContext("value5");
	Page("ManageSuggestions").GetDynamicElementText("findbrand", BrandName5);
	String BrandName6 = (String) ScenarioContext.getScenarioContext("value6");
	Page("ManageSuggestions").GetDynamicElementText("findbrand", BrandName6);

}
catch(Exception e) {
e.printStackTrace();
}

}

@When("^Verify the subbrand add in \"([^\"]*)\" from manage suggestions$")
public void Verify_the_subbrand_add_in_from_manage_suggestions(String subbrand)
{
try {
	
	Page("ManageSuggestions").clickElement("clickonmoresubproducts");
	
	String BrandSubName1 = (String) ScenarioContext.getScenarioContext("value1");
	Page("ManageSuggestions").GetDynamicElementText("findsubbrand", BrandSubName1);
	String BrandSubName2 = (String) ScenarioContext.getScenarioContext("value2");
	Page("ManageSuggestions").GetDynamicElementText("findsubbrand", BrandSubName2);
	String BrandSubName3 = (String) ScenarioContext.getScenarioContext("value3");
	Page("ManageSuggestions").GetDynamicElementText("findsubbrand", BrandSubName3);
	String BrandSubName4 = (String) ScenarioContext.getScenarioContext("value4");
	Page("ManageSuggestions").GetDynamicElementText("findsubbrand", BrandSubName4);
	String BrandSubName5 = (String) ScenarioContext.getScenarioContext("value5");
	Page("ManageSuggestions").GetDynamicElementText("findsubbrand", BrandSubName5);
	String BrandSubName6 = (String) ScenarioContext.getScenarioContext("value6");
	Page("ManageSuggestions").GetDynamicElementText("findsubbrand", BrandSubName6);

}
catch(Exception e) {
e.printStackTrace();
}

}

//Add Sub-brand Names
@Then("^add brand \"([^\"]*)\" in field$")
public void add_brand_in_field(String brandname){
String test1 = (Apputils.getInstance().brandrandomnumber());
String test2 = (Apputils.getInstance().brandrandomnumber());
String test3 = (Apputils.getInstance().brandrandomnumber());
String test4 = (Apputils.getInstance().brandrandomnumber());
String test5 = (Apputils.getInstance().brandrandomnumber());
String test6 = (Apputils.getInstance().brandrandomnumber());
try {
ScenarioContext.setScenarioContext("value1", test1);

ScenarioContext.setScenarioContext("value2", test2);
ScenarioContext.setScenarioContext("value3", test3);
ScenarioContext.setScenarioContext("value4", test4);
ScenarioContext.setScenarioContext("value5", test5);
ScenarioContext.setScenarioContext("value6", test6);

CommonUtils.pause(15);

Page("ManageSuggestions").clickElement("Brandname");
Page("ManageSuggestions").sendKeysToElement("Brandname" , test1);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("Brandname" , test2);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("Brandname" , test3);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("Brandname" , test4);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("Brandname" , test5);
Page("ManageSuggestions").EnterPress();
Page("ManageSuggestions").sendKeysToElement("Brandname" , test6);
Page("ManageSuggestions").EnterPress();
}
catch(Exception e) {
e.printStackTrace();
}

}

}
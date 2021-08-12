package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
 import org.openqa.selenium.JavascriptExecutor;
 import org.openqa.selenium.Point;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.interactions.Actions;

import com.ContextInjection.ScenarioContext;
import com.core.BaseVariables;
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


 public class LoginStepDefinition extends SeleniumFunctions{
	
	 ScenarioContext ScenarioContext ;
	 public LoginStepDefinition(ScenarioContext scenarioContext){
		 this.ScenarioContext= scenarioContext;
	 }
	
	

 
@Description("Verify home page title")
@Story("Test verify base page title")
@Given("^user is already on Login Page$")
 public void user_already_on_login_page(){ 
	
	
	 try {
		 
		// WebDriverUtils.getInstance().LaunchBrowser();
		 
		NavigateToURL(TestProperties.getInstance().getBaseUrl());
		
	} catch (Exception e) {
		
	}
	
	 ScenarioContext.setScenarioContext("GivenTestKey", "GivenTestvalue");
	 System.out.println("Senario");
 }


 @Then("^user enters \"(.*)\" and \"(.*)\"$")
 public void user_enters_username_and_password(String username, String
 password){
	 
	 System.out.println(ScenarioContext.getScenarioContext("GivenTestKey"));
	 try {
		 LoadApplication();
		
		 
		Page("LoginPage").ClearTextWithsendKeys("username", username, true, "");
		Page("LoginPage").ClearTextWithsendKeys("password", password, true, "");	
	} 
	 catch (Exception e) {
		e.printStackTrace();
	}
 }
 
 @Then("^user login to application using role \"(.*)\"$")
 public void user_login_to_application_using_role(String RoleName) throws Throwable {
	 System.out.println(ScenarioContext.getScenarioContext("GivenTestKey"));
	 try {
		 LoadApplication();
		 //CommonUtils.pause(3);
		 if(Page("LoginPage").checkElementVisibility("logout"))
			{
				Page("LoginPage").clickElement("logout");
				CommonUtils.pause(10);
			}
		 String credentials = TestProperties.getInstance().getUserCredentials(RoleName);
		 String username = TestProperties.getInstance().getUserCredentials(RoleName).split(",")[0];
		 String password = TestProperties.getInstance().getUserCredentials(RoleName).split(",")[1];
		 System.out.println(credentials);
		 System.out.println(username);
		 System.out.println(password);
		 //CommonUtils.pause(3);
		Page("LoginPage").ClearTextWithsendKeys("username", username, true, "");
		Page("LoginPage").ClearTextWithsendKeys("password", password, true, "");	
	} 
	 catch (Exception e) {
		e.printStackTrace();
	}
 }
 
// @Then("^user login to application using role \"(.*)\"$")
// public void user_login_to_application_using_role(String RoleName){
//	 
//	 
// }

 @Then("^user clicks on login button$")
 public void user_clicks_on_login_button() 
 {
	 try {
	Page("LoginPage").clickElement("submit");
	 }
	 catch(Exception ex) {
	 }
 }
 
 @Then("^user is on home page$")
 public void user_is_on_home_page() 
 {
	 try {
		 Assert.assertEquals("Admin header is not visible", (Page("HomePage").getElement("Header").getText()), "Admin");
	 }
	 catch(Exception ex) {
	 }
 }
 
 @Then("^all tabs are displayed on home page$")
 public void all_tabs_are_displayed_on_homepage() 
 {
	 try {
		 Assert.assertEquals("General Settings link is not visible", (Page("HomePage").getElement("Link_GeneralSettings").getText()), "General Settings");
		 Assert.assertEquals("Companies link is not visible", (Page("HomePage").getElement("Link_Companies").getText()), "Companies");
		 Assert.assertEquals("Users link is not visible", (Page("HomePage").getElement("Link_Users").getText()), "Users");
		 Assert.assertEquals("Licenses link is not visible", (Page("HomePage").getElement("Link_Licences").getText()), "Licences");
		 Assert.assertEquals("Products link is not visible", (Page("HomePage").getElement("Link_Products").getText()), "Products");
		 Assert.assertEquals("Content link is not visible", (Page("HomePage").getElement("Link_Content").getText()), "Content");
		 Assert.assertEquals("GRP Sync link is not visible", (Page("HomePage").getElement("Link_GRPSync").getText()), "GRP sync");
		 Assert.assertEquals("Help link is not visible", (Page("HomePage").getElement("Link_Help").getText()), "Help");
	 }
	 catch(Exception ex) {
	 }
 }
 
 }


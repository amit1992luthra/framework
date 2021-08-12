package com.core;

import org.junit.BeforeClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.AfterClass;

import com.ContextInjection.FeatureContext;
import com.ContextInjection.ScenarioContext;
import com.core.BaseVariables;

import MyRunner.TestRunner;
import cucumber.api.java.After;
//import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.runtime.ScenarioImpl;
import gherkin.formatter.model.Result;

import cucumber.api.Scenario;

public class Hooks{
	
	public ScenarioContext scenarioContext ;
	private static final Logger LOGGER = Logger.getLogger(CommonUtils.class.getName());
	public Hooks(ScenarioContext scenarioContext){
		this.scenarioContext= scenarioContext;
	}
	
	public Hooks(){
		
	}
	
	
	@BeforeClass
	public static void beforeTest() {

		try {
			System.out.println("before test ");
			TestProperties.getInstance().initProperties();
			//WebDriverUtils.getInstance().initWebDriver();
			FeatureContext.getInstance().setFeatureContext("Initial", "Test");

		} catch (Exception e) {

		}

	}
	/*@AfterStep
	public static void AfterStep(StepResult result){
		
		//result.getStatusDetails()
	}*/
	
	@Before
	public  void beforeScenario(){
		
		try {
			WebDriverUtils.getInstance().initWebDriver();
		} catch (Exception e) {
//			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	
	public void afterScenario(Scenario scenario){
		
		if (scenario.isFailed()) {
		ReportsUtils.TakeScreenshot();
//		BaseVariables.getInstance().getWebdriver().close();
		}
		if (BaseVariables.getInstance().getWebdriver() != null) {
			BaseVariables.getInstance().getWebdriver().quit();
			BaseVariables.getInstance().setWebdriver(null);
		}
	}
	
	/*private static void logError(Scenario scenario) {
		   Field field = FieldUtils.getField(((ScenarioImpl) scenario).getClass(), "stepResults", true);
		   field.setAccessible(true);
		   try {
		       ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);
		       for (Result result : results) {
		           if (result.getError() != null)
		        	   LOGGER.info("Error in Scenario ID:-" + scenario.getId()+ "Exception:" +  result.getError());
		            throw new Exception("Error in Scenario ID:-" +result.getError());
		             
		       }
		   } catch (Exception e) {
		       LOGGER.info("Error while logging error"+e);
		   }
		}*/
	
	
	@AfterClass
	public static void afterTest(){ 
		 System.out.println("After Test");
		//BaseVariables.getInstance().getWebdriver().quit();
		ReportsUtils.generateAllureReport();
		
	}
	

}


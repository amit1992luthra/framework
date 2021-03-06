package com.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.seleniumFuctions.SeleniumFunctions;

import static com.core.Constanst.BROWSER_CHROME;
import static com.core.Constanst.BROWSER_FIREFOX;
import static com.core.Constanst.BROWSER_IE;
import static com.core.Constanst.BROWSER_OPERA;
import static com.core.Constanst.BROWSER_SAFARI;
import java.util.HashMap;
import java.util.Map;


public class WebDriverUtils {

	SeleniumFunctions seleniumFunctins;
	WebDriver driver;
	
	private static WebDriverUtils instance = null ;
	
	 public static WebDriverUtils getInstance() {
	        if (instance == null) {
	            instance = new WebDriverUtils();
	        }
	        return instance;
	    }
	 public void setUpDriver() throws Exception {
	        
	        try {
	        	switch (TestProperties.getInstance().getBrowserName().toLowerCase()) {
		                case BROWSER_CHROME:
		                    BaseVariables.getInstance().setWebdriver(new ChromeCapabilities().setChromeCapabilities());	                        
		                    break;	                        
		                    
		                case BROWSER_FIREFOX:
		                    BaseVariables.getInstance().setWebdriver(new FirefoxCapabilities().setFirefoxCapabilities());	                        
		                    break;
		                    default:
		                    throw new IllegalArgumentException("The Browser Name is Undefined");
	                        }
	        	
	        } catch (Exception e) {
	           //catch Exception
	        }
	    }

	 public void initWebDriver() throws Exception {
	        if (BaseVariables.getInstance().getWebdriver() == null) {
	           setUpDriver();
	        }
	        this.driver = BaseVariables.getInstance().getWebdriver();
	       
	       //pass to any constructors 
	        
	    }
	 public void LaunchBrowser() throws Exception {
	 if (BaseVariables.getInstance().getWebdriver() == null) 
	 {
		 setUpDriver(); 
         
      }
	 else
	 {
		 BaseVariables.getInstance().getWebdriver().quit();
		 BaseVariables.getInstance().setWebdriver(null);
		 setUpDriver();
	 }
	 } 

	 
	 public class ChromeCapabilities {
	 ChromeOptions options;
	 ChromeDriver Chromedriver;
	public WebDriver setChromeCapabilities() throws Exception {
    	
    	try {
        	options = new ChromeOptions();
        	System.setProperty("webdriver.chrome.driver", PathConstants.getInstance().getChromeDriverFile());
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("disable-infobars");
            setChromeOptions();
            Chromedriver = new ChromeDriver(options);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return Chromedriver;
    }
	
	
	 private void setChromeOptions() {
	        try {
	            Map<String, Object> prefs = new HashMap<String, Object>();
	            prefs.put("credentials_enable_service", false);
	            prefs.put("profile.password_manager_enabled", false);
	            options.setExperimentalOption("prefs", prefs);
	            options.setCapability(ChromeOptions.CAPABILITY, options);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
	 
	 public class FirefoxCapabilities {
	 FirefoxOptions options;
	 FirefoxDriver Firefoxdriver;
	public WebDriver setFirefoxCapabilities() throws Exception {
    	
    	try {
        	options = new FirefoxOptions();
        	System.setProperty("webdriver.gecko.driver", PathConstants.getInstance().getFirefoxDriverFile());
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);            
            options.addArguments("disable-infobars");
            setFirefoxOptions();
            Firefoxdriver = new FirefoxDriver(options);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return Firefoxdriver;
    }
	
	
	 private void setFirefoxOptions() {
	        try {
	            Map<String, Object> prefs = new HashMap<String, Object>();
	            prefs.put("credentials_enable_service", false);
	            prefs.put("profile.password_manager_enabled", false);
	            //options.setExperimentalOption("prefs", prefs);
	            options.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
	 

}

package com.core;

import java.util.Random;
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
import io.qameta.allure.Description;
import io.qameta.allure.Story;


import org.junit.Assert;

public class Apputils extends SeleniumFunctions {

private static Apputils instance = null;

public static Apputils getInstance() {
if (instance == null) {
instance = new Apputils();
}
return instance;
}

// Generating Random String

public String randomstring() {
int leftLimit = 97; // letter 'a'
int rightLimit = 122; // letter 'z'
int targetStringLength = 10;
Random random = new Random();
StringBuilder buffer = new StringBuilder(targetStringLength);
for (int i = 0; i < targetStringLength; i++) {
int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
buffer.append((char) randomLimitedInt);
}
String generatedString = buffer.toString();

return generatedString;
}

public String randomnumber() {
Random random = new Random();
int randomLimitedInt = (random.nextInt(99999) + 99999);
int generatednumber = Math.abs(randomLimitedInt);
String newnumber = "SB"+ generatednumber;


return newnumber;
}

public String brandrandomnumber() {
Random random = new Random();
int randomLimitedInt1 = (random.nextInt(99999) + 99999);
int generatednumber1 = Math.abs(randomLimitedInt1);
String newnumber1 = "BN"+ generatednumber1;


return newnumber1;
}


public boolean Adduser(String firstname, String Lastname, String Email) {

if (firstname.isEmpty() && Lastname.isEmpty() && Email.isEmpty()) {
firstname = randomstring();
Lastname = randomstring();
Email = randomstring()+"@test.com";

}
try {
Page("AddUser").ClearTextWithsendKeys("firstName", firstname, true, "");
Page("AddUser").ClearTextWithsendKeys("lastName", Lastname, true, "");
Page("AddUser").ClearTextWithsendKeys("emailAddress", Email, true, "");
Page("AddUser").ClearTextWithsendKeys("companyName", "abc limited", true, "");
Page("AddUser").clickElement("companyNamedropdown");
Page("AddUser").clickElement("saveButton");

return true;

}

catch (Exception ex) {
System.out.println(ex.getMessage());
return false;
}

}

}
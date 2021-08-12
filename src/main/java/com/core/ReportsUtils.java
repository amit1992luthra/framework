package com.core;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;


public class ReportsUtils {

	
public static void AddToReport(String message ,String content){
	Allure.addAttachment(message, content);
	
}

public static void TakeScreenshot(){
	try {
		File screenshotAs = ((TakesScreenshot) BaseVariables.getInstance().getWebdriver()).getScreenshotAs(OutputType.FILE);
		  Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
	} catch (Exception e) {
		
	}
		
	
}

public  static void generateAllureReport(){
	try {
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "Generate.bat");
		File dir = new File("C:/GS1/Version2/AutomationFramework/allure-results");
		pb.directory(dir);
		Thread.sleep(5000);
		Process p = pb.start();
		Thread.sleep(5000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	}
	

@Attachment
public static void AttachFiletoReport(String fileName){
	try {
		
		String modifiledFilePath="";
		if (fileName.startsWith("0")) {
			modifiledFilePath= fileName;
		}
		else{
			modifiledFilePath="0"+fileName;
		}
		File fileObject = new File(PathConstants.getInstance().getDownloadFilePath(modifiledFilePath)); 
		
		Thread.sleep(4000);		
		  Allure.addAttachment("FileName", FileUtils.openInputStream(fileObject));
		  Thread.sleep(4000);
	} catch (Exception e) {
		
	}
} 

public static void AttachImagetoReport(String fileName){
	try {
		
		
		File fileObject = new File(PathConstants.getInstance().UploadFilePath(fileName)); 
		
		Thread.sleep(1000);		
		  Allure.addAttachment("FileName", FileUtils.openInputStream(fileObject));
		  Thread.sleep(2000);
	} catch (Exception e) {
		
	}
} 
}

package com.core;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


import org.apache.pdfbox.rendering.*;



public class CommonUtils {

	private static CommonUtils instance = null ;
	public static CommonUtils getInstance(){
		if(instance==null){
			instance = new CommonUtils();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	synchronized public static String commonPdfReader(String fileName){
		String modifiledFilePath="";
		if (fileName.startsWith("0")) {
			modifiledFilePath= fileName;
		}
		else{
			modifiledFilePath="0"+fileName;
		}
		
		String pdfString = "";
		//String pdfString = fileName;
		try {
			File file = new File(PathConstants.getInstance().getDownloadFilePath(modifiledFilePath));
		if (file.exists()) {
			pause(3);
			FileInputStream fileObject = new FileInputStream(PathConstants.getInstance().getDownloadFilePath(modifiledFilePath)); 
			PDDocument document = PDDocument.load(fileObject);
			PDFRenderer pdfRenderer = new PDFRenderer(document);
			 BufferedImage bim = pdfRenderer.renderImage(0);
			 pause(3);
			 ImageIO.write(bim, "JPEG", new File(PathConstants.getInstance().ImageFilePath(modifiledFilePath)));
			 document.close();
			 FileInputStream fileObject2 = new FileInputStream((PathConstants.getInstance().ImageFilePath(modifiledFilePath))); 
		     BufferedImage bufferedImage = ImageIO.read(fileObject2);
		     LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		     pause(3);
		     BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		     Result result = new MultiFormatReader().decode(bitmap);
		     pdfString =  result.getText();
		     if (pdfRenderer.equals("null")||pdfRenderer==null) {
		    	 commonPdfReader(fileName);
			}
		}
			
		    
		} catch (Exception e) {
			AssertUtils.getInstance().Fail("File is NOT Downloaded :-"+fileName+" "+e.getMessage());
			System.out.println(e.getMessage());
		}
		
		return pdfString ;
		
	}

public  String decodeQRCode(String qrCodeImage) {
	try {
		FileInputStream fileObject = new FileInputStream(PathConstants.getInstance().pdfFilePath(qrCodeImage)); 
	    BufferedImage bufferedImage = ImageIO.read(fileObject);
	    LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
	    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
	    Result result = new MultiFormatReader().decode(bitmap);
	    return result.getText();
		
	} catch (Exception e) {
		return null;
	}
	
}

public static void pause(final int timeInSeconds) {
    try {
        Thread.sleep(timeInSeconds * 1000);
    } catch (InterruptedException ex) {
    	System.out.println(ex.getMessage());
    }
}



}

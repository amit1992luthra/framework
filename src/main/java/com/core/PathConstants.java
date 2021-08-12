package com.core;

import java.net.URL;



public class PathConstants {

	private static PathConstants instance = null;

	public static PathConstants getInstance() {
		if (instance == null) {
			instance = new PathConstants();

		}
		return instance;
	}

	public String getChromeDriverFile() {
		String chromeDriverFile = null;
		chromeDriverFile = getBaseResourcesFolder("drivers\\Chromedriver.exe");
		return chromeDriverFile;
	}
	
	public String getFirefoxDriverFile() {
		String FirefoxDriverFile = null;
		FirefoxDriverFile = getBaseResourcesFolder("drivers\\geckodriver.exe");
		return FirefoxDriverFile;
	}

	public String getBaseResourcesFolder(String name) {
		String baseResourcesFolder = null;
		if (name.length() == 0) {
		    baseResourcesFolder = System.getProperty("user.dir") + "\\config\\";
		    } else {
			baseResourcesFolder = System.getProperty("user.dir") + "\\config\\" + name;

		}
		return baseResourcesFolder;
	}

	public String getXmlFolderpath(String name) {
		String xmlFolderlocation = null;
		xmlFolderlocation = getBaseResourcesFolder("XMLs\\"+name);
        return xmlFolderlocation;
		
	}
	
	public String pdfFilePath(String qrCodeImage){
		String pdfFileFolder = null ;
		pdfFileFolder = getBaseResourcesFolder("PDFs\\"+qrCodeImage+".pdf");
		return pdfFileFolder;
	}
	
	public String ImageFilePath(String filepath){
		String pdfFileFolder = null ;
		pdfFileFolder = getBaseResourcesFolder("PDFs\\"+filepath+".png");
		return pdfFileFolder;
	}
	
	public String UploadFilePath(String filepath){
		String pdfFileFolder = null ;
		pdfFileFolder = getBaseResourcesFolder("Images\\"+filepath+".png");
		return pdfFileFolder;
	}
	
	public String getDownloadFilePath(String fileName){
		String downloadPath = "";
		downloadPath = System.getProperty("user.home")+"\\Downloads\\"+fileName+".pdf";
		return downloadPath;
	}
	
	public String getWindowFileUploaderExePath() {
        String fileUploadExePath = null;
        fileUploadExePath = getBaseResourcesFolder("drivers\\WindowFileUploader.exe");
        return fileUploadExePath;
    }

}

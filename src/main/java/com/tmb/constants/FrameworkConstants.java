package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public final class FrameworkConstants  {
	
	
	private FrameworkConstants() {
		
	}
	
	
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH+"/executables/chromedriver.exe";
	private static final String FIREFOXDRIVERPATH = RESOURCESPATH+"/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static final String CONFIGJSONPATH = RESOURCESPATH+"/config/config.json";
	private static final String EXCELPATH = RESOURCESPATH+"/excel/testData1.xlsx";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extentReports-output/";
	private static String extentReportFilePath ="";
	
	private static final String RUNMAMANGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";
	
	
	
	
	
	
	private static final int EXPLICITWAIT = 10;
	
	public static String getConfigFilepath() {
		return CONFIGFILEPATH;
	}

	public static String getChromeDriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigjsonpath() {
		return CONFIGJSONPATH;
	}

	public static String createExtentreportpath() {
		if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+"/"+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
		
	}

	public static String getExtentReportFilePath() {
		
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createExtentreportpath();
		}
		
		return extentReportFilePath;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getRunmamangersheet() {
		return RUNMAMANGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	public static String getFirefoxdriverpath() {
		return FIREFOXDRIVERPATH;
	}
	

}

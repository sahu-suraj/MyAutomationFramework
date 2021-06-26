package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() {

	}

	public static ExtentReports extent;
	//public static ExtentTest test;

	public static void initReports() {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("TMB Report");
			spark.config().setReportName("Suraj sahu");
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
			ExtentManager.unload();
			try {
				Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public static void createTest(String testcasename) {
		ExtentTest test =extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
	
	public static void addAuthors(String[] authors) {
		for(String temp: authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}
	
	public static void addCategories(CategoryType[] cat) {
		for(CategoryType temp: cat) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
	
}

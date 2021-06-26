package com.tmb.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.driver.Driver;
import com.tmb.reports.ExtentReport;

public class BaseTest {

	protected BaseTest() {
		
	}
	

//	private,public, default -> public
	
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data){
		Map<String,String> map = (Map<String, String>) data[0];
		Driver.initDriver(map.get("browser"));
	}
	
	@AfterMethod
	protected void tearDown(ITestResult result) {
		
		Driver.quitDriver();
	}

	
	
}

package com.tmb.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {
		
	}
	
	
private static ThreadLocal<ExtentTest> er = new ThreadLocal<>();
	
	//default  access modilfer = it ccan be accessed only within package
	static ExtentTest getExtentTest() {
		return er.get();
	}
	
	static void setExtentTest(ExtentTest test) {
		er.set(test);
	}
	
	static void unload() {
		er.remove();
		
		
	}
}

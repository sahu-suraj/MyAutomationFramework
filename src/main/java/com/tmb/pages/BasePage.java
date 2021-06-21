package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;

public class BasePage {
	
	
	
	protected void click(By by , WaitStrategy waitstategy, String elementname) {
		
		ExplicitWaitFactory.performExplicitWait(waitstategy, by).click();
		try {
			ExtentLogger.pass(elementname + " clicked.",true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//DriverManager.getDriver().findElement(by).click(); 
	}

	
	protected void enterKeys(By by, String value,WaitStrategy waitstategy, String elementname) {
		
		ExplicitWaitFactory.performExplicitWait(waitstategy, by).sendKeys(value);
		try {
			ExtentLogger.pass(value + " is entered succesfully in "+ elementname,true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	
}

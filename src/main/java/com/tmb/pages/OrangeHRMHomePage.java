package com.tmb.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentManager;
import com.tmb.reports.ExtentReport;

public class OrangeHRMHomePage extends BasePage {
	
	
	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");
	
	
	public OrangeHRMHomePage clickWelcome() {
		
//		DriverManager.getDriver().findElement(linkWelcome).click();
		click(linkWelcome,WaitStrategy.PRESENCE,"Welcome link");
		//ExtentManager.getExtentTest().pass("Welcome Clicked");
		
		
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		//Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		
		new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(linkLogout));
		
		//wait.until(d->d.findElement(link_logout).isEnabled());
		//DriverManager.getDriver().findElement(linkLogout).click();
		
		click(linkLogout,WaitStrategy.CLICKABLE, "Logout Link");
		return new OrangeHRMLoginPage();
	}

	
	public String gettitle() {
		return getPageTitle();
	}
}

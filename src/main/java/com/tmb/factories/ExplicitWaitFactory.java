package com.tmb.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {
		
	}
	
	public static WebElement performExplicitWait(WaitStrategy waitstategy, By by) {
		
		WebElement element = null;
		
		if(waitstategy == WaitStrategy.CLICKABLE)
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait()).until(ExpectedConditions.elementToBeClickable(by));
		else if(waitstategy == WaitStrategy.PRESENCE)
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait()).until(ExpectedConditions.presenceOfElementLocated(by));
		else if(waitstategy == WaitStrategy.VISIBLE)
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait()).until(ExpectedConditions.visibilityOfElementLocated(by));
		else if(waitstategy == WaitStrategy.NONE)
			element = DriverManager.getDriver().findElement(by);
		
		return element;
	}

}

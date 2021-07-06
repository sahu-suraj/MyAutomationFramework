package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager() {
		
	}
	
public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	static void setDriver(WebDriver driver) {
		if(Objects.nonNull(driver))
			dr.set(driver);
	}
	
	static void unload() {
		dr.remove();
		
		
	}

}

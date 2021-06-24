package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage{

	
	/*
	 * id
	 * name
	 * classname
	 * linktext
	 * partial link txt
	 * css or xpath
	 */
	
	//Page classes should be free from assertion
	// AllPage menthods needs to have some return type
	
	private final By textboxUsername = By.id("txtUsername");
	private final By textboxPassword = By.id("txtPassword");
	private final By buttonLogin = By.id("btnLogin");
	
	
	public OrangeHRMLoginPage enterUserName(String username) {
		//DriverManager.getDriver().findElement(textboxUsername).sendKeys(username);
		enterKeys(textboxUsername, username,WaitStrategy.CLICKABLE,"UserName");
		//return new OrangeHRMLoginPage();
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		enterKeys(textboxPassword, password, WaitStrategy.CLICKABLE,"Password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() {
		//DriverManager.getDriver().findElement(buttonLogin).click();
		click(buttonLogin,WaitStrategy.CLICKABLE,"Login button");
		return new OrangeHRMHomePage();
	}
	
	public String gettitle() {
		return getPageTitle();
	}
}

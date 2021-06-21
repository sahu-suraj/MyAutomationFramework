package com.tmb.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class LoginPageTests extends BaseTest {

	
	private  LoginPageTests() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Test
	public void test1() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);

	}

	@Test
	public void test2() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing", Keys.ENTER);

	}
	
	
}

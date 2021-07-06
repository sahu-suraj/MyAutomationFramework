package com.tmb.testcases;

import java.util.Map;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.driver.DriverManager;
import com.tmb.enums.CategoryType;

public final class DockerDemoTest extends BaseTest{

	private DockerDemoTest() {
		
	}
	
	@FrameworkAnnotation(author = { "Suraj","Suraj2" }, category = { CategoryType.REGRESSION,CategoryType.SMOKE })
	@Test
	public void simpleTest(@NoInjection Map<String,String> data) {
		DriverManager.getDriver().navigate().to("http://www.bing.com");
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("abc",Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.toLowerCase().contains("abc"));
		
	}
	
	@FrameworkAnnotation(author = { "Suraj","Suraj2" }, category = { CategoryType.REGRESSION,CategoryType.SMOKE })
	@Test
	public void simpleTest1(@NoInjection Map<String,String> data) {
		DriverManager.getDriver().navigate().to("http://www.google.com");
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("abc",Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.toLowerCase().contains("abc"));
		
	}
}

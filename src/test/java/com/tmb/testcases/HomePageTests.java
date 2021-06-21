package com.tmb.testcases;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public class HomePageTests extends BaseTest{


	private HomePageTests() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void test3() {


		DriverManager.getDriver().findElement(By.name("q")).sendKeys("abc",Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.toLowerCase().contains(title));
		Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search")); //[a-zA-Z0-9]
		Assert.assertTrue(title.length()>15);
		Assert.assertTrue(title.length()<100);
		
		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3/span"));
		System.out.println(elements.size());
		Assert.assertEquals(elements.size(), 10);
		
		boolean isElementPresent = false;
		for(WebElement element: elements) {
			if(element.getText().equalsIgnoreCase("abc")) {
				isElementPresent = true;
				break;
			}
		}
		
		Assert.assertTrue(isElementPresent,"abc not found");
		

	}
}

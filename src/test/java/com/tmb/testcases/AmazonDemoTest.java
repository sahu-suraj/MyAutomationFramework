package com.tmb.testcases;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.AmazonHomePage;
import com.tmb.pages.AmazonLaptopPage;

public final class AmazonDemoTest extends BaseTest{
	
	private AmazonDemoTest() {
		
	}
	
	@FrameworkAnnotation(author = { "Suraj","Suraj2" }, category = { CategoryType.REGRESSION,CategoryType.SMOKE })
	@Test
	public void amazonTest(@NoInjection Map<String,String> data) {
		new AmazonHomePage().clickHamburger().clickAmazonHamburgerMenuPage().clickSubMenu(data.get("menutext"));
		String title = new AmazonLaptopPage().getTitle();
		Assertions.assertThat(title).isNotNull().isNotBlank();
		
		//new AmazonHomePage().clickHamburger();
		
		
	}

}

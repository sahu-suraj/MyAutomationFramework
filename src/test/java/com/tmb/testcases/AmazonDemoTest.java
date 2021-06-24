package com.tmb.testcases;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.pages.AmazonHomePage;
import com.tmb.pages.AmazonLaptopPage;

public final class AmazonDemoTest extends BaseTest{
	
	private AmazonDemoTest() {
		
	}
	
	@Test
	public void amazonTest(Map<String,String> data) {
		new AmazonHomePage().clickHamburger().clickAmazonHamburgerMenuPage().clickSubMenu(data.get("menutext"));
		String title = new AmazonLaptopPage().getTitle();
		Assertions.assertThat(title).isNotNull().isNotBlank();
	}

}

package com.tmb.testcases;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.listeners.RetryFailedTest;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentReport;
import com.tmb.utils.DataProviderUtils;
import com.tmb.utils.ScreenShotUtils;

public class OrangeHRMTests extends BaseTest {
	
	private OrangeHRMTests() {
		
	}

	//@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTest.class)
	@FrameworkAnnotation(author = { "Suraj" }, category = { CategoryType.REGRESSION,CategoryType.SMOKE })
	@Test
	public void loginLogoutTest(@NoInjection Map<String, String> data){
		
		
		
//		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
//		ohlp.enterUserName("Admin");
//		ohlp.enterPassword("admin123");
//		ohlp.clickLogin();
//		
//		 OrangeHRMHomePage ohhp =  ohlp.enterUserName("Admin").enterPassword("admin123").clickLogin();
//		ohhp.clickWelcome().clickLogout();
		
		String title = new OrangeHRMLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin().clickWelcome().clickLogout().gettitle();
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
		
		
	}
	
	//@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTest.class)
	@Test
	public void newTest(Map<String, String> data){
		
		
		String title = new OrangeHRMLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin().clickWelcome().clickLogout().gettitle();
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
		
		
	}
	
	//@DataProvider(name="LoginTestDataProvider",parallel=true)
	public Object[][] getData(){
		
		return new Object[][] {
			{"Admin","admin1213"}
//			{"Admin","admin123"},
//			{"Admin123","admin123"}
		};
	}
	
	
	
}
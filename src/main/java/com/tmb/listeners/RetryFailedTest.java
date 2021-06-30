package com.tmb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public class RetryFailedTest implements IRetryAnalyzer{


	int counter=0;
	int limit =1;
	
	
	@Override
	public boolean retry(ITestResult result) {
//		if(counter<limit) {
//			counter++;
//			return true;
//		}
		
		boolean value =false;
		
		
			if(PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
				value =counter<limit ;
				counter++;
				
			}
		
		
		return value;
	}


}

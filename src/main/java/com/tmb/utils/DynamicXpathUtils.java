package com.tmb.utils;

public final class DynamicXpathUtils {

	
	private DynamicXpathUtils() {
		
	}
	
	
	public static String getXpath(String xpath,String value) {
		//return xpath.replace("%replaceable%", value);
		return String.format(xpath, value);//a[text()='%s']
	}
}

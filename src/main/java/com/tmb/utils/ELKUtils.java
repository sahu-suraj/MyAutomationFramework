package com.tmb.utils;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.tmb.enums.ConfigProperties;

import io.restassured.response.Response;

public class ELKUtils {

	
	private ELKUtils() {
		
	}
	
	public static void sendDetailsToELK(String testname,String status) {
		
		if(PropertyUtils.getValue(ConfigProperties.SENDRESULTTOELK).equalsIgnoreCase("yes")) {
		Map<String,String> map = new HashMap<>();
		map.put("testName", testname);
		map.put("status", status);
		map.put("executionTime", LocalDateTime.now().toString());
		
		Response response = given().header("Content-Type","application/json")
				.log()
				.all()
				.body(map)
				.post(PropertyUtils.getValue(ConfigProperties.KIBANADASHBOARDURL));

		Assert.assertEquals(response.statusCode(), 201);

		response.prettyPrint();
		}
	}
}

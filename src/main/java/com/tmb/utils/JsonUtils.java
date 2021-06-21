package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;

public class JsonUtils {
	 
	private static Map<String, String> CONFIGMAP = new HashMap<>(); 
	
	static {
		FileInputStream file;
		try {
			file = new FileInputStream(FrameworkConstants.getConfigjsonpath());
			CONFIGMAP = new ObjectMapper().readValue(file,new TypeReference<Map<String, String>>() {
			});
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Hashtable -  little slow , thread safe
	// coverting a property file to hashmap
	
	public static String getValue(ConfigProperties key) throws Exception {

		if (Objects.isNull(key) || Objects.isNull(key.name().toLowerCase())) {
			throw new Exception("Property name" + key + "not found");
		} 
			//return prop.getProperty(key);
 			return CONFIGMAP.get(key.name().toLowerCase());

	}


}

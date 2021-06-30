package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.InvalidPathForPropertyFileException;
import com.tmb.exceptions.PropertiesFileUsageException;

public class PropertyUtils {

	private PropertyUtils() {

	}
	
	
	private static Properties prop = new Properties(); 
	private static final Map<String,String> CONFIGMAP = new HashMap<>();
	
	static {
		//FileInputStream file;
		try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilepath())){
			//file = new FileInputStream(FrameworkConstants.getConfigFilepath());
			prop.load(file);
			
//			for(Object key : prop.keySet()) {
//				CONFIGMAP.put(String.valueOf(key), String.valueOf(prop.get(key)));
//			}
//			
//			
			for(Map.Entry<Object, Object> entry: prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
//			
//			prop.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
//			
		} 
		catch (IOException e) {
			e.printStackTrace();
			//throw new InvalidPathForPropertyFileException("Please check property file path");
			System.exit(0);
		}
	}

	//Hashtable -  little slow , thread safe
	
	// coverting a property file to hashmap
	
	
	public static String getValue(ConfigProperties key) {

		if (Objects.isNull(key) || Objects.isNull(key.name().toLowerCase())) {
			throw new PropertiesFileUsageException("Property name" + key + "not found");
		} 
			//return prop.getProperty(key);
			System.out.println(CONFIGMAP.get(key.name().toLowerCase()));
			return CONFIGMAP.get(key.name().toLowerCase());

	}

}

package com.tmb.exceptions;

@SuppressWarnings("serial")
public class PropertiesFileUsageException extends FrameworkExceptions{

	
	public PropertiesFileUsageException(String message) {
		super(message);
	}
	public PropertiesFileUsageException(String message,Throwable cause) {
		super(message,cause);
	}
}

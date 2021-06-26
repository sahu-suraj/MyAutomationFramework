package com.tmb.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForExcelException extends FrameworkExceptions{

	
	public InvalidPathForExcelException(String message) {
		super(message);
	}
	public InvalidPathForExcelException(String message,Throwable cause) {
		super(message,cause);
	}
}

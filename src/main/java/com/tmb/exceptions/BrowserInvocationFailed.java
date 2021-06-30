package com.tmb.exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationFailed extends FrameworkExceptions {

	public BrowserInvocationFailed(String message) {
		super(message);
		
	}

	public BrowserInvocationFailed(String message,Throwable cause) {
		super(message,cause);
		
	}
}

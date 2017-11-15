package com.slinetech.exceptions;

@SuppressWarnings("serial")
public class StackException extends Exception{
	public StackException() {}
	
	public StackException(String message) {
		super(message);
	}
	
	public StackException(Throwable cause) {
		super(cause);
	}
}

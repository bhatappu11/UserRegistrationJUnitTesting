package com.bridgelabz.userregistrationjunit;

public class UserRegistrationException extends Exception{
	enum exceptionType{
		ENTERED_VALID,ENTERED_INVALID
	}
	exceptionType type;
	public UserRegistrationException(exceptionType type,String message) {
		super(message);
		this.type = type;
	}
}

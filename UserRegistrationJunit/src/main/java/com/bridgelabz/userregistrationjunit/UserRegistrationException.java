package com.bridgelabz.userregistrationjunit;

public class UserRegistrationException extends RuntimeException{
	enum ExceptionType{
		ENTERED_NULL,ENTERED_INVALID,ENTERED_EMPTY
	}
	ExceptionType type;
	public UserRegistrationException(ExceptionType type,String message) {
		super(message);
		this.type = type;
	}
}

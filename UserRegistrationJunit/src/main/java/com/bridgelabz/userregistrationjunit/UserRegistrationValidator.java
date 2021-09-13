package com.bridgelabz.userregistrationjunit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.userregistrationjunit.UserRegistrationException.ExceptionType;

public class UserRegistrationValidator {
	
	static boolean checkPassword(String password) {
		try {
			if(password.length()==0) throw new UserRegistrationException(ExceptionType.ENTERED_EMPTY, "Password cannot be empty");
			Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[0-9]).{8,}");
			Matcher matcher = pattern.matcher(password);
			if(!matcher.matches()) 
				return false;
			pattern = Pattern.compile("^[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$");
			matcher = pattern.matcher(password);
			if(matcher.matches()) {
				return true;
			} else {
				throw new UserRegistrationException(ExceptionType.ENTERED_INVALID, "Password is invalid");
			}
		}catch(NullPointerException e) {
			throw new UserRegistrationException(ExceptionType.ENTERED_NULL, "Password cannot be null");
		}
	}
		

	static boolean checkMobileNumber(String number) {
		try {
			if(number.length()==0) throw new UserRegistrationException(ExceptionType.ENTERED_EMPTY, "Mobile number cannot be empty");
			Pattern pattern = Pattern.compile("[1-9][0-9][\\s][1-9][0-9]{9}");
			Matcher matcher = pattern.matcher(number);
			if(matcher.matches()) {
				return true;
			} else {
				throw new UserRegistrationException(ExceptionType.ENTERED_INVALID, "Mobile number is invalid");
			}
		}catch(NullPointerException e) {
			throw new UserRegistrationException(ExceptionType.ENTERED_NULL, "Mobile number cannot be null");
		}
	}

	static boolean checkEmail(String email) {
		try {
			if(email.length()==0) throw new UserRegistrationException(ExceptionType.ENTERED_EMPTY, "Email cannot be empty");
			Pattern pattern = Pattern.compile("^abc[a-z0-9]*([+\\-_.][a-z0-9]{3})?@[a-z0-9]+\\.[a-z]{2,3}(\\.[a-z]{2,3})?$");
			Matcher matcher = pattern.matcher(email);
			if(matcher.matches()) {
				return true;
			} else {
				throw new UserRegistrationException(ExceptionType.ENTERED_INVALID, "Email is invalid");
			}
		}catch(NullPointerException e) {
			throw new UserRegistrationException(ExceptionType.ENTERED_NULL, "Email cannot be null");
		}
	}


	static boolean checkName(String name) {
		try {
			if(name.length()==0) throw new UserRegistrationException(ExceptionType.ENTERED_EMPTY, "Name cannot be empty");
			Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
			Matcher matcher = pattern.matcher(name);
			if(matcher.matches()) {
				return true;
			} else {
				throw new UserRegistrationException(ExceptionType.ENTERED_INVALID, "Name is invalid");
			}
		}catch(NullPointerException e) {
			throw new UserRegistrationException(ExceptionType.ENTERED_NULL, "Name cannot be null");
		}
	}

}

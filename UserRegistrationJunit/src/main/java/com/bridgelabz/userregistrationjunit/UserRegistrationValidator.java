package com.bridgelabz.userregistrationjunit;

import java.util.regex.Pattern;

import com.bridgelabz.userregistrationjunit.UserRegistrationException.ExceptionType;

import java.util.regex.Matcher;

@FunctionalInterface
interface Validation {
	boolean validate(String regex, String input);
}
public class UserRegistrationValidator {
	public static Validation inputValidator = (regex,inputToValidate)->{
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(inputToValidate).matches();
	};
	
	static boolean checkPassword(String password) {
		try {
			if(password.length()==0) throw new UserRegistrationException(ExceptionType.ENTERED_EMPTY, "Password cannot be empty");
			if(!UserRegistrationValidator.inputValidator.validate("(?=.*[A-Z])(?=.*[0-9]).{8,}", password)) 
				return false;
			if(UserRegistrationValidator.inputValidator.validate("^[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$", password)) {
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
			if(UserRegistrationValidator.inputValidator.validate("[1-9][0-9][\\s][1-9][0-9]{9}", number)) {
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
			if(UserRegistrationValidator.inputValidator.validate("^abc[a-z0-9]*([+\\-_.][a-z0-9]{3})?@[a-z0-9]+\\.[a-z]{2,3}(\\.[a-z]{2,3})?$", email)) {
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
			if(UserRegistrationValidator.inputValidator.validate("^[A-Z][a-z]{2,}$", name)) {
				return true;
			} else {
				throw new UserRegistrationException(ExceptionType.ENTERED_INVALID, "Name is invalid");
			}
		}catch(NullPointerException e) {
			throw new UserRegistrationException(ExceptionType.ENTERED_NULL, "Name cannot be null");
		}
	}

}

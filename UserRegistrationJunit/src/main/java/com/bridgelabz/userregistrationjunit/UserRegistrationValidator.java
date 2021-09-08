package com.bridgelabz.userregistrationjunit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationValidator {
	
	static boolean checkPassword(String password) {
		Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[0-9]).{8,}");
		Matcher matcher = pattern.matcher(password);
		if(!matcher.matches()) 
			return false;
		pattern = Pattern.compile("^[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$");
		matcher = pattern.matcher(password);
		return matcher.matches();
	}
		

	static boolean checkMobileNumber(String number) {
		Pattern pattern = Pattern.compile("[1-9][0-9][\\s][1-9][0-9]{9}");
		Matcher matcher = pattern.matcher(number);
		return matcher.matches();				
	}

	static boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile("^abc[a-z0-9]*([+\\-_.][a-z0-9]{3})?@[a-z0-9]+\\.[a-z]{2,3}(\\.[a-z]{2,3})?$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	static boolean checkLastName(String lastName) {
		Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
		Matcher matcher = pattern.matcher(lastName);
		return matcher.matches();
	}

	static boolean checkFirstName(String firstName) {
		Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
		Matcher matcher = pattern.matcher(firstName);
		return matcher.matches();
	}

}

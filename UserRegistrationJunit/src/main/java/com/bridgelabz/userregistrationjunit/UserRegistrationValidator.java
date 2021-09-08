package com.bridgelabz.userregistrationjunit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationValidator {
	
	private static boolean checkPassword(String password) {
		Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&-+=()]).{8,}");
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
		

	private static boolean checkMobileNumber(String number) {
		Pattern pattern = Pattern.compile("^\\d{2}[\\s]\\d{10}");
		Matcher matcher = pattern.matcher(number);
		return matcher.matches();				
	}

	private static boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile("([a-zA-Z][a-zA-Z0-9_-]*[a-zA-Z0-9])(([+-_.][a-zA-Z0-9]*)?)(@[a-zA-Z0-9]*)[.]([a-z]{2,})(([.][a-zA-z]{2})?)");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private static boolean checkLastName(String lastName) {
		Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
		Matcher matcher = pattern.matcher(lastName);
		return matcher.matches();
	}

	private static boolean checkFirstName(String firstName) {
		Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
		Matcher matcher = pattern.matcher(firstName);
		return matcher.matches();
	}

}

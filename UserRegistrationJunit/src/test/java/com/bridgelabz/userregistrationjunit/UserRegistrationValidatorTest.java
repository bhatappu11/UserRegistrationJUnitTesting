package com.bridgelabz.userregistrationjunit;

import org.junit.Test;
import org.junit.Assert;

public class UserRegistrationValidatorTest {
	@Test
	public void givenFirstName_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkFirstName("Arpitha");
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenFirstName_WhenShort_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkFirstName("Ar");
		Assert.assertFalse(result);
	}
	
	@Test
	public void givenFirstName_WhenUpperCaseMissing_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkFirstName("arpitha");
		Assert.assertFalse(result);
	}
	@Test
	public void givenLastName_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkLastName("Bhat");
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenLastName_WhenShort_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkLastName("Bh");
		Assert.assertFalse(result);
	}
	
	@Test
	public void givenLastName_WhenUpperCaseMissing_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkLastName("bhat");
		Assert.assertFalse(result);
	}
	@Test
	public void givenEmail_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkEmail("arpitha-bhat11@gmail.co.in");
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenEmail_WhenNotProper_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkEmail("1abc?@gmail.com");
		Assert.assertFalse(result);
	}
}

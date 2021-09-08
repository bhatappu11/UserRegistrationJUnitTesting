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
}

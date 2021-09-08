package com.bridgelabz.userregistrationjunit;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UserRegistrationValidatorTest {
	private String email;
	private boolean expectedOutput;
		
	public UserRegistrationValidatorTest(String email, boolean expectedOutput) {
		this.email = email;
		this.expectedOutput = expectedOutput;
	}

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
	public void givenEmail_WhenValidOrInvalidEmailInput_ShouldReturnTrueOrFalse() {
		UserRegistrationValidator userRegistration = new UserRegistrationValidator();
	   	boolean result = userRegistration.checkEmail(email);
	   	Assert.assertEquals(expectedOutput,result);
	}
	@Test
	public void givenMobileNumber_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkMobileNumber("91 7864567340");
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenMobileNumber_WhenShort_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkMobileNumber("91 6785678");
		Assert.assertFalse(result);
	}
	
	@Test
	public void givenMobileNumber_WhenNoSpace_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkMobileNumber("917865345689");
		Assert.assertFalse(result);
	}
	
	@Test
	public void givenMobileNumber_WhenNoCountryCode_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkMobileNumber("9060567436");
		Assert.assertFalse(result);
	}
	@Test
	public void givenPassword_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkPassword("Pedf$123s");
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenPassword_WhenShort_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkPassword("Qwe12@");
		Assert.assertFalse(result);
	}
	
	@Test
	public void givenPassword_WhenNoUpperCase_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkPassword("asdf@123");
		Assert.assertFalse(result);
	}
	
	@Test
	public void givenPassword_WhenNoNumericalDigit_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkPassword("AsdfQwert@");
		Assert.assertFalse(result);
	}
	
	@Test
	public void givenPassword_WhenNoSpecialCharacter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkPassword("Ayutwe123");
		Assert.assertFalse(result);
	}
	
	@Test
	public void givenPassword_WhenMoreThanOneSpecialCharacter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();	
		boolean result = validator.checkPassword("Poll@123$123");
		Assert.assertFalse(result);
	}
	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] { { "abc@yahoo.com",true }, { "abc-100@yahoo.com",true }, { "abc.100@yahoo.com",true },
					{ "abc111@abc.com",true }, { "abc-100@abc.net",true }, { "abc.100@abc.com.au",true }, { "abc@1.com",true },
					{ "abc@gmail.com.com",true }, { "abc+100@gmail.com",true }, { "abc",false }, { "abc@.com.my",false }, { "abc123@gmail.a",false },
					{ "abc123@.com",false }, { "abc123@.com.com",false }, { ".abc@abc.com",false }, { "abc()*@gmail.com",false }, { "abc@%*.com",false },
					{ "abc..2002@gmail.com",false }, { "abc.@gmail.com",false }, { "abc@abc@gmail.com",false }, { "abc@gmail.com.1a",false },
					{ "abc@gmail.com.aa.au",false } });
		}
}

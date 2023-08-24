package com.fssa.pin.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.User;
import com.fssa.pin.validation.exceptions.InvalidUserException;

class TestUserValidator {
	@Test
	void testValidUser() throws InvalidUserException {
		User user1 = new User("gopikannan2906@gmail.com", "Gopikannan", "Wow@2002", "9092500612", 1234567890,
				"ABCD0123456", "GOPI KANNAN");
		try {
			assertTrue(UserValidator.validateUpdateUser(user1));
			System.out.println("username is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	void testInvalidUser() {
		User user1 = new User("000.com", "000", "0", "0", 1234567890,
				"0", "0");
	    
		try {
			assertFalse(UserValidator.validateUpdateUser(user1));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	
}

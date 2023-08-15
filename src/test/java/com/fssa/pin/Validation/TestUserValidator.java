package com.fssa.pin.Validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.User;
import com.fssa.pin.validation.UserValidator;
import com.fssa.pin.validation.exceptions.InvalidUserException;

class TestUserValidator {
	@Test
	void testValidUser() throws InvalidUserException {
		User user1 = new User("gopikannan2906@gmail.com", "Gopikannan", "Wow@2002", "9092500612", 1234567890,
				"ABCD0123456", "GOPI KANNAN");
		boolean isValid = UserValidator.validateUpdateUser(user1);
		assertTrue(isValid);
	}

	@Test
	void testInvalidUser() {
		User invalidUser = new User(null, null, null, null, 0, null, null);

		assertThrows(InvalidUserException.class, () -> {
			UserValidator.validateUpdateUser(invalidUser);
		});
	}
}

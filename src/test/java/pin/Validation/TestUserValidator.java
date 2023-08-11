package pin.Validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pin.model.User;
import pin.validation.UserValidator;
import pin.validation.exceptions.InvalidUserException;

public class TestUserValidator {
	@Test
	public void testValidUser() throws InvalidUserException {
		User validUser = new User();
		validUser.setUsername("Soffan");
		validUser.setMail("soffan2906@gmail.com");
		validUser.setPassword("P@ssw0rd");
		validUser.setMobileno("9234567890");
		validUser.setAccNo(1234567890);
		validUser.setIfscNo("ABCD0123456");
		validUser.setAccName("John Doe");
 
		boolean isValid = UserValidator.validateUpdateUser(validUser);
		assertTrue(isValid);
	}

	@Test
	public void testInvalidUser() {
		User invalidUser = new User();
		invalidUser.setUsername("invalid user");
		invalidUser.setMail("invalid.email");
		invalidUser.setPassword("weakpwd");
		invalidUser.setMobileno("123");
		invalidUser.setAccNo(123);
		invalidUser.setIfscNo("invalid_ifsc");
		invalidUser.setAccName("John123");

		assertThrows(InvalidUserException.class, () -> {
			UserValidator.validateUpdateUser(invalidUser);
		});
	}
}

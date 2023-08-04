package pin.Validation.UserTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pin.validation.UserValidator;
import pin.validation.exceptions.InvalidUserException;

public class TestValidateMobileNo {
	@Test
	public void TestValidMobileNo() {
		try {
		
			assertTrue(UserValidator.ValidateMobileNo("9876543210"));
			System.out.println("Your mobile number is correct");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	public void TestInvalidMobileNoWithLessThan10Digits() {
		try {
			
			assertFalse(UserValidator.ValidateMobileNo("987654321"));
			System.out.println("Mobile number should be in 10 digits only");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	public void TestInvalidMobileNoWithMoreThan10Digits() {
		try {
			
			assertFalse(UserValidator.ValidateMobileNo("98765432101"));
			System.out.println("Mobile number contains 10 digits only");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void TestInvalidMobileNoWithPrefixOtherThan6789() {
		try {
		
			assertFalse(UserValidator.ValidateMobileNo("5678901234"));
			System.out.println("Mobile number do not start with 5 ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void TestInvalidMobileNoWithNonNumericCharacters() {
		try {
			
			assertFalse(UserValidator.ValidateMobileNo("9876a43210"));
			System.out.println("Mobile number contains integer");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	public void TestInvalidMobileNoStartingWithZero() {
		try {
			
			assertFalse(UserValidator.ValidateMobileNo("0123456789"));
			System.out.println("Mobile number do not start with 0 ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}
}

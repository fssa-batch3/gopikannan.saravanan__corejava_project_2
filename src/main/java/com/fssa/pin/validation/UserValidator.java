
package com.fssa.pin.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.pin.model.User;
import com.fssa.pin.validation.exceptions.InvalidUserException;

/**
 * Validates user details for creation.
 *
 * @param user The user to be validated.
 * @return true if user details are valid.
 * @throws InvalidUserException If user details are not valid.
 */
public class UserValidator {
	
//	private Constructor
	private UserValidator() {}
	
	public static boolean validateUser(User user) throws InvalidUserException {

//		User is Valid if username is valid and email is valid and pwd is valid
		if (user == null) {
			throw new InvalidUserException("User details cannot be null");
		}

		if (!validateName(user.getUsername()) || !validateEmail(user.getMail()) || !validatePassword(user.getPassword())
				|| !validateMobileNo(user.getMobileno())) {
			throw new InvalidUserException("User details not valid");
		}

		return true;

	}

	/**
	 * Validates user details for update.
	 *
	 * @param user The user to be validated.
	 * @return true if user details are valid.
	 * @throws InvalidUserException If user details are not valid.
	 */
	public static boolean validateUpdateUser(User user) throws InvalidUserException {

//		User is Valid if username is valid and email is valid and pwd is valid
		if (user == null) {
			throw new InvalidUserException("User details cannot be null");
		}

		if (!validateName(user.getUsername()) || !validateEmail(user.getMail()) || !validatePassword(user.getPassword())
				|| !validateMobileNo(user.getMobileno()) || !validateAccountNo(user.getAccNo())
				|| !validateIfscCode(user.getIfscNo()) || !validateAccountHolderName(user.getAccName())) {
			throw new InvalidUserException("User details not valid");
		}

		return true;

	}

	/**
	 * Validates the user's name.
	 *
	 * @param name The name to be validated.
	 * @return true if the name is valid.
	 * @throws InvalidUserException If the name is not valid.
	 */
	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;

		if (name == null || name.trim().isEmpty()) {
			return false;
		}

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException("The user name is not valid");

		}

	}

	/**
	 * Validates the user's password.
	 *
	 * @param password The password to be validated.
	 * @return true if the password is valid.
	 * @throws InvalidUserException If the password is not valid.
	 */
	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;

		if (password == null || password.trim().isEmpty()) {
			return false;
		}

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(patternString, password);

		if (match) {
			return true;
		} else {
			throw new InvalidUserException("Invalid password.");

		}

	}

	/**
	 * Validates the user's email address.
	 *
	 * @param email The email address to be validated.
	 * @return true if the email address is valid.
	 * @throws InvalidUserException If the email address is not valid.
	 */
	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;

		if (email == null || email.trim().isEmpty()) {
			return false;
		}

		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("The email address is: Invalid");

		}

	}

	/**
	 * Validates the user's mobile number.
	 *
	 * @param mobileno The mobile number to be validated.
	 * @return true if the mobile number is valid.
	 * @throws InvalidUserException If the mobile number is not valid.
	 */
	public static boolean validateMobileNo(String mobileno) throws InvalidUserException {
		boolean isMatch = false;
		if (mobileno == null || mobileno.trim().isEmpty()) {
			return false;
		}

		String regex = "^[6789]\\d{9}$";
		isMatch = Pattern.matches(regex, mobileno);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("The mobile number is: Invalid");

		}

	}

	/**
	 * Validates the user's account number.
	 *
	 * @param accno The account number to be validated.
	 * @return true if the account number is valid.
	 * @throws InvalidUserException If the account number is not valid.
	 */
	public static boolean validateAccountNo(int accno) throws InvalidUserException {
		String accnoString = String.valueOf(accno);
		boolean isMatch = false;
		if (accnoString == null || accnoString.trim().isEmpty()) {
			return false;
		}
		String regex = "[0-9]{10,}";
		isMatch = Pattern.matches(regex, accnoString);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("The account number is: Invalid");
		}
	}

	/**
	 * Validates the user's IFSC code.
	 *
	 * @param ifscCode The IFSC code to be validated.
	 * @return true if the IFSC code is valid.
	 * @throws InvalidUserException If the IFSC code is not valid.
	 */
	public static boolean validateIfscCode(String ifscCode) throws InvalidUserException {
		boolean isMatch = false;
		if (ifscCode == null || ifscCode.trim().isEmpty()) {
			return false;
		}

		String regex = "^[A-Za-z]{4}0[0-9A-Za-z]{6}$";
		isMatch = Pattern.matches(regex, ifscCode);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("The IFSC code is: Invalid");
		}
	}

	/**
	 * Validates the account holder's name.
	 *
	 * @param name The account holder's name to be validated.
	 * @return true if the name is valid.
	 * @throws InvalidUserException If the name is not valid.
	 */
	public static boolean validateAccountHolderName(String name) throws InvalidUserException {
		if (name == null || name.trim().isEmpty()) {
			return false;
		}

		boolean isMatch = false;

		String regex = "^[A-Za-z\\s.'-]{1,100}$";
		isMatch = Pattern.matches(regex, name);

		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("The account holder name is: Invalid");
		}

	}

}
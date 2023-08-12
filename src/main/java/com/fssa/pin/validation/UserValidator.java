
package com.fssa.pin.validation;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import com.fssa.pin.model.*;
import com.fssa.pin.validation.exceptions.InvalidUserException;

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserException {

//		User is Valid if username is valid and email is valid and pwd is valid
		if (user != null && validateName(user.getUsername()) && validateEmail(user.getMail())
				&& validatePassword(user.getPassword()) && validateMobileNo(user.getMobileno())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	public static boolean validateUpdateUser(User user) throws InvalidUserException {

//		User is Valid if username is valid and email is valid and pwd is valid
		if (user != null && validateName(user.getUsername()) 
				&& validateEmail(user.getMail())
				&& validatePassword(user.getPassword()) 
				&& validateMobileNo(user.getMobileno())
				&& validateAccountNo(user.getAccNo())
				&& validateIfscCode(user.getIfscNo())
				&& validateAccountHolderName(user.getAccName()))  
				{
				return true;}
			  
			  
		 else {
			throw new InvalidUserException("User details not valid");
		}

	}

	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;
		if (name == null)
			return false;
		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {

			System.out.println("The user name is valid.");
		} else {
			throw new InvalidUserException("The user name is not valid");

		}

		return match;
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		if (password == null)
			return false;

		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);

		if (match) {

			System.out.println("Valid password.");
		} else {
			throw new InvalidUserException("Invalid password.");

		}

		return match;
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;
		if (email == null)
			return false;

		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			throw new InvalidUserException("The email address is: Invalid");

		}
		return isMatch;
  
	}
 
	public static boolean validateMobileNo(String mobileno) throws InvalidUserException {
		boolean isMatch = false;
		if (mobileno == null)
			return false;

		String regex = "^[6789]\\d{9}$";
		isMatch = Pattern.matches(regex, mobileno);
		if (isMatch) {
			System.out.println("The mobile number is: Valid");
		} else {
			throw new InvalidUserException("The mobile number is: Invalid");

		}
		return isMatch; 

	}

	public static boolean validateAccountNo(int accno) throws InvalidUserException {
		String accnoString = String.valueOf(accno);
		boolean isMatch = false;
		if (accnoString == null)
			return false;

		String regex = "[0-9]{10,}";
		isMatch = Pattern.matches(regex, accnoString);
		if (isMatch) {
			System.out.println("The account number is: Valid");
		} else {
			throw new InvalidUserException("The account number is: Invalid");
		}
		return isMatch;
	}

	public static boolean validateIfscCode(String ifscCode) throws InvalidUserException {
		boolean isMatch = false;
		if (ifscCode == null)
			return false;

		String regex = "^[A-Za-z]{4}0[0-9A-Za-z]{6}$";
		isMatch = Pattern.matches(regex, ifscCode);
		if (isMatch) {
			System.out.println("The IFSC code is: Valid");
		} else {
			throw new InvalidUserException("The IFSC code is: Invalid");
		}
		return isMatch;
	}

	public static boolean validateAccountHolderName(String name) throws InvalidUserException {
		if (name == null || name.trim().isEmpty()) {
			throw new InvalidUserException("Account holder name cannot be empty.");
		}

		String regex = "^[A-Za-z\\s.'-]{1,100}$";
		boolean isMatch = Pattern.matches(regex, name);

		if (isMatch) {
			System.out.println("The account holder name is: Valid");
		} else {
			throw new InvalidUserException("The account holder name is: Invalid");
		}

		return isMatch;
	}  

}

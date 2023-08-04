
package pin.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import pin.model.*;
import pin.validation.exceptions.InvalidUserException;

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserException {

//		User is Valid if username is valid and email is valid and pwd is valid
		if (user != null && validateName(user.getUsername()) && validateEmail(user.getMail())
				&& validatePassword(user.getPassword()) && ValidateMobileNo(user.getMobileno())) {
			return true;
		} else {
			throw new InvalidUserException("User details not vailid");
		}
 
	} 
 
	public static boolean validateName(String name) throws InvalidUserException{
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

	public static boolean validatePassword(String password) throws InvalidUserException{
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

	public static boolean validateEmail(String email)throws InvalidUserException {
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
	public static boolean ValidateMobileNo(String mobileno)throws InvalidUserException  {
		boolean isMatch = false;
		if (mobileno == null)
			return false;

		String regex = 
				"^[6789]\\d{9}$";
		isMatch = Pattern.matches(regex, mobileno);
		if (isMatch) {
			System.out.println("The mobile number is: Valid");
		} else {
			throw new InvalidUserException("The mobile number is: Invalid");
			
		}
		return isMatch;

	} 
}

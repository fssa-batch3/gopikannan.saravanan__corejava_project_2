package pin.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pin.model.Fundraise;

import pin.validation.exceptions.InvalidFundraiseException;
import pin.validation.exceptions.InvalidUserException;

public class FundraiseValidation {

	public static boolean validateFundraise(Fundraise Fundraise)
			throws InvalidFundraiseException, InvalidUserException {

//		User is Valid if username is valid and email is valid and pwd is valid
		if (Fundraise != null && UserValidator.validateName(Fundraise.getName())
				&& UserValidator.validateEmail(Fundraise.getEmail())
				&& UserValidator.ValidateMobileNo(Fundraise.getPhno())
				&& validateExpectedAmount(Fundraise.getExpected_amount())
				&& validateFundraiseImageURL(Fundraise.getCover_pic()) && validateFundraiseStory(Fundraise.getStory())
				&& validateTitle(Fundraise.getTitle()) && validateCause(Fundraise.getCause())) {
			return true;
		} else {
			throw new InvalidFundraiseException("Fundraise details not valid");
		}

	}

	public static boolean validateExpectedAmount(int cost) throws InvalidFundraiseException {
		boolean match = false;

		String regex = "^\\d{5,8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(Integer.toString(cost));
		match = m.matches();

		if (match) {
			System.out.println("The product cost is valid.");
		} else {
			throw new InvalidFundraiseException("The fundraise amount should be a atleast 10000.");
		}
		return match;
	}

	public static boolean validateFundraiseImageURL(String imageUrl) throws InvalidFundraiseException {
		boolean match = false;
		String regex = "^(https?|ftp)://.*$";
		match = Pattern.matches(regex, imageUrl);
		if (match) {
			System.out.println("The fundraise image URL is valid.");
		} else {
			throw new InvalidFundraiseException("The fundraise image URL is not valid.");
		}

		return match;
	}

	public static boolean validateFundraiseStory(String story) throws InvalidFundraiseException {
		boolean match = false;

		int lengthOfWords = 100;

		if (story != null && story.trim().length() >= lengthOfWords) {
			match = true;
			System.out.println("The story detail is valid.");
		} else {
			throw new InvalidFundraiseException("The story detail is not valid.");
		}

		return match;
	}

	public static boolean validateTitle(String title) throws InvalidFundraiseException {
		boolean match = false;

		int maxLength = 100;

		if (title != null && title.trim().length() <= maxLength) {
			match = true;
			System.out.println("The title is valid.");
		} else {
			throw new InvalidFundraiseException("The title must not be more than 100 characters.");
		}

		return match;
	}

	public static boolean validateCause(String cause) throws InvalidFundraiseException {
		boolean match = false;

		int maxLength = 50;

		if (cause != null && cause.trim().length() <= maxLength) {
			match = true;
			System.out.println("The cause is valid.");
		} else {
			throw new InvalidFundraiseException("The cause must not be more than 50 characters.");
		}

		return match;
	}

}

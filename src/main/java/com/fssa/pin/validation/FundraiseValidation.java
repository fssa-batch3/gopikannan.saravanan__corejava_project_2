package com.fssa.pin.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.pin.model.Fundraise;
import com.fssa.pin.validation.exceptions.InvalidFundraiseException;
import com.fssa.pin.validation.exceptions.InvalidUserException;

public class FundraiseValidation {

	public static boolean validateFundraise(Fundraise fundraise)
			throws InvalidFundraiseException, InvalidUserException {

		if (fundraise != null &&

				validateExpectedAmount(fundraise.getExpectedAmount())
				&& validateFundraiseImageURL(fundraise.getCoverPic()) && validateFundraiseStory(fundraise.getStory())
				&& validateTitle(fundraise.getTitle()) && validateCause(fundraise.getCause())) {
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
			System.out.println("The fundraise amount is valid.");
			return true;
		} else {
			throw new InvalidFundraiseException("The fundraise amount should be a atleast 10000.");
		}

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
		int lengthOfWords = 100;

		if (story != null && story.trim().length() >= lengthOfWords) {
			System.out.println("The story detail is valid.");
			return true;
		} else {
			throw new InvalidFundraiseException("The story detail is not valid.");
		}
	}

	public static boolean validateTitle(String title) throws InvalidFundraiseException {
		int maxLength = 100;

		if (title != null && title.trim().length() <= maxLength) {
			System.out.println("The title is valid.");
			return true;
		} else {
			throw new InvalidFundraiseException("The title must not be more than 100 characters.");
		}
	}

	public static boolean validateCause(String cause) throws InvalidFundraiseException {
		int maxLength = 50;

		if (cause != null && cause.trim().length() <= maxLength) {
			System.out.println("The cause is valid.");
			return true;
		} else {
			throw new InvalidFundraiseException("The cause must not be more than 50 characters.");
		}
	}

}

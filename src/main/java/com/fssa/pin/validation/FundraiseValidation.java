package com.fssa.pin.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.pin.model.Fundraise;
import com.fssa.pin.validation.exceptions.InvalidFundraiseException;
/**
 * This class provides methods to validate various aspects of a Fundraise object.
 */
public class FundraiseValidation {

	private FundraiseValidation() {
		
	}
	
	  /**
     * Validates a Fundraise object.
     *
     * @param fundraise The Fundraise object to be validated.
     * @return Returns true if the Fundraise object is valid, otherwise throws an exception.
     * @throws InvalidFundraiseException If the Fundraise object is not valid.
     */
	public static boolean validateFundraise(Fundraise fundraise) throws InvalidFundraiseException {
		
		if (fundraise == null) {
			throw new InvalidFundraiseException("fundraise details cannot be null");
		}

		if (    validateExpectedAmount(fundraise.getExpectedAmount())
				&& validateFundraiseImageURL(fundraise.getCoverPic()) 
				&& validateFundraiseStory(fundraise.getStory())
				&& validateTitle(fundraise.getTitle())  
				&& validateCause(fundraise.getCause())) {
			return true;
		} else {
			throw new InvalidFundraiseException("Fundraise details not valid");
		}
	}
	  /**
     * Validates the expected amount of a fundraise.
     *
     * @param cost The expected amount of the fundraise.
     * @return Returns true if the expected amount is valid, otherwise throws an exception.
     * @throws InvalidFundraiseException If the expected amount is not valid.
     */
	public static boolean validateExpectedAmount(int cost) throws InvalidFundraiseException {
		boolean match = false;

		String regex = "^\\d{5,8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(Integer.toString(cost));
		match = m.matches();

		if(cost>0) {
			return false;
		}
		if (!match) {
			throw new InvalidFundraiseException("The fundraise amount should be a atleast 10000.");
		} 
		return true;
		

	}

    /**
     * Validates a URL for the fundraise image.
     *
     * @param imageUrl The URL of the fundraise image.
     * @return Returns true if the image URL is valid, otherwise throws an exception.
     * @throws InvalidFundraiseException If the image URL is not valid.
     */
	public static boolean validateFundraiseImageURL(String imageUrl) throws InvalidFundraiseException {
		boolean match = false;
		String regex = "^(https?|ftp)://.*$";
		match = Pattern.matches(regex, imageUrl);
		
		
		if (imageUrl == null || imageUrl.trim().isEmpty()) {
			return false;
		}
		if (match) {
			return true;
		} else {
			throw new InvalidFundraiseException("The fundraise image URL is not valid.");
		}

	}

    /**
     * Validates the story text of a fundraise.
     *
     * @param story The story text of the fundraise.
     * @return Returns true if the story text is valid, otherwise throws an exception.
     * @throws InvalidFundraiseException If the story text is not valid.
     */
	public static boolean validateFundraiseStory(String story) throws InvalidFundraiseException {
		int lengthOfWords = 100;
		if (story == null || story.trim().isEmpty()) {
			return false;
		}

		if ( story.trim().length() >= lengthOfWords) {
			return true;
		} else {
			throw new InvalidFundraiseException("The story detail is not valid.");
		}
	}
	
	/**
     * Validates the title of a fundraise.
     *
     * @param title The title of the fundraise.
     * @return Returns true if the title is valid, otherwise throws an exception.
     * @throws InvalidFundraiseException If the title is not valid.
     */
	public static boolean validateTitle(String title) throws InvalidFundraiseException {
		int maxLength = 100;
		
		if (title == null || title.trim().isEmpty()) {
			return false;
		}


		if ( title.trim().length() <= maxLength) {
			return true;
		} else {
			throw new InvalidFundraiseException("The title must not be more than 100 characters.");
		}
	}

	 /**
     * Validates the cause of a fundraise.
     *
     * @param cause The cause of the fundraise.
     * @return Returns true if the cause is valid, otherwise throws an exception.
     * @throws InvalidFundraiseException If the cause is not valid.
     */
	public static boolean validateCause(String cause) throws InvalidFundraiseException {
		int maxLength = 50;
		
		if (cause == null || cause.trim().isEmpty()) {
			return false;
		}

		if ( cause.trim().length() <= maxLength) {
			return true;
		} else {
			throw new InvalidFundraiseException("The cause must not be more than 50 characters.");
		}
	}

}

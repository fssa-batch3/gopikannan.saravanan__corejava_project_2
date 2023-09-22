
package com.fssa.pin.validation;

import java.util.regex.Pattern;

import com.fssa.pin.model.Fundraise;
import com.fssa.pin.validation.exceptions.InvalidFundraiseException;

/**
 * Validates various aspects of a Fundraise object.
 */
public class FundraiseValidation {

	private FundraiseValidation() {
		// Private constructor to prevent instantiation
	}

	/**
	 * Validates a Fundraise object.
	 *
	 * @param fundraise The Fundraise object to be validated.
	 * @return true if the Fundraise object is valid.
	 * @throws InvalidFundraiseException If the Fundraise object is not valid.
	 */ 
	public static boolean validateFundraise(Fundraise fundraise) throws InvalidFundraiseException {
		if (fundraise == null) {
			throw new InvalidFundraiseException("Fundraise details cannot be null");
		}

		if (!validateExpectedAmount(fundraise.getExpectedAmount())
				|| !validateFundraiseImageURL(fundraise.getCoverPic()) || !validateFundraiseStory(fundraise.getStory())
				|| !validateTitle(fundraise.getTitle()) || !validateCause(fundraise.getCause())) {
			throw new InvalidFundraiseException("Fundraise details not valid");
		}
		return true;
	}

	/**
	 * Validates the expected amount of a fundraise.
	 *
	 * @param expectedAmount The expected amount of the fundraise.
	 * @return true if the expected amount is valid.
	 * @throws InvalidFundraiseException If the expected amount is not valid.
	 */
	public static boolean validateExpectedAmount(int expectedAmount) throws InvalidFundraiseException {

		if (expectedAmount == 0) {
			return false;
		}
		if (expectedAmount < 0) {
			throw new InvalidFundraiseException("The fundraise amount cannot be negative.");
		}
		if (expectedAmount < 10000) {
			throw new InvalidFundraiseException("The fundraise amount should be at least 10000");
		}
		return true;
	}

	/**
	 * Validates a URL for the fundraise image.
	 *
	 * @param imageUrl The URL of the fundraise image.
	 * @return true if the image URL is valid.
	 * @throws InvalidFundraiseException If the image URL is not valid.
	 */
	public static boolean validateFundraiseImageURL(String imageUrl) throws InvalidFundraiseException {
		if (imageUrl == null || imageUrl.trim().isEmpty()) {
			return false;
		}

		String regex = "^(https?|ftp)://.*$";
		if (Pattern.matches(regex, imageUrl)) { 
			return true;
		} else {
			throw new InvalidFundraiseException(
					"The fundraise image URL is invalid. Enter your url like this ex: https://unsplash.com/s/photos/social-cause");
		}
	}

	/**
	 * Validates the story text of a fundraise.
	 *
	 * @param story The story text of the fundraise.
	 * @return true if the story text is valid.
	 * @throws InvalidFundraiseException If the story text is not valid.
	 */
	public static boolean validateFundraiseStory(String story) throws InvalidFundraiseException {
		if (story == null || story.trim().isEmpty()) {
			return false;
		}
		if (story.trim().length() < 100) {
			throw new InvalidFundraiseException("The story detail is not valid: must not be less than 100 letters.");

		}
		return true;
	}

	/**
	 * Validates the title of a fundraise.
	 *
	 * @param title The title of the fundraise.
	 * @return true if the title is valid.
	 * @throws InvalidFundraiseException If the title is not valid.
	 */
	public static boolean validateTitle(String title) throws InvalidFundraiseException {
		if (title == null || title.trim().isEmpty()) {
			return false;
		}
		if (title.trim().length() > 100) {
			throw new InvalidFundraiseException("The title must not be more than 100 characters.");
		}
		return true;
	}

	/**
	 * Validates the cause of a fundraise.
	 *
	 * @param cause The cause of the fundraise.
	 * @return true if the cause is valid.
	 * @throws InvalidFundraiseException If the cause is not valid.
	 * 
	 */
	public static boolean validateCause(String cause) throws InvalidFundraiseException {
		if (cause == null || cause.trim().isEmpty()) {
			return false;
		}

		if (cause.trim().length() > 50) {

			throw new InvalidFundraiseException("The cause must not be more than 50 characters.");
		}
		return true;
	}
	
	
	/**
	 * Validates a document URL for the fundraise .
	 *
	 * @param document The URL of the fundraise image.
	 * @return true if the document URL is valid.
	 * @throws InvalidFundraiseException If the document URL is not valid.
	 */
	public static boolean validateFundraiseDocument(String document) throws InvalidFundraiseException {
		if (document == null || document.trim().isEmpty()) {
			return false;
		}

		String regex = "^(https?|ftp)://.*$";
		if (Pattern.matches(regex, document)) { 
			return true;
		} else {
			throw new InvalidFundraiseException(
			"The fundraise document URL is invalid. Enter your url like this ex: https://unsplash.com/s/photos/social-cause");
		}
	}
}

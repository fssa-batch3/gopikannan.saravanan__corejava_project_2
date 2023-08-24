package com.fssa.pin.validation;

import com.fssa.pin.model.Donate;
import com.fssa.pin.validation.exceptions.InvalidDonationException;

/**
 * This class provides methods to validate donation details information.
 */
public class DonateValidation {

	private DonateValidation() {
		 // Private constructor to prevent instantiation.
	}

	
	/**
	 * Validates a donation object.
	 *
	 * @param donate The Donate object to be validated.
	 * @return Returns true if the donation object is valid.
	 * @throws InvalidDonationException If the donation object is not valid or if it's null.
	 */
	public static boolean validDonation(Donate donate) throws InvalidDonationException {

		if(donate==null) {
			throw new InvalidDonationException("Donate details must not be null");
		}
		
		if ( validateUserId(donate.getUser().getUserid())
				&& validateFundrasieId(donate.getFundraise().getFundraiseid())
				&& validateContributionAmt(donate.getDonaterContribution())) {
			return true;
		} else {
			throw new InvalidDonationException("donation details is not valid");
		}

	}

	 /**
     * Validates a user ID.
     *
     * @param userId The user ID to be validated.
     * @return Returns true if the user ID is valid.
     * @throws InvalidDonationException If the user ID is not valid.
     */
	public static boolean validateUserId(int userId) throws InvalidDonationException {

		if (userId > 0) {
			return true;
		} else {
			throw new InvalidDonationException("Invalid userid. The userid must be a positive integer.");
		}
	}
	 /**
     * Validates a fundraise ID.
     *
     * @param fundraiseId The fundraise ID to be validated.
     * @return Returns true if the fundraise ID is valid.
     * @throws InvalidDonationException If the fundraise ID is not valid.
     */
	public static boolean validateFundrasieId(int fundrasieId) throws InvalidDonationException {

		if (fundrasieId > 0) {
			return true;
		} else {
			throw new InvalidDonationException("Invalid fundraiseId. The fundraiseId must be a positive integer.");
		}
	}

	
	 /**
     * Validates a contribution amount.
     *
     * @param contibution The contribution amount to be validated.
     * @return Returns true if the contribution amount is valid.
     * @throws InvalidDonationException If the contribution amount is not valid.
     */ 
	public static boolean validateContributionAmt(int contibution) throws InvalidDonationException {

		if (contibution > 0) {
			return true;
		} else {
			throw new InvalidDonationException("The contribution amount must not be in negative");
		}
	}
}

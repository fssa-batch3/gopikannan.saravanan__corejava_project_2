package com.fssa.pin.validation;

import com.fssa.pin.model.Donate;
import com.fssa.pin.validation.exceptions.InvalidDonationException;

public class DonateValidation {

	public static boolean validDonation(Donate donate) throws InvalidDonationException {

		if (donate != null && validateUserId(donate.getUser().getUserid())
				&& validateFundrasieId(donate.getFundraise().getFundraiseid())
				&& validateContributionAmt(donate.getDonaterContribution())) {
			return true;
		} else {
			throw new InvalidDonationException("donation details is not valid");
		}

	} 

	public static boolean validateUserId(int userId) throws InvalidDonationException {

		if (userId > 0) {
			System.out.println("The userid is valid.");
			return true;
		} else {
			throw new InvalidDonationException("Invalid userid. The userid must be a positive integer.");
		}
	}

	public static boolean validateFundrasieId(int fundrasieId) throws InvalidDonationException {

		if (fundrasieId > 0) {
			System.out.println("The userid is valid.");
			return true;
		} else {
			throw new InvalidDonationException("Invalid fundraiseId. The fundraiseId must be a positive integer.");
		}
	}

	public static boolean validateContributionAmt(int contibution) throws InvalidDonationException {

		if (contibution > 0) {
			System.out.println("The contribution amount is valid ");
			return true;
		} else {
			throw new InvalidDonationException("The contribution amount must not be in negative");
		}
	}
}

package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.Donate;
import com.fssa.pin.model.Fundraise;
import com.fssa.pin.model.User;
import com.fssa.pin.service.DonateService;
import com.fssa.pin.service.exception.ServiceException;

class TestDonationCreateFeature {

	private final Donate donate = new Donate();

//		Test to create donate
	@Test
	void testCreateDonationSuccess() {
		User user = new User();
		user.setUserid(2);
		donate.setUser(user);

		Fundraise fundraise = new Fundraise();
		fundraise.setFundraiseid(490);
		donate.setFundraise(fundraise);

		donate.setDonaterContribution(20000);
		DonateService donateService = new DonateService();
		try {
			assertTrue(donateService.createDonationService(donate));
			System.out.println("Successfully created a donation");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testCreateDonationFail() {
		User user = new User();
		user.setUserid(-1);
		donate.setUser(user);

		Fundraise fundraise = new Fundraise();
		fundraise.setFundraiseid(-2);
		donate.setFundraise(fundraise);

		donate.setDonaterContribution(-100);
		DonateService donateService = new DonateService();
		try {
			assertFalse(donateService.createDonationService(donate));
			System.out.println("Failed to create an invalid donation");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
}

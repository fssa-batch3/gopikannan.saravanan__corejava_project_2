package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.Donate;
import com.fssa.pin.service.DonateService;
import com.fssa.pin.service.exception.ServiceException;

class TestDonationViewFeature {

	@Test
	void testViewDonationsSuccess() {
		
	DonateService donationservice = new DonateService();
	
	try { 

 
		List<Donate> donations = donationservice.viewDonationsService();

		assertNotNull(donations);

		for (Donate alldonations : donations) {
			System.out.println(alldonations.toString());
		}

		System.out.println("Successfully Viewed All Donations");
	} catch (ServiceException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	}
	
	
	
	@Test
	void testViewDonationsFailed() {
		DonateService donationservice = new DonateService();
		

		try {

			List<Donate> donations = donationservice.viewDonationsService();
			assertFalse(donations.isEmpty());

		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}
}

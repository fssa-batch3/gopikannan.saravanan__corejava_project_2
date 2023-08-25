package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.Fundraise;
import com.fssa.pin.model.User;
import com.fssa.pin.service.FundraiseService;
import com.fssa.pin.service.exception.ServiceException;

class TestFunsdraiseCreateFeature {
	private final Fundraise fundraise = new Fundraise();

//test create fund raise for success
	@Test
	void testCreateValid() {
		User user = new User();
		user.setUserid(1);
		fundraise.setUser(user);

		FundraiseService fundraiseservice = new FundraiseService();
		fundraise.setCause("Medical");
		fundraise.setCoverPic(
				"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais");
		fundraise.setTitle("Help this patient");
		fundraise.setStory(
				"As I lay in the hospital bed, surrounded by white walls and medical equipment, a mix of emotions overwhelmed me. Diagnosed with a serious condition after experiencing fatigue and headaches, I faced a challenging journey. The care from dedicated medical professionals, support from family and friends, and moments of joy brought comfort. Each day, I found strength in hope and gratitude, cherishing life's small joys. The hospital became a sanctuary of healing and taught me resilience. Though uncertain, I embraced the path to recovery with courage. This life-altering experience taught me to value health, cherish relationships, and find strength in adversity.");
		fundraise.setExpectedAmount(150000);

		try {
			assertTrue(fundraiseservice.createFundraise(fundraise));
			System.out.println("Successfully created a fundraise");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}      
 
	// tests create fund raise for success

	@Test
	void testCreateInvalid() {
		User user = new User();
		user.setUserid(1);
		fundraise.setUser(user);

		FundraiseService fundraiseservice = new FundraiseService();

		fundraise.setCause(null);
		fundraise.setCoverPic(null);
		fundraise.setTitle(null);
		fundraise.setStory(null);
		fundraise.setExpectedAmount(0);
 
		try {
			assertFalse(fundraiseservice.createFundraise(fundraise));
			System.out.println("Failed to create an invalid fundraise");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}

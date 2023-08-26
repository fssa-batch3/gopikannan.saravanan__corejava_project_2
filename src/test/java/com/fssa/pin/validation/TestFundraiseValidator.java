package com.fssa.pin.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.Fundraise;
import com.fssa.pin.validation.exceptions.InvalidFundraiseException;

class TestFundraiseValidator {

	@Test
	void testValidFundraise() {

//		User user = new User("soffan2906@gmail.com", "Soffan", "Wow@2002", "9028848999", 1234567890, "ABCD0123456",
//				"SOFFANKANNAN", 1);

		Fundraise fundraise = new Fundraise();

		fundraise.setCause("Medical");
		fundraise.setCoverPic(
				"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais");
		fundraise.setTitle("Help this patient");
		fundraise.setStory(
				"As I lay in the hospital bed, surrounded by white walls and medical equipment, a mix of emotions overwhelmed me. Diagnosed with a serious condition after experiencing fatigue and headaches, I faced a challenging journey. The care from dedicated medical professionals, support from family and friends, and moments of joy brought comfort. Each day, I found strength in hope and gratitude, cherishing life's small joys. The hospital became a sanctuary of healing and taught me resilience. Though uncertain, I embraced the path to recovery with courage. This life-altering experience taught me to value health, cherish relationships, and find strength in adversity.");
		fundraise.setExpectedAmount(150000);

		// Set valid attributes for the fundraise

		try {
			assertTrue(FundraiseValidation.validateFundraise(fundraise));
		} catch (InvalidFundraiseException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	void testInvalidFundraise() {

		Fundraise fundraise = new Fundraise();

		fundraise.setCause(null);
		fundraise.setCoverPic(null);
		fundraise.setTitle(null);
		fundraise.setStory(null);
		fundraise.setExpectedAmount(0);

		// Set invalid attributes for the fundraise

		try {
			assertFalse(FundraiseValidation.validateFundraise(fundraise));
		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}
	}
}

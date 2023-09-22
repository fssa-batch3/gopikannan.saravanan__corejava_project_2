package com.fssa.pin.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.pin.validation.exceptions.InvalidFundraiseException;

class TestFundraiseImageUrl {
	@Test

	void validProductImage() {
		try {
			assertTrue(FundraiseValidation.validateFundraiseImageURL(
					"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais"));

		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}

	}

	
	@Test
	void emptyImageUrl() {
		try {
			assertFalse(FundraiseValidation.validateFundraiseImageURL(""));
		} catch (InvalidFundraiseException e) {
			assertEquals("The fundraise image URL is invalid. Enter your url like this ex: https://unsplash.com/s/photos/social-cause",e.getMessage());
		}
	}

}

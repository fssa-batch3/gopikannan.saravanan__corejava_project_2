package com.fssa.pin.Validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.pin.validation.FundraiseValidation;
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

	void inValidProductImage() {
		try {
			assertFalse(FundraiseValidation.validateFundraiseImageURL(
					"lll://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais"));
			System.out.println("Image URL isn't Valid");
		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}
	}
		
		 @Test
		    void nullImageUrl() {
		        try {
		            assertFalse(FundraiseValidation.validateFundraiseImageURL(null));
		        } catch (InvalidFundraiseException e) {
		            assertEquals("Invalid image URL", e.getMessage());
		        }
		    }
 
		    @Test
		    void emptyImageUrl() {
		        try {
		            assertFalse(FundraiseValidation.validateFundraiseImageURL(""));
		        } catch (InvalidFundraiseException e) {
		            assertEquals("Invalid image URL", e.getMessage());
		        }
		    }
		
		
	}

package com.fssa.pin.Validation;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.fssa.pin.validation.FundraiseValidation;
import com.fssa.pin.validation.exceptions.InvalidFundraiseException;

 class TestFundraiseCause {

	@Test
	void testValidCause() {
		try {
			String validStory = "Hello World";
			assertTrue(FundraiseValidation.validateCause(validStory));
		} catch (InvalidFundraiseException e) {
		
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInValidCause() {
		try {
			String validStory = "dehfviowhefuihweuifhwuiehuiwhuifhiuwhfuhweiufhqiuwhfuiwheuihqiwuefhuiqwhefuiweufwuiebfgubwufbuwguwehgiuwhguihwioweifwiefiwefuhwefubweufhwuehwuehfuiwehfuwefubwufseufhwuefhuwebfuw7u";
			assertFalse(FundraiseValidation.validateCause(validStory));
		} catch (InvalidFundraiseException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	

 
   
}

package pin.Validation.FundraiseInputValidationsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pin.validation.FundraiseValidation;
import pin.validation.exceptions.InvalidFundraiseException;

public class TestFundraiseStory {

	@Test
	void testValidStory() {
		try {
			String validStory = "This is a valid story with exactly 100 words. It doesn't matter what the content is, as long as it has 100 words. We are testing the validation function for the fundraise story. The story can be about anything, a personal experience, a fictional tale, or even just random words to meet the word count requirement. The important thing is that it has exactly 100 words for this test case.";
			assertTrue(FundraiseValidation.validateFundraiseStory(validStory));		
		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInValidStory() {
		try {
			String validStory = "Hello World";
			assertFalse(FundraiseValidation.validateFundraiseStory(validStory));
		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}
	}

}

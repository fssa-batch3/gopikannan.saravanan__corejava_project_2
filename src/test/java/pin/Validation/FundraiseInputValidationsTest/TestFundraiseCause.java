package pin.Validation.FundraiseInputValidationsTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import pin.validation.FundraiseValidation;
import pin.validation.exceptions.InvalidFundraiseException;

public class TestFundraiseCause {

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

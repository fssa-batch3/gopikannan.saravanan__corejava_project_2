package pin.Validation.FundraiseInputValidationsTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pin.validation.FundraiseValidation;
import pin.validation.exceptions.InvalidFundraiseException;

public class TestFundraiseTitle {
	@Test
	void testValidTitle() {
		try {
			String validStory = "Hello World";
			assertTrue(FundraiseValidation.validateTitle(validStory));		
		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInValidTitle() {
		try {
			String title = "duwheihfwuihfhweiufhiwehfuihewuifhuiehfuihweuifhuiwheuiweuifuihweiufhiuwehufhweihfuiwehufhuhefhueihuiwehfuiweuibbeiubuifhiwhfiuhuehfiwhefuhwiehfiwheifhweiuhfihehihuifhhanjknjkcnaknkannfweuifhguihwioweifwiefiwefuhwefuehwuehfuiwehfuwefuhsihasiochoiahsciohasoichaioschioashcoiahsicohasiohcioashciohaioschioascioahcioaiochoiahoiahsiioahscoihaiohioahsiohcaioaoishcoihaiscbwufseufhwuefhuwebfuw7u";
			assertFalse(FundraiseValidation.validateTitle(title));
		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}
	}

}

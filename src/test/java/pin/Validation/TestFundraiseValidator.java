package pin.Validation;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import pin.model.Fundraise;
import pin.validation.FundraiseValidation;
import pin.validation.exceptions.InvalidFundraiseException;
import pin.validation.exceptions.InvalidUserException;

public class TestFundraiseValidator {


	    @Test
	    public void testValidFundraise() {
	        Fundraise validFundraise = new Fundraise();
	        // Set valid attributes for the fundraise
	        
	        try {
	            assertTrue(FundraiseValidation.validateFundraise(validFundraise));
	        } catch (InvalidFundraiseException | InvalidUserException e) {
	            fail("Unexpected exception: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testInvalidFundraise() {
	        Fundraise invalidFundraise = new Fundraise();
	        // Set invalid attributes for the fundraise
	        
	        assertThrows(InvalidFundraiseException.class, () -> {
	            FundraiseValidation.validateFundraise(invalidFundraise);
	        });
	    }
	    
	    
package pin.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import pin.service.FundraiseService;
import pin.service.exception.ServiceException;
 
class TestFundraiseDeleteFeature {
	@Test

	void deleteFundraiseSuccess() {
		FundraiseService fundraiseservice = new FundraiseService();
		try {
			assertTrue(fundraiseservice.fundraiseDelete(54));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

	}
	
	  
	@Test

	void deleteFundraiseFailed() {
		FundraiseService fundraiseservice = new FundraiseService();
		try {
			assertFalse(fundraiseservice.fundraiseDelete(524));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

	}

}

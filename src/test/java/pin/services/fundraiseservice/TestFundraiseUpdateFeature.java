package pin.services.fundraiseservice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pin.model.Fundraise;
import pin.model.User;
import pin.service.FundraiseService;
import pin.service.exception.ServiceException;
 
class TestFundraiseUpdateFeature {

	@Test
	void testUpdateSuccess() {

		User user = new User("soffan2906@gmail.com", "Soffan", "Wow@2002", "9028848999", 1234567890, "ABCD0123456",
				"SOFFANKANNAN", 1);

		FundraiseService fundraiseservice = new FundraiseService();
		Fundraise fundraise = new Fundraise(user.getUsername(), user.getMail(), user.getMobileno(), user.getAccNo(),
				user.getIfscNo(), user.getAccName(), user.getUserid(), "Education",
				"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais",
				"Help this patient",
				"As I lay in the hospital bed, surrounded by white walls and medical equipment, a mix of emotions overwhelmed me. Diagnosed with a serious condition after experiencing fatigue and headaches, I faced a challenging journey. The care from dedicated medical professionals, support from family and friends, and moments of joy brought comfort. Each day, I found strength in hope and gratitude, cherishing life's small joys. The hospital became a sanctuary of healing and taught me resilience. Though uncertain, I embraced the path to recovery with courage. This life-altering experience taught me to value health, cherish relationships, and find strength in adversity.",
				200000,3);

		try {
		
			assertTrue(fundraiseservice.fundraiseUpdate(fundraise));
			System.out.println("Successfully updates a fundraise");
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
			
		}
	}
	
	@Test 
	void testUpdateFail() {
		
		
		FundraiseService fundraiseservice = new FundraiseService();
		Fundraise fundraise = new Fundraise(null, null, null, 0, null, null, 0, null, null, null, null, 0, 0);
		try {
			
			assertFalse(fundraiseservice.fundraiseUpdate(fundraise));
			
			
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			
		}
	}
}

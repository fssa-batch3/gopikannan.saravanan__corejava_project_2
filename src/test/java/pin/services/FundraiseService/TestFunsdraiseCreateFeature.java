package pin.services.FundraiseService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pin.model.Fundraise;

import pin.service.exception.ServiceException;
import pin.service.*;

public class TestFunsdraiseCreateFeature {
 
	@Test
	void testCreateValid() {

		FundraiseService fundraiseservice = new FundraiseService();
		Fundraise fundraise = new Fundraise("Soffan", "soffan2906@gmail.com", "9092500612", "Medical",
				"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais",
				"Help this patient",
				"As I lay in the hospital bed, surrounded by white walls and medical equipment, a mix of emotions overwhelmed me. Diagnosed with a serious condition after experiencing fatigue and headaches, I faced a challenging journey. The care from dedicated medical professionals, support from family and friends, and moments of joy brought comfort. Each day, I found strength in hope and gratitude, cherishing life's small joys. The hospital became a sanctuary of healing and taught me resilience. Though uncertain, I embraced the path to recovery with courage. This life-altering experience taught me to value health, cherish relationships, and find strength in adversity.",
				150000);
		try {
			

			assertTrue(fundraiseservice.createFundraise(fundraise));

		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}

	}
 
	@Test
	void testCreateInvalid() {

		FundraiseService fundraiseservice = new FundraiseService();

		try {
			Fundraise fundraise = new Fundraise("segyu", "uawi.com", "9092500612", "Medical",
					"img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais",
					"H",
					"As I lay in the hospital bed, surrounded by white walls and medical equipment, a mix of emotions overwhelmed me. Diagnosed with a serious condition after experiencing fatigue and headaches, I faced a challenging journey. The care from dedicated medical professionals, support from family and friends, and moments of joy brought comfort. Each day, I found strength in hope and gratitude, cherishing life's small joys. The hospital became a sanctuary of healing and taught me resilience. Though uncertain, I embraced the path to recovery with courage. This life-altering experience taught me to value health, cherish relationships, and find strength in adversity.",
					150000);
			assertFalse(fundraiseservice.createFundraise(fundraise));

		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}

	}


}

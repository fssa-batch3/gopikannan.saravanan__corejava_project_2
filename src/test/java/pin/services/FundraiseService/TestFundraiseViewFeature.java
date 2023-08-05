package pin.services.FundraiseService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import pin.service.exception.*;

import pin.model.Fundraise;
import pin.service.FundraiseService;
import pin.dao.FundraiseDAO;
import pin.dao.exceptions.DAOException;

 class TestFundraiseViewFeature {

	@Test
	void testGetFundraisesValid() throws DAOException, ServiceException {

		FundraiseDAO fundraiseDao = new FundraiseDAO();
		FundraiseService fundraiseService = new FundraiseService();

		try {

			assertTrue(fundraiseService.createFundraise(new Fundraise("Soffan", "soffan2906@gmail.com", "9092500612",
					"Medical",
					"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais",
					"Help this patient",
					"As I lay in the hospital bed, surrounded by white walls and medical equipment, a mix of emotions overwhelmed me. Diagnosed with a serious condition after experiencing fatigue and headaches, I faced a challenging journey. The care from dedicated medical professionals, support from family and friends, and moments of joy brought comfort. Each day, I found strength in hope and gratitude, cherishing life's small joys. The hospital became a sanctuary of healing and taught me resilience. Though uncertain, I embraced the path to recovery with courage. This life-altering experience taught me to value health, cherish relationships, and find strength in adversity.",
					150000)));

			List<Fundraise> fundraises = fundraiseDao.viewFundraises();

			assertNotNull(fundraises);

			for (Fundraise p : fundraises) {
				System.out.println(p.toString());
			}

			System.out.println("Successfully Viewed");
		} catch (DAOException | ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testGetFundraisesInValid() {
		FundraiseService fundraiseService = new FundraiseService();

		try {

			List<Fundraise> fundraises = fundraiseService.viewFundraisesServices();

			assertFalse(fundraises == null);

		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println("Fundraise is not null So failed");
		}
	}

}

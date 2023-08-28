package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.Fundraise;
import com.fssa.pin.model.User;
import com.fssa.pin.service.FundraiseService;
import com.fssa.pin.service.exception.ServiceException;

class TestFundraiseViewFeature {
	@Test
	void testviewFundraisesValid() {
 
		FundraiseService fundraiseservice = new FundraiseService();

		try {

			List<Fundraise> fundraises = fundraiseservice.viewFundraisesServices();

			assertNotNull(fundraises);

			for (Fundraise p : fundraises) {
				System.out.println(p.toString());
			}

			System.out.println("Successfully Viewed");
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testViewFundraisesInValid() {
		FundraiseService fundraiseService = new FundraiseService();

		try {

			List<Fundraise> fundraises = fundraiseService.viewFundraisesServices();
			assertFalse(fundraises.isEmpty());

		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}

}

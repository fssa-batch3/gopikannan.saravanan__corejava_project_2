package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.pin.service.FundraiseService;
import com.fssa.pin.service.exception.ServiceException;

class TestFundraiseDeleteFeature {
	@Test

	void deleteFundraiseSuccess() {
		
		FundraiseService fundraiseservice = new FundraiseService();
		try {

			int fundraiseId = fundraiseservice.fundraiseGetFundraiseId();

			assertTrue(fundraiseservice.fundraiseDelete(fundraiseId));
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Test

	void deleteFundraiseFailed() {
		FundraiseService fundraiseservice = new FundraiseService();
		try {
			assertFalse(fundraiseservice.fundraiseDelete(-1));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

	}

}

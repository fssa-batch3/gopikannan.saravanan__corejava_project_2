  package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.Fundraise;
import com.fssa.pin.service.FundraiseService;
import com.fssa.pin.service.exception.ServiceException;

class TestGetFundraiseByIdFeature {
  
  @Test 
  void testGetFundraiseByIdSuccess() {
	  
	
	  FundraiseService fundraiseService = new FundraiseService();
	  
	  try {
		  
		  Fundraise fundraise= fundraiseService.getFundraiseByIdService(490);
		  System.out.println(fundraise);
		  assertNotNull(fundraise);
	  } 
	  catch(ServiceException e) {
		  
		  e.printStackTrace();
	  }
	  
	  }
  }
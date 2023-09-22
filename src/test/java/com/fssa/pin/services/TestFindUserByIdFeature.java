package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.User;
import com.fssa.pin.service.UserService;
import com.fssa.pin.service.exception.ServiceException;

class TestFindUserByIdFeature {
	 @Test 
	  void testFindUserByIdSuccess() {
		  
		
		  UserService userService = new UserService();
		  
		  
		  
		  try {
			  
			  User user= userService.findUserByIdService(1);
			  System.out.println(user);
			  assertNotNull(user);
		  } 
		  catch(ServiceException e) {
			  
			  e.printStackTrace();
			  fail();
		  }
		  
		  }

}

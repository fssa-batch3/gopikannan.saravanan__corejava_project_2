package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.*;
import com.fssa.pin.service.*;
import com.fssa.pin.service.exception.ServiceException;

 class TestLoginFeature {
 
	@Test
	 void loginSuccess() {
		UserService userService = new UserService();

		User user1 = new User("gopikannan2906@gmail.com",  "Wow@2002");
		try {
			
			assertTrue(userService.loginUser(user1));
			throw new ServiceException("Login successfully. Welcome, " + user1.getMail() + "!");
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}
	}  
 
	@Test

	 void loginFailed() {
		UserService userService = new UserService();
		User user1 = new User("vicky2001@gmail.com",  "Vick@2002");
		try {
			assertFalse(userService.loginUser(user1));
			throw new ServiceException("Login Failed.Kindly Register");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	} 
}

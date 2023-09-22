package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.fssa.pin.model.User;
import com.fssa.pin.service.UserService;
import com.fssa.pin.service.exception.ServiceException;

class TestUpdateUserFeature {

//	Success test case for update
	@Test 
	void testUpdateSuccess() {

		UserService userservice = new UserService();

		User user1 = new User("gopikannan2906@gmail.com", "Gopikannan", "Wow@2002", "9092500612", 1234567890,
				"ABCD0123456", "GOPI KANNAN");
		user1.setProfilePic("https://ca.slack-edge.com/T032648LE-U041NKBPV4N-27e46ea9ea9e-512");
		try {
			assertTrue(userservice.updateUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}

	} 
	
//	Fail test case for update  

	@Test
	void testUpdateFail() {

		UserService userservice = new UserService();

		User user1 = new User("vivky@2002", "VickyKannan", "Kon@2002", "9028848999", 1234567890, "ABCD0123456", "VIGNESH");
		try {
			assertFalse(userservice.updateUser(user1));
		} catch (ServiceException e) {
			
			System.out.println(e);

		}

	}

}

package pin.services.userservice;

import static org.junit.jupiter.api.Assertions.assertFalse; 
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pin.model.User;
import pin.service.UserService;
import pin.service.exception.ServiceException;

class TestUpdateUserFeature {

//	Success test case for update
	@Test
	void testUpdateSuccess() {

		UserService userservice = new UserService();

		User user1 = new User("soffan2906@gmail.com", "Soffan", "Wow@2002", "9092500612", 1234567890,
				"ABCD0123456", "SOFFAN KANNAN");
		try {
			assertTrue(userservice.updateUser(user1));
		} catch (ServiceException e) {
			
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

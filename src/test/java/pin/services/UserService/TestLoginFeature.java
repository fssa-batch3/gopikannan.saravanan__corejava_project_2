package pin.services.UserService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pin.service.*;
import pin.service.exception.ServiceException;
import pin.model.*;

public class TestLoginFeature {

	@Test

	public void loginSuccess() {
		UserService userService = new UserService();

		User user1 = new User("soffan2906@gmail.com",  "Wow@2002");
		try {
			
			assertTrue(userService.loginUser(user1));
			throw new ServiceException("Login successfully. Welcome, " + user1.getMail() + "!");
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}
	} 
 
	@Test

	public void loginFailed() {
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

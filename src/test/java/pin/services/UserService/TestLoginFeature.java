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

		User user1 = new User("soffan2906@gmail.com", "Soffan", "Wow@2002", "9092500612");
		try {
			System.out.println("Login successfully. Welcome, " + user1.getMail() + "!");
			assertTrue(userService.loginUser(user1));
		} catch (ServiceException e) {

			e.printStackTrace();
		}
	}
 
	@Test

	public void loginFailed() {
		UserService userService = new UserService();
		User user1 = new User("vicky2001@gmail.com", "Vicky", "Vick@2002", "9092500612");
		try {
			assertFalse(userService.loginUser(user1));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}
}

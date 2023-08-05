package pin.service;

import pin.model.User;
import pin.service.exception.ServiceException;

import java.sql.SQLException;

import pin.dao.UserDAO;
import pin.dao.exceptions.DAOException;
import pin.validation.UserValidator;
import pin.validation.exceptions.InvalidUserException;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {

			UserValidator.validateUser(user);
			if (userDAO.isEmailAlreadyRegistered(user.getMail())) {
				throw new DAOException("Email already exists");
			}
			if (userDAO.create(user)) {
				System.out.println(user.getUsername() + " Successfully Register");
				return true;
			} else {
				System.out.println("Registration was not Successful");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

//	Login service logic code

	public boolean loginUser(User user) throws ServiceException {
		try {

			UserValidator.validateEmail(user.getMail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.loginUser(user) && (userDAO.getUserPasswordFromDb().equals(user.getPassword()))) {
				return true; // Return true for successful login.
			}
		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
		return false;
	}

//	update user service logic
	public boolean updateUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUpdateUser(user);

			if (userDAO.updateUser(user)) {
				throw new DAOException(user.getUsername() + " successfully updated");

			} else {
				System.out.println("Update was not successful");
				return false;
			}

		} catch (DAOException | InvalidUserException | SQLException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

}
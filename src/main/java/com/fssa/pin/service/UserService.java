package com.fssa.pin.service;

import java.sql.SQLException;

import com.fssa.pin.dao.UserDAO;
import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.User;
import com.fssa.pin.service.exception.ServiceException;
import com.fssa.pin.validation.UserValidator;
import com.fssa.pin.validation.exceptions.InvalidUserException;
  
public class UserService {

	public boolean registerUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();
 
		try {

			UserValidator.validateUser(user);
			if (userDAO.isEmailAlreadyRegistered(user.getMail())) {
				throw new DAOException("Email already exists");
			}
			if (userDAO.createUser(user)) {
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

//	delete user service logic
	public boolean deleteUser(String email) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateEmail(email);
			return userDAO.deleteUser(email);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}
}
package pin.service;

import java.util.List;

import pin.dao.FundraiseDAO;

import pin.dao.exceptions.DAOException;
import pin.model.Fundraise;
import pin.model.User;
import pin.service.exception.ServiceException;
import pin.validation.FundraiseValidation;
import pin.validation.exceptions.InvalidFundraiseException;
import pin.validation.exceptions.InvalidUserException;

public class FundraiseService {

	public boolean createFundraise(Fundraise fundraise) throws ServiceException {

		FundraiseDAO fundraiseDAO = new FundraiseDAO();

		try {

			FundraiseValidation.validateFundraise(fundraise);

			if (fundraiseDAO.createFundraise(fundraise)) {
				return true;

			} else {

				return false;
			}

		} catch (DAOException | InvalidFundraiseException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	public List<Fundraise> viewFundraisesServices() throws ServiceException {
		FundraiseDAO fundraiseDAO = new FundraiseDAO();

		try {
			return fundraiseDAO.viewFundraises();

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	
//	public boolean updateUser(User user) throws DAOException {
//		try {
//			// Get connection
//			Connection connection = getConnection();
//
//			// Prepare SQL statement
//			String updateQuery = "UPDATE user SET username = ?, firstname = ?, lastname = ?, gender = ?, password = ?, nationality = ?, dob = ?, profile_image = ?, age = ?, mobile_number = ? WHERE email = ?";
//			PreparedStatement statement = connection.prepareStatement(updateQuery);
//			statement.setString(1, user.getUsername());
//			statement.setString(2, user.getFirstName());
//			statement.setString(3, user.getLastName());
//			statement.setString(4, user.getGender());
//			statement.setString(5, user.getPassword());
//			statement.setString(6, user.getNationality());
//			statement.setDate(7, user.getDob());
//			statement.setString(8, user.getProfile_image());
//			statement.setInt(9, user.getAge());
//			statement.setLong(10, user.getMobile_number());
//			statement.setString(11, user.getEmail());
//
//			// Execute the query
//			int rows = statement.executeUpdate();
//
//			// Return successful or not
//			return (rows == 1);
//		} catch (SQLException e) {
//			throw new DAOException(e);
//		}
//	}
	
	

}
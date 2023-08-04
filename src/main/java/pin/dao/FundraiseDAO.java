package pin.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import pin.dao.exceptions.DAOException;
import pin.model.Fundraise;

public class FundraiseDAO {

//	Create fundraise
	public boolean createFundraise(Fundraise fundraise) throws DAOException {

		if (fundraise == null) {
			System.out.println("Fundraise Must not be null");
			return false;
		}

		String query = "INSERT INTO fundraisedetails (name, emailid, mobileno, cause, image_url, title, story, amount_expected) VALUES (?, ?, ?, ?, ?, ?, ? ,?);";

		try (Connection connection = UserDAO.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, fundraise.getName());
			ps.setString(2, fundraise.getEmail());
			ps.setString(3, fundraise.getPhno());
			ps.setString(4, fundraise.getCause());
			ps.setString(5, fundraise.getCover_pic());
			ps.setString(6, fundraise.getTitle());
			ps.setString(7, fundraise.getStory());
			ps.setInt(8, fundraise.getExpected_amount());

			int rows = ps.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error in inserting fundraise in table");
		}

	}

	public List<Fundraise> viewFundraises() throws DAOException {
		List<Fundraise> fundraises = new ArrayList<>();

		String query = "SELECT name, emailid, mobileno, cause, image_url, title, story, amount_expected FROM fundraisedetails;";

		try (Connection connection = UserDAO.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("emailid");
				String phno = rs.getString("mobileno");
				String cause = rs.getString("cause");
				String coverPic = rs.getString("image_url");
				String title = rs.getString("title");
				String story = rs.getString("story");
				int expectedAmount = rs.getInt("amount_expected");

				Fundraise fundraise = new Fundraise(name, email, phno, cause, coverPic, title, story, expectedAmount);
				fundraises.add(fundraise);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error reading fundraises from the table");
		}
		return fundraises;
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

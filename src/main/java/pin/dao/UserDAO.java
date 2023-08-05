package pin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pin.model.User;

import pin.dao.exceptions.DAOException;

public class UserDAO {

	public static Connection getConnection() throws SQLException {
		// Connecting to DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin", "root", "123456");
		return con;
	}

	// Add new user to DB - register
	public boolean create(User user) throws DAOException {
		if (user == null) {
			System.out.println("User Must not be null");
			return false;
		}

		String query = "INSERT INTO userdata (user_name, user_mail, user_pwd, mobileno) VALUES (?, ?, ?, ?);";
		try (PreparedStatement pst = getConnection().prepareStatement(query);) {
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getMail());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getMobileno());

			int rows = pst.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException("Sql Exception while creating user ");
		}
	}

//  login user

//	public boolean deleteUser(String email) throws DAOException {
//
//		String DELETEQUERY = "DELETE FROM userdata where user_mail=?";
//
//		int row = 0;
//
//		try (PreparedStatement std = getConnection().prepareStatement(DELETEQUERY)) {
//
//			std.setString(1, email);
//
//			row = std.executeUpdate();
//
//			System.out.println("Deleted row: " + row);
//
//		} catch (SQLException e) {
//			throw new DAOException("Error in deleting the user");
//		}
//
//		return row > 0;
//
//	}

//	update user

	public boolean updateUser(User user) throws SQLException, DAOException {
		final String query = "UPDATE userdata SET user_name = ?, user_pwd = ?, mobileno = ?, user_account_no = ?, user_ifsc = ?, user_account_holder = ? WHERE user_mail = ?;";

		try (PreparedStatement pst = getConnection().prepareStatement(query)) {

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getMobileno());
			pst.setInt(4, user.getAccNo());
			pst.setString(5, user.getIfscNo());
			pst.setString(6, user.getAccName());
			pst.setString(7, user.getMail());
			int rows = pst.executeUpdate();
			if (rows == 0) {
				throw new DAOException("User with email: " + user.getMail() + " not found in the database.");
			}
			return (rows==1);
			
		} catch (SQLException e) {
			
			throw new DAOException("Error updating user in the database");
		}
		
	} 

	// check email is already exist
	public boolean isEmailAlreadyRegistered(String email) throws DAOException {
		final String query = "SELECT user_mail FROM userdata WHERE user_mail = ?";

		try (PreparedStatement pstmt = getConnection().prepareStatement(query)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the email exists
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

	private String userPasswordFromDb;

	public String getUserPasswordFromDb() {
		return userPasswordFromDb;
	}

	public void setUserPasswordFromDb(String userPasswordFromDb) {
		this.userPasswordFromDb = userPasswordFromDb;
	}

	// login user

	public boolean loginUser(User user) throws DAOException {
		String email = user.getMail();

		String query = "SELECT user_mail,user_pwd FROM userdata WHERE user_mail = ?;";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, email);
			try (ResultSet rs = pst.executeQuery()) {

				// User found, login successful else
				if (rs.next()) {
					String passwordfromDb = rs.getString("user_pwd");
					setUserPasswordFromDb(passwordfromDb);
					return true;
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error in loggin in");
		}
		return false;
	} 

}

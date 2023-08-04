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
		try (Connection connection = getConnection(); PreparedStatement pst = connection.prepareStatement(query);) {
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

	public boolean deleteUser(String email) throws DAOException {

		String DELETEQUERY = "DELETE FROM userdata where user_mail=?";

		int row = 0;

		try (PreparedStatement std = getConnection().prepareStatement(DELETEQUERY)) {

			std.setString(1, email);

			row = std.executeUpdate();

			System.out.println("Deleted row: " + row);

		} catch (SQLException e) {
			throw new DAOException("Error in deleting the user");
		}

		return row > 0;

	}

	// login user

	public boolean loginUser(User user) throws DAOException {
		String email = user.getMail();
		String password = user.getPassword();

		String query = "SELECT user_mail,user_pwd FROM userdata WHERE user_mail = ? AND user_pwd = ?";
		try (Connection connection = getConnection(); PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, email);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery()) {

				// User found, login successful else
				return rs.next();

			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// check email is already exist
	public boolean isEmailAlreadyRegistered(String email) throws DAOException {
		final String SELECTQUERY = "SELECT user_mail FROM userdata WHERE user_mail = ?";

		try (PreparedStatement pstmt = getConnection().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the email exists
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

	public boolean isLogin(User user) throws DAOException {

		final String SELECTQUERY = "SELECT user_mail, user_pwd FROM userdata WHERE user_mail = ? AND user_pwd = ?";

		try (PreparedStatement pstmt = getConnection().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, user.getMail());
			pstmt.setString(2, user.getPassword());

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the user email and password exists
			}

		} catch (SQLException e) {
			throw new DAOException("Error in loggin in");
		}

	}

}

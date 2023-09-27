package com.fssa.pin.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.User;


/**
 * This class provides methods to interact with the database related to User operations.
 */
public class UserDAO {


	/**
     * Creates a new user in the database.
     *
     * @param user The User object containing user information.
     * @return Returns true if the user creation is successful, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean createUser(User user) throws DAOException {

		String query = "INSERT INTO userdata (user_name, user_mail, user_pwd, mobileno) VALUES (?, ?, ?, ?)";
		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query);) {
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


	  /**
     * Updates an existing user's information in the database.
     *
     * @param user The User object containing updated user information.
     * @return Returns true if the update is successful, otherwise false.
     * @throws SQLException If there is an issue with the SQL operation.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean updateUser(User user) throws SQLException, DAOException {
		final String query = "UPDATE userdata SET user_name = ?, user_pwd = ?, mobileno = ?, user_account_no = ?, user_ifsc = ?, user_account_holder = ?, profile_pic = ? WHERE user_mail = ?";

		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getMobileno());
			pst.setLong(4, user.getAccNo());
			pst.setString(5, user.getIfscNo());
			pst.setString(6, user.getAccName());
			
			pst.setString(7, user.getProfilePic());
			pst.setString(8, user.getMail());
			int rows = pst.executeUpdate();
			if (rows == 0) {
				throw new DAOException("User with email: " + user.getMail() + " not found in the database.");
			}
			return (rows == 1);

		} catch (SQLException e) {

			throw new DAOException("Error updating user in the database",e);
		}

	}




	 /**
     * Deletes a user from the database based on their email.
     *
     * @param email The email of the user to be deleted.
     * @return Returns true if the deletion is successful, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean deleteUser(String email) throws DAOException {
		String deleteQuery = "DELETE FROM userdata where user_mail=?";
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(deleteQuery)) {

			ps.setString(1, email);
			int rows = ps.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException("Error in delete user ", e);
		}

	}

	 /**
     * Checks if an email is already registered in the system.
     *
     * @param email The email to be checked.
     * @return Returns true if the email is already registered, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean isEmailAlreadyRegistered(String email) throws DAOException {
		final String query = "SELECT user_mail FROM userdata WHERE user_mail = ?";

		try (PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(query)) {

			pstmt.setString(1, email); 

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the email exists
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

	private String userPasswordFromDb;

	 /**
     * Gets the user's password from the database.
     *
     * @return The user's password from the database.
     */
	public String getUserPasswordFromDb() {
		return userPasswordFromDb;
	}

	/**
     * Sets the user's password in the database.
     *
     * @param userPasswordFromDb The user's password to be set in the database.
     */
	public void setUserPasswordFromDb(String userPasswordFromDb) {
		this.userPasswordFromDb = userPasswordFromDb;
	}
	 /**
     * Tries to log in a user by checking their credentials in the database.
     *
     * @param user The user's login details.
     * @return Returns true if the login is successful, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean loginUser(User user) throws DAOException {
		String email = user.getMail();

		String query = "SELECT user_mail,user_pwd FROM userdata WHERE user_mail = ?;";
		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {
			pst.setString(1, email);
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					String passwordfromDb = rs.getString("user_pwd");
					setUserPasswordFromDb(passwordfromDb);
					return true;
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error in login");
		}
		return false;
	}
	
	
	public User findUserByEmail(String email) throws DAOException {
	    final String query = "SELECT user_name, user_mail, user_pwd, mobileno,user_account_no, user_ifsc, user_account_holder,userid,profile_pic FROM userdata WHERE user_mail = ?";

	    try (PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(query)) {
	        pstmt.setString(1, email);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                User user = new User();
	                user.setUsername(rs.getString("user_name"));
	                user.setMail(rs.getString("user_mail"));
	                user.setPassword(rs.getString("user_pwd"));
	                user.setMobileno(rs.getString("mobileno"));
	                user.setAccNo(rs.getLong("user_account_no"));
	                user.setIfscNo(rs.getString("user_ifsc"));
	                user.setAccName(rs.getString("user_account_holder"));
	                user.setUserid(rs.getInt("userid"));
	                user.setProfilePic(rs.getString("profile_pic"));
	                return user;
	            } else {
	                return null; // Return null if the email does not exist
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error in getting the user details by email", e);
	    }
	}
	
	
	public User findUserById(int email) throws DAOException {
	    final String query = "SELECT user_name, user_mail, user_pwd, mobileno,user_account_no, user_ifsc, user_account_holder,userid FROM userdata WHERE userid = ?";

	    try (PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(query)) {
	        pstmt.setInt(1, email);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                User user = new User();
	                user.setUsername(rs.getString("user_name"));
	                user.setMail(rs.getString("user_mail"));
	                user.setPassword(rs.getString("user_pwd"));
	                user.setMobileno(rs.getString("mobileno"));
	                user.setAccNo(rs.getLong("user_account_no"));
	                user.setIfscNo(rs.getString("user_ifsc"));
	                user.setAccName(rs.getString("user_account_holder"));
	                user.setUserid(rs.getInt("userid"));
	                return user;
	            } else {
	                return null; // Return null if the email does not exist
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error in getting the user details by id", e);
	    }
	}

 
}

package com.fssa.pin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Fundraise;

/**
 * Provides database operations for managing fundraising details.
 */
public class FundraiseDAO {


	 /**
     * Creates a new fundraise record in the database.
     *
     * @param fundraise The Fundraise object containing details to be added.
     * @return True if the creation was successful, otherwise false.
     * @throws DAOException If an error occurs during database interaction.
     */
	public boolean createFundraise(Fundraise fundraise) throws DAOException {
		
		String query = "INSERT INTO fundraisedetails (cause, image_url, title, story, amount_expected, userid) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query)) {
			ps.setString(1, fundraise.getCause());
			ps.setString(2, fundraise.getCoverPic());
			ps.setString(3, fundraise.getTitle());
			ps.setString(4, fundraise.getStory());
			ps.setInt(5, fundraise.getExpectedAmount());
			ps.setInt(6, fundraise.getUser().getUserid());

			int rows = ps.executeUpdate();

			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException("Error in inserting fundraise in table", e);
		}
	}  
 
	
	  /**
     * Retrieves a list of all fundraising records with associated user details.
     *
     * @return List of Fundraise objects containing fundraising details.
     * @throws DAOException If an error occurs during database interaction.
     */
	public List<Fundraise> viewFundraises() throws DAOException {
		List<Fundraise> fundraises = new ArrayList<>();

		String query = "SELECT userdata.user_name, userdata.user_mail, userdata.mobileno, userdata.user_account_no, userdata.user_ifsc, userdata.user_account_holder, " +
	               "fundraisedetails.cause, fundraisedetails.image_url, fundraisedetails.title, fundraisedetails.story, fundraisedetails.amount_expected, fundraisedetails.userid " +
	               "FROM userdata " +
	               "INNER JOIN fundraisedetails ON userdata.userid = fundraisedetails.userid";

		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				
				
				String name = rs.getString("user_name");
				String email = rs.getString("user_mail");
				String phno = rs.getString("mobileno");
				int accNo = rs.getInt("user_account_no");
				String ifscNo = rs.getString("user_ifsc");
				String accName = rs.getString("user_account_holder");
				String cause = rs.getString("cause");
				String coverPic = rs.getString("image_url");
				String title = rs.getString("title");
				String story = rs.getString("story");
				int expectedAmount = rs.getInt("amount_expected");
				
				

				Fundraise fundraise = new Fundraise();
				
				
				fundraise.setName(name);
				fundraise.setEmail(email);
				fundraise.setPhno(phno);
				fundraise.setAccNo(accNo);
				fundraise.setIfscNo(ifscNo);
				fundraise.setAccName(accName);
				fundraise.setCause(cause);
				fundraise.setCoverPic(coverPic);
				fundraise.setTitle(title);
				fundraise.setStory(story);
				fundraise.setExpectedAmount(expectedAmount);
				fundraises.add(fundraise);
			}

		} catch (SQLException e) {
			throw new DAOException("Error reading fundraises from the table");
		}
		return fundraises;
	}


	 /**
     * Updates an existing fundraising record in the database.
     *
     * @param fundraise The Fundraise object containing updated details.
     * @return True if the update was successful, otherwise false.
     * @throws DAOException If an error occurs during database interaction.
     */
	public boolean updateFundraise(Fundraise fundraise) throws DAOException {
	    try {
	        String query = "UPDATE fundraisedetails " +
	                       "SET cause = ?, image_url = ?, title = ?, story = ?, amount_expected = ? " +
	                       "WHERE fundraise_id = ?";

	        try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query)) {
	            ps.setString(1, fundraise.getCause());
	            ps.setString(2, fundraise.getCoverPic());
	            ps.setString(3, fundraise.getTitle());
	            ps.setString(4, fundraise.getStory());
	            ps.setInt(5, fundraise.getExpectedAmount());
	            ps.setInt(6, fundraise.getFundraiseid());

	            int rows = ps.executeUpdate();
	            return (rows == 1);
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error updating fundraise in the table");
	    }
	}
 

	/**
     * Deletes a fundraising record from the database.
     *
     * @param fundraiseId The ID of the fundraising record to be deleted.
     * @return True if the deletion was successful, otherwise false.
     * @throws DAOException If an error occurs during database interaction.
     */
	public boolean deleteFundraise(int fundraiseId) throws DAOException {
		String deleteQuery = "DELETE from fundraisedetails WHERE fundraise_id=?";
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(deleteQuery)) {

			ps.setInt(1, fundraiseId);
			int rows = ps.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException("Error in delete product method", e);
		}

	}
	
	
	  /**
     * Retrieves the latest fundraise ID from the database.
     *
     * @return The latest fundraise ID.
     * @throws DAOException If an error occurs during database interaction.
     */
  
	public int getFundraiseId() throws DAOException {
		String query = "SELECT MAX(fundraise_id) FROM fundraisedetails";

		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				throw new DAOException("Error getting latest fundraise id");
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting latest fundraise id", e);
		}
	}
  
}

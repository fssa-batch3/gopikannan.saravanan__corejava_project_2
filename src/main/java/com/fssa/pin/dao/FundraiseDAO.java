package com.fssa.pin.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Fundraise;
import com.fssa.pin.model.User;

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
		
		String query = "INSERT INTO fundraisedetails (cause, image_url, title, story, amount_expected, userid, document) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query)) {
			ps.setString(1, fundraise.getCause());
			ps.setString(2, fundraise.getCoverPic());
			ps.setString(3, fundraise.getTitle());
			ps.setString(4, fundraise.getStory());
			ps.setInt(5, fundraise.getExpectedAmount());
			ps.setInt(6, fundraise.getUser().getUserid());
			ps.setString(7,fundraise.getDocument());

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

		String query = "SELECT userdata.userid, userdata.user_name, userdata.user_mail, userdata.mobileno, userdata.user_account_no, userdata.user_ifsc, userdata.user_account_holder, " +
	               "fundraisedetails.cause, fundraisedetails.image_url, fundraisedetails.title, fundraisedetails.story, fundraisedetails.document, fundraisedetails.amount_expected,  fundraisedetails.amount_received,  fundraisedetails.fundraise_id, fundraisedetails.userid " +
	               "FROM userdata " +
	               "INNER JOIN fundraisedetails ON userdata.userid = fundraisedetails.userid";

		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				
				int userId = rs.getInt("userid");
				String name = rs.getString("user_name");
				String email = rs.getString("user_mail");
				String phno = rs.getString("mobileno");
				long accNo = rs.getLong("user_account_no");
				String ifscNo = rs.getString("user_ifsc");
				String accName = rs.getString("user_account_holder");
				String cause = rs.getString("cause");
				String coverPic = rs.getString("image_url");
				String title = rs.getString("title");
				String story = rs.getString("story");
				String document = rs.getString("document");
				int expectedAmount = rs.getInt("amount_expected");
				int amountReceived = rs.getInt("amount_received");
				int fundraiseId = rs.getInt("fundraise_id");
				
				Fundraise fundraise = new Fundraise();
				
				
				User user = new User();
				user.setUsername(name);
				user.setMail(email);
				user.setMobileno(phno);
				user.setAccNo(accNo);
				user.setIfscNo(ifscNo);
				user.setAccName(accName);
				user.setUserid(userId);
				
				
				fundraise.setUser(user);
				fundraise.setCause(cause);
				fundraise.setCoverPic(coverPic);
				fundraise.setTitle(title);
				fundraise.setStory(story);
				fundraise.setDocument(document);
				fundraise.setExpectedAmount(expectedAmount);
				fundraise.setAmountReceived(amountReceived);
				fundraise.setFundraiseid(fundraiseId);
				fundraises.add(fundraise);
			}

		} catch (SQLException e) {
			throw new DAOException("Error reading fundraises from the table",e);
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
	                       "SET cause = ?, image_url = ?, title = ?, story = ?, amount_expected = ?, document = ? " +
	                       "WHERE fundraise_id = ?";

	        try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query)) {
	            ps.setString(1, fundraise.getCause());
	            ps.setString(2, fundraise.getCoverPic());
	            ps.setString(3, fundraise.getTitle());
	            ps.setString(4, fundraise.getStory());
	            ps.setInt(5, fundraise.getExpectedAmount());
	            ps.setString(6, fundraise.getDocument());
	            ps.setInt(7, fundraise.getFundraiseid());

	            int rows = ps.executeUpdate();
	            return (rows == 1);
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error updating fundraise in the table");
	    }
	}
 

	/**
     * Deletes a fundRaising record from the database.
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
	public Fundraise getFundraiseById(int fundraiseId) throws DAOException {
	    String query = "SELECT * FROM fundraisedetails WHERE fundraise_id = ?";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {
	        ps.setInt(1, fundraiseId);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                Fundraise fundraise = new Fundraise();
	              
	                fundraise.setCause(rs.getString("cause"));
	                fundraise.setCoverPic(rs.getString("image_url"));
	                fundraise.setTitle(rs.getString("title"));
	                fundraise.setStory(rs.getString("story"));
	                fundraise.setExpectedAmount(rs.getInt("amount_expected"));
	                fundraise.setFundraiseid(rs.getInt("fundraise_id"));
	                fundraise.setFundraiseUserId(rs.getInt("userid"));
	                fundraise.setDocument(rs.getString("document"));

	                return fundraise;
	            } else {
	                throw new DAOException("Fundraise with ID " + fundraiseId + " not found");
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error getting fundraise by ID", e);
	    }
	}

}

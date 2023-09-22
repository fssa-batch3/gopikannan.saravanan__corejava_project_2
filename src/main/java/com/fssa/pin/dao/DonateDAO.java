package com.fssa.pin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Donate;
import com.fssa.pin.model.Fundraise;
import com.fssa.pin.model.User;

public class DonateDAO {

	/***
	 * Creates a new donation record in the database.
	 * 
	 * @param donate The Donate object containing details of donations to be added.
	 * @return True if the creation was successful, otherwise false.
	 * @throws DAOException If an error occurs during database interaction.
	 */
	public boolean createDonation(Donate donate) throws DAOException {
		final String query = "INSERT INTO donations (contribution,userid,fundraise_id) VALUES (?,?,?)";
		final String updateFundraise = "UPDATE fundraisedetails SET amount_received = amount_received + ? WHERE fundraise_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query);
				PreparedStatement pstUpdate = connection.prepareStatement(updateFundraise)) {
			connection.setAutoCommit(false);

			pst.setInt(1, donate.getDonaterContribution());
			pst.setInt(2, donate.getUser().getUserid());
			pst.setInt(3, donate.getFundraise().getFundraiseid());

			pstUpdate.setInt(1, donate.getDonaterContribution());
			pstUpdate.setInt(2, donate.getFundraise().getFundraiseid());

			int donationRows = pst.executeUpdate();
			int fundraiseRows = pstUpdate.executeUpdate();

			if (donationRows == 1 && fundraiseRows == 1) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
				return false;
			}
		} catch (SQLException e) {
			throw new DAOException("Sql Exception while creating user ");
		}

	}

	/***
	 * Retrieves a list of all donations records.
	 * @return List of donation objects containing donation details.
	 * @throws DAOException If an error occurs during database interaction.
	 *
	 */
	public List<Donate> viewAllDonations() throws DAOException {
		List<Donate> donations = new ArrayList<>();
		final	String query = "SELECT "
		        + "u1.user_name AS donaterName, "
		        + "u1.user_mail AS donaterEmail, "
		        + "u1.user_account_no AS donaterAccNo, "
		        + "u1.user_ifsc AS donaterAccIfscNo, "
		        + "u1.user_account_holder AS donaterAccHolderName, "
		        + "d.contribution, "
		        + "d.donationId, "
		        + "d.donation_date, "
		        + "d.userid AS donaterUserId, "
		        + "u2.user_name AS fundraiserName, "
		        + "u2.user_mail AS fundrasierEmail, "
		        + "f.cause, "
		        + "f.image_url AS fundraiserImageUrl, "  
	            + "f.title AS fundraiserTitle, "
	            + "f.amount_expected AS fundraiserAmountExpected, " 
	            + "f.amount_received AS fundraiserAmountReceived, " 
	            + "f.fundraise_id AS fundraiserID, " 	
	            + "f.userid AS fundraiserUserID, "
		        + "u2.user_account_no AS fundraiserAccNo, "
		        + "u2.user_ifsc AS fundraiserAccIfscNo, "
		        + "u2.user_account_holder AS fundraiserAccHolderName "
		        + "FROM donations d "
		        + "INNER JOIN userdata u1 ON d.userid = u1.userid "
		        + "INNER JOIN fundraisedetails f ON d.fundraise_id = f.fundraise_id "
		        + "INNER JOIN userdata u2 ON f.userid = u2.userid";
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {
		
			while (rs.next()) {
				
				
				
				
				  String donaterName = rs.getString("donaterName");
		            String donaterEmail = rs.getString("donaterEmail");
		            int donaterAccNo = rs.getInt("donaterAccNo");
		            String donaterAccIfscNo = rs.getString("donaterAccIfscNo");
		            String donaterAccHolderName = rs.getString("donaterAccHolderName");
		            int contribution = rs.getInt("contribution");
		            String fundraiserName = rs.getString("fundraiserName");
		            String fundraiserEmail = rs.getString("fundrasierEmail");
		            String cause = rs.getString("cause");
		            int fundraiserAccNo = rs.getInt("fundraiserAccNo");
		            String fundraiserAccIfscNo = rs.getString("fundraiserAccIfscNo");
		            String fundraiserAccHolderName =      rs.getString("fundraiserAccHolderName");
		           
		            Donate donate = new Donate();
		            
		            
		            User fundraiserUser = new User();
		           
		            fundraiserUser.setAccName(fundraiserAccHolderName);
		            fundraiserUser.setAccNo(fundraiserAccNo);
		            fundraiserUser.setIfscNo(fundraiserAccIfscNo);
		            fundraiserUser.setMail(fundraiserEmail);
		            fundraiserUser.setUsername(fundraiserName);
		            fundraiserUser.setUserid(rs.getInt("fundraiserUserID"));
		            
		            
		            Fundraise fundraise = new Fundraise();
				    fundraise.setUser(fundraiserUser);
				    fundraise.setCause(cause);
				    fundraise.setCoverPic(rs.getString("fundraiserImageUrl"));
				    fundraise.setTitle(rs.getString("fundraiserTitle"));
				    fundraise.setExpectedAmount(rs.getInt("fundraiserAmountExpected"));
				    fundraise.setAmountReceived(rs.getInt("fundraiserAmountReceived"));
				    fundraise.setFundraiseid(rs.getInt("fundraiserID"));
		            
				    
				    User donateUser = new User();
				    donateUser.setAccName(donaterAccHolderName);
				    donateUser.setAccNo(donaterAccNo);
				    donateUser.setIfscNo(donaterAccIfscNo);
				    donateUser.setMail(donaterEmail);
				    donateUser.setUsername(donaterName);
				    donateUser.setUserid(rs.getInt("donaterUserId"));
		            
		            
		            donate.setDonaterContribution(contribution);
		            donate.setDonaterId(rs.getInt("donationId"));
		            donate.setDonationDate(rs.getString("donation_date"));
		            donate.setUser(donateUser);
		            donate.setFundraise(fundraise);
		            donations.add(donate);
				 
				
			}
		}
		catch(SQLException e) {
			throw new DAOException("Error reading donations from the table",e);
		}
		
		 return donations;
	}

}

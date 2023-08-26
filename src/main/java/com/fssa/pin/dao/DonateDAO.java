package com.fssa.pin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Donate;

public class DonateDAO {

	/***
	 * Creates a new donation record in the database.
	 * @param donate The Donate object containing details of donations to be added.
	 * @return True if the creation was successful, otherwise false.
	 * @throws DAOException If an error occurs during database interaction.
	 */
	public boolean createDonation(Donate donate) throws DAOException {
		final String query = "INSERT INTO donations (contribution,userid,fundraise_id) VALUES (?,?,?)";

		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {
			pst.setInt(1, donate.getDonaterContribution());
			pst.setInt(2, donate.getUser().getUserid());
			pst.setInt(3, donate.getFundraise().getFundraiseid());
			int rows = pst.executeUpdate();

			return (rows == 1);
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
		        + "u2.user_name AS fundraiserName, "
		        + "u2.user_mail AS fundrasierEmail, "
		        + "f.cause, "
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
		            
		            donate.setDonaterName(donaterName);
		            donate.setDonaterEmail(donaterEmail);
		            donate.setFromAccNo(donaterAccNo);
		            donate.setFromAccIfscNo(donaterAccIfscNo);
		            donate.setFromAccHolderName(donaterAccHolderName);
		            donate.setDonaterContribution(contribution);
		            donate.setFundraiserName(fundraiserName);
		            donate.setFundrasierEmail(fundraiserEmail);
		            donate.setDonationFor(cause);
		            donate.setToAccNo(fundraiserAccNo);
		            donate.setToAccIfscNo(fundraiserAccIfscNo);
		            donate.setToAccHolderName(fundraiserAccHolderName);
		            
		            donations.add(donate);
				 
				
			}
		}
		catch(SQLException e) {
			throw new DAOException("Error reading donations from the table");
		}
		
		 return donations;
	}
	



}

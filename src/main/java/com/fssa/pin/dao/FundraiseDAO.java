package com.fssa.pin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Fundraise;

public class FundraiseDAO {

//	Create fundraise
//	public boolean createFundraise(Fundraise fundraise) throws DAOException {
//
//		if (fundraise == null) {
//			System.out.println("Fundraise Must not be null");
//			return false;
//		}
//
//		String query = "INSERT INTO fundraisedetails (name, emailid, mobileno, cause, image_url, title, story, amount_expected) VALUES (?, ?, ?, ?, ?, ?, ? ,?);";
//
//		try (Connection connection = UserDAO.getConnection();
//				PreparedStatement ps = connection.prepareStatement(query)) {
//			ps.setString(1, fundraise.getName());
//			ps.setString(2, fundraise.getEmail());
//			ps.setString(3, fundraise.getPhno());
//			ps.setString(4, fundraise.getCause());
//			ps.setString(5, fundraise.getCover_pic());
//			ps.setString(6, fundraise.getTitle());
//			ps.setString(7, fundraise.getStory());
//			ps.setInt(8, fundraise.getExpected_amount());
//
//			int rows = ps.executeUpdate();
//
//			return (rows == 1);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new DAOException("Error in inserting fundraise in table");
//		}
//
//	} 

//	fundraise create method 
	public boolean createFundraise(Fundraise fundraise) throws DAOException {
		 if (fundraise == null || fundraise.getUser() == null) {
			System.out.println("Fundraise must not be null");
			return false;
		}
		String query = "INSERT INTO fundraisedetails (cause, image_url, title, story, amount_expected, userid) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = UserDAO.getConnection().prepareStatement(query)) {
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

//	fundraise view method
	public List<Fundraise> viewFundraises() throws DAOException {
		List<Fundraise> fundraises = new ArrayList<>();

		String query = "SELECT userdata.user_name, userdata.user_mail, userdata.mobileno, userdata.user_account_no, userdata.user_ifsc, userdata.user_account_holder, " +
	               "fundraisedetails.cause, fundraisedetails.image_url, fundraisedetails.title, fundraisedetails.story, fundraisedetails.amount_expected, fundraisedetails.userid " +
	               "FROM userdata " +
	               "INNER JOIN fundraisedetails ON userdata.userid = fundraisedetails.userid";

		try (PreparedStatement ps = UserDAO.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {

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
				int userid = rs.getInt("userid");

				Fundraise fundraise = new Fundraise(name, email, phno, accNo, ifscNo, accName, userid, cause, coverPic,
						title, story, expectedAmount);
				fundraises.add(fundraise);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error reading fundraises from the table");
		}
		return fundraises;
	}

//	update fundraise method
	public boolean updateFundraise(Fundraise fundraise) throws DAOException {
	    try {
	        String query = "UPDATE fundraisedetails " +
	                       "SET cause = ?, image_url = ?, title = ?, story = ?, amount_expected = ? " +
	                       "WHERE fundraise_id = ?";

	        try (PreparedStatement ps = UserDAO.getConnection().prepareStatement(query)) {
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
	        e.printStackTrace();
	        throw new DAOException("Error updating fundraise in the table");
	    }
	}


//	delete fundraise method
	public boolean deleteFundraise(int fundraiseId) throws DAOException {
		String deleteQuery = "DELETE from fundraisedetails WHERE fundraise_id=?";
		try (PreparedStatement ps = UserDAO.getConnection().prepareStatement(deleteQuery)) {

			ps.setInt(1, fundraiseId);
			int rows = ps.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException("Error in delete product method", e);
		}

	}

	public int getLatestFundraiseId() throws DAOException {
		String query = "SELECT MAX(fundraise_id) FROM fundraisedetails";

		try (PreparedStatement ps = UserDAO.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				int latestId = rs.getInt(1);
				return latestId;
			} else {
				throw new DAOException("Error getting latest fundraise id");
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting latest fundraise id", e);
		}
	}

}

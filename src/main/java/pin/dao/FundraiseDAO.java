package pin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import pin.dao.exceptions.DAOException;
import pin.model.*;

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
		if (fundraise == null) {
			System.out.println("Fundraise must not be null");
			return false;
		}

		String query = 
			    "INSERT INTO fundraisedetails (name, emailid, mobileno, user_account_no, user_ifsc, user_account_holder, cause, image_url, title, story, amount_expected, userid) " +
			    "SELECT userdata.user_name, userdata.user_mail, userdata.mobileno, userdata.user_account_no, userdata.user_ifsc, userdata.user_account_holder, ?, ?, ?, ?, ?, ? " +
			    "FROM userdata " +
			    "INNER JOIN fundraisedetails ON fundraisedetails.userid = userdata.userid " +
			    "WHERE userdata.userid = ?";

		try (PreparedStatement ps = UserDAO.getConnection().prepareStatement(query)) {
			ps.setString(1, fundraise.getCause());
			ps.setString(2, fundraise.getCover_pic());
			ps.setString(3, fundraise.getTitle());
			ps.setString(4, fundraise.getStory());
			ps.setInt(5, fundraise.getExpected_amount());
			ps.setInt(6, fundraise.getUserid());
			ps.setInt(7, fundraise.getUserid());

			int rows = ps.executeUpdate();

			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException("Error in inserting fundraise in table", e);
		}
	}

//	fundraise view method
	public List<Fundraise> viewFundraises() throws DAOException {
		List<Fundraise> fundraises = new ArrayList<>();

		String query = "SELECT name, emailid, mobileno, user_account_no, user_ifsc, user_account_holder, cause, image_url, title, story, amount_expected, userid FROM fundraisedetails";

		try (PreparedStatement ps = UserDAO.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("emailid");
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
			String updateQuery = "UPDATE fundraisedetails SET name = ?, emailid = ?, mobileno = ?, user_account_no = ?, user_ifsc = ?, user_account_holder = ?, cause = ?, image_url = ?, title = ?, story = ?, amount_expected = ? WHERE fundraise_id = ?";

			try (PreparedStatement ps = UserDAO.getConnection().prepareStatement(updateQuery)) {
				ps.setString(1, fundraise.getName());
				ps.setString(2, fundraise.getEmail());
				ps.setString(3, fundraise.getPhno());
				ps.setInt(4, fundraise.getAccNo());
				ps.setString(5, fundraise.getIfscNo());
				ps.setString(6, fundraise.getAccName());
				ps.setString(7, fundraise.getCause());
				ps.setString(8, fundraise.getCover_pic());
				ps.setString(9, fundraise.getTitle());
				ps.setString(10, fundraise.getStory());
				ps.setInt(11, fundraise.getExpected_amount());
				ps.setInt(12, fundraise.getFundraiseid());

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

}

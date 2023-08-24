package com.fssa.pin.dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Donate;

public class DonateDAO {

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

//	public List<Donate> viewDonation() throws DAOException {
//		List<Donate> donations = new ArrayList<>();
//		
//		
//	}

}

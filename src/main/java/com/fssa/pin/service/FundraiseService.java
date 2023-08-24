package com.fssa.pin.service;

import java.util.List;

import com.fssa.pin.dao.FundraiseDAO;
import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Fundraise;
import com.fssa.pin.service.exception.ServiceException;
import com.fssa.pin.validation.FundraiseValidation;
import com.fssa.pin.validation.exceptions.InvalidFundraiseException;

/**
 * Manages fundraising related services.
 */
public class FundraiseService {

	/**
	 * Creates a new fundraising campaign.
	 *
	 * @param fundraise The Fundraise object representing the campaign details.
	 * @return True if the campaign is successfully created, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean createFundraise(Fundraise fundraise) throws ServiceException {

		FundraiseDAO fundraiseDAO = new FundraiseDAO();

		try {
			if (!FundraiseValidation.validateFundraise(fundraise)) {
				return false;
			}

			return fundraiseDAO.createFundraise(fundraise);
		} catch (DAOException | InvalidFundraiseException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * Retrieves a list of all fundraising campaigns.
	 *
	 * @return A list of Fundraise objects representing campaigns.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public List<Fundraise> viewFundraisesServices() throws ServiceException {
		FundraiseDAO fundraiseDAO = new FundraiseDAO();

		try {
			return fundraiseDAO.viewFundraises();

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Updates a fundraising campaign.
	 *
	 * @param fundraise The Fundraise object containing updated campaign details.
	 * @return True if the campaign is successfully updated, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean fundraiseUpdate(Fundraise fundraise) throws ServiceException {

		FundraiseDAO fundraiseDAO = new FundraiseDAO();

		try {
			FundraiseValidation.validateFundraise(fundraise);

			if (fundraiseDAO.updateFundraise(fundraise)) {
				return true;
			} else {
				throw new ServiceException("Update Fundrasie was not successfull");
				

			}

		} catch (DAOException | InvalidFundraiseException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * Deletes a fundraising campaign.
	 *
	 * @param fundraiseId The ID of the campaign to be deleted.
	 * @return True if the campaign is successfully deleted, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean fundraiseDelete(int fundraiseId) throws ServiceException {
		FundraiseDAO fundraiseDAO = new FundraiseDAO();
		try {

			return fundraiseDAO.deleteFundraise(fundraiseId);
		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Retrieves the ID of a fundraising campaign.
	 *
	 * @return The ID of the campaign.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public int fundraiseGetFundraiseId() throws ServiceException {
		FundraiseDAO fundraiseDAO = new FundraiseDAO();
		try {
			return fundraiseDAO.getFundraiseId();
		} catch (DAOException e) {
			throw new ServiceException("Error getting fundraise ID", e);
		}
	} 

}
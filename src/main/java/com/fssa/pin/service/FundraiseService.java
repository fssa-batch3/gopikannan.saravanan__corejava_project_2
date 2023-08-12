package com.fssa.pin.service;

import java.util.List;

import com.fssa.pin.dao.FundraiseDAO;
import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Fundraise;
import com.fssa.pin.service.exception.ServiceException;
import com.fssa.pin.validation.FundraiseValidation;
import com.fssa.pin.validation.exceptions.InvalidFundraiseException;
import com.fssa.pin.validation.exceptions.InvalidUserException;

public class FundraiseService {
//	fundraise createService feature

	public boolean createFundraise(Fundraise fundraise) throws ServiceException {

		FundraiseDAO fundraiseDAO = new FundraiseDAO();

		try {

			FundraiseValidation.validateFundraise(fundraise);

			if (fundraiseDAO.createFundraise(fundraise)) {
				return true;
 
			} else {

				return false;
			}

		} catch (DAOException | InvalidFundraiseException | InvalidUserException e) {

			throw new ServiceException(e.getMessage(), e);
		}
	}

//	Fundraise view service feature
	public List<Fundraise> viewFundraisesServices() throws ServiceException {
		FundraiseDAO fundraiseDAO = new FundraiseDAO();

		try {
			return fundraiseDAO.viewFundraises();

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
 
//	Update Fundraise feature Service

	public boolean fundraiseUpdate(Fundraise fundraise) throws ServiceException {

		FundraiseDAO fundraiseDAO = new FundraiseDAO();

		try {
			FundraiseValidation.validateFundraise(fundraise);

			if (fundraiseDAO.updateFundraise(fundraise)) {
				System.out.println("Update fundraise for" + fundraise.getName() + " was successfull");
				return true;
			} else {
				System.out.println("Update Fundrasie was not successfull");
				return false;

			}

		} catch (DAOException | InvalidFundraiseException | InvalidUserException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

//	delete fundraise service feature

	public boolean fundraiseDelete(int fundraiseId) throws ServiceException {
		FundraiseDAO fundraiseDAO = new FundraiseDAO();
		try {

			if (fundraiseDAO.deleteFundraise(fundraiseId)) {

				return true;
			} else {

				return false;
			}

		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);
		}
	}

}
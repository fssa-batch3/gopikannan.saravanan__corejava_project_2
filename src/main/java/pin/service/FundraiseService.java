package pin.service;

import java.util.List;
import pin.dao.FundraiseDAO;
import pin.dao.exceptions.DAOException;
import pin.model.Fundraise;
import pin.service.exception.ServiceException;
import pin.validation.FundraiseValidation;
import pin.validation.exceptions.InvalidFundraiseException;
import pin.validation.exceptions.InvalidUserException;

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
				throw new DAOException(fundraise.getName() + " successfully fundraise updated");

			} else {
				System.out.println("Update was not successful");
				return false;
			}

		} catch (DAOException | InvalidFundraiseException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
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
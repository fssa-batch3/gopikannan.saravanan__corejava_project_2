package com.fssa.pin.service;

import com.fssa.pin.dao.DonateDAO;
import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Donate;
import com.fssa.pin.service.exception.ServiceException;
import com.fssa.pin.validation.DonateValidation;
import com.fssa.pin.validation.exceptions.InvalidDonationException;

//
public class DonateService {

	public boolean createDonationService (Donate donate) throws ServiceException {
		DonateDAO donateDAO = new DonateDAO();
		
		try{ if (!DonateValidation.validDonation(donate)) {
                return false;}
		
		   return donateDAO.createDonation(donate);
		}
		catch(DAOException|InvalidDonationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		}
	}

	
 
package com.fssa.pin.service;

import java.util.List;

import com.fssa.pin.dao.DonateDAO;
import com.fssa.pin.dao.exceptions.DAOException;
import com.fssa.pin.model.Donate;
import com.fssa.pin.service.exception.ServiceException;
import com.fssa.pin.validation.DonateValidation;
import com.fssa.pin.validation.exceptions.InvalidDonationException;
/**
 * Manages donation-related services.
 */
public class DonateService {
	 /**
     * Creates a new donation.
     *
     * @param donate The donation object.
     * @return True if the donation is created successfully, otherwise false.
     * @throws ServiceException If a serviceRelated issue occurs.
     */
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
	
	/**
	 * Retrieves a list of all donations from DB.
	 *
	 * @return A list of Donations objects .
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public List<Donate> viewDonationsService() throws ServiceException {
		DonateDAO donations = new DonateDAO();

		try {
			return donations.viewAllDonations();

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	}

	
 
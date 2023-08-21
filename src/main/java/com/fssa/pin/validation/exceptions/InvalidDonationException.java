package com.fssa.pin.validation.exceptions;

public class InvalidDonationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidDonationException(String msg) {
		super(msg);

	}

	public InvalidDonationException(Throwable e) {
		super(e);

	}
	public InvalidDonationException(String msg,Throwable e) {
		super(msg,e);

	}
}

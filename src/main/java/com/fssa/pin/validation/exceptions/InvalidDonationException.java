package com.fssa.pin.validation.exceptions;

public class InvalidDonationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new InvalidFundraiseException with the given error message.
	 *
	 * @param msg The error message describing the reason for the exception.
	 */
	public InvalidDonationException(String msg) {
		super(msg);

	}

	/**
	 * Constructs a new InvalidFundraiseException with the given underlying cause.
	 *
	 * @param e The underlying cause of the exception.
	 */
	public InvalidDonationException(Throwable e) {
		super(e);

	}

	/**
	 * Constructs a new InvalidFundraiseException with the given error message and
	 * underlying cause.
	 *
	 * @param msg The error message describing the reason for the exception.
	 * @param e   The underlying cause of the exception.
	 */
	public InvalidDonationException(String msg, Throwable e) {
		super(msg, e);

	}
}

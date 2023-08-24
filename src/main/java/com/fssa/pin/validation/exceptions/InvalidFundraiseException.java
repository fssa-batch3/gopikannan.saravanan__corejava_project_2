package com.fssa.pin.validation.exceptions;

/**
 * Custom exception class to represent errors related to invalid fundraise
 * information.
 */
public class InvalidFundraiseException extends Exception {

	/**
	 *  
	 */
	private static final long serialVersionUID = -2445894544830517976L;

	/**
	 * Constructs a new InvalidFundraiseException with the given error message.
	 *
	 * @param msg The error message describing the reason for the exception.
	 */
	public InvalidFundraiseException(String msg) {
		super(msg);

	}

	/**
	 * Constructs a new InvalidFundraiseException with the given underlying cause.
	 *
	 * @param e The underlying cause of the exception.
	 */
	public InvalidFundraiseException(Throwable e) {
		super(e);

	}

	/**
	 * Constructs a new InvalidFundraiseException with the given error message and
	 * underlying cause.
	 *
	 * @param msg The error message describing the reason for the exception.
	 * @param e   The underlying cause of the exception.
	 */
	public InvalidFundraiseException(String msg, Throwable e) {
		super(msg, e);

	}
}

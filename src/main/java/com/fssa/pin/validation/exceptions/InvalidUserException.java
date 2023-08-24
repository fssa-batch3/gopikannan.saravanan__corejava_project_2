package com.fssa.pin.validation.exceptions;

/**
 * user defined exception to represent errors related to invalid user
 * information.
 */
public class InvalidUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6504920749341860747L;

	/**
	 * Creates a new InvalidUserException with the given error message.
	 *
	 * @param msg The error message describing the reason for the exception.
	 */
	public InvalidUserException(String msg) {
		super(msg);

	}

	/**
	 * Creates a new InvalidUserException with the given underlying cause.
	 *
	 * @param e The underlying cause of the exception.
	 */
	public InvalidUserException(Throwable e) {
		super(e);

	}

}

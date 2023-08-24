package com.fssa.pin.service.exception;

/**
 * User defined exception class for service-related errors.
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2166346220002004434L;

	/**
	 * Creates a new ServiceException with the given error message.
	 *
	 * @param msg The error message describing the reason for the exception.
	 */
	public ServiceException(String msg) {
		super(msg);

	}

	/**
	 * Creates a new ServiceException with the given underlying cause.
	 *
	 * @param e The underlying cause of the exception.
	 */
	public ServiceException(Throwable e) {
		super(e);

	}

	/**
	 * Creates a new ServiceException with the given error message and underlying
	 * cause.
	 *
	 * @param msg The error message describing the reason for the exception.
	 * @param e   The underlying cause of the exception.
	 */
	public ServiceException(String string, Throwable e) {
		super(e);

	}

}

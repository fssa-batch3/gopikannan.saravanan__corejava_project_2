package com.fssa.pin.dao.exceptions;

/**
 * Custom exception class to represent errors related to Data Access Object (DAO) operations.
 */
public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8993866334754464701L;


	 /**
     * Creates a new DAOException with the given error message.
     *
     * @param msg The error message describing the reason for the exception.
     */
	public DAOException(String msg) {
		super(msg);

	}
	/**
     * Creates a new DAOException with the given underlying cause.
     *
     * @param e The underlying cause of the exception.
     */
	public DAOException(Throwable e) {
		super(e);

	}
	
	
	/**
     * Creates a new DAOException with the given error message and underlying cause.
     *
     * @param msg The error message describing the reason for the exception.
     * @param e The underlying cause of the exception.
     */
	public DAOException(String msg,Throwable e) {
		super(msg,e);

	}
 
}

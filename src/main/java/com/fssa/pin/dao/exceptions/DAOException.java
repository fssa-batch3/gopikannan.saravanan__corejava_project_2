package com.fssa.pin.dao.exceptions;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8993866334754464701L;


	
	public DAOException(String msg) {
		super(msg);

	}

	public DAOException(Throwable e) {
		super(e);

	}
	
	
	
	public DAOException(String msg,Throwable e) {
		super(msg,e);

	}
 
}

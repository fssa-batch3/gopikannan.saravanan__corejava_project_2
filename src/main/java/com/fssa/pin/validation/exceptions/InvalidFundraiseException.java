package com.fssa.pin.validation.exceptions;

public class InvalidFundraiseException extends Exception {
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -2445894544830517976L;

	public InvalidFundraiseException(String msg) {
		super(msg);

	}

	public InvalidFundraiseException(Throwable e) {
		super(e);

	}
	public InvalidFundraiseException(String msg,Throwable e) {
		super(msg,e);

	}
}

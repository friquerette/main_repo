package com.friquerette.mowitnow.service;

public class MowServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4582827715570443799L;

	public MowServiceException() {
		super();
	}

	public MowServiceException(String s) {
		super(s);
	}

	public MowServiceException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public MowServiceException(Throwable throwable) {
		super(throwable);
	}
}

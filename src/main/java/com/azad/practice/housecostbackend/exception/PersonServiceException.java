package com.azad.practice.housecostbackend.exception;

public class PersonServiceException extends RuntimeException {

	private static final long serialVersionUID = -871124619288578867L;

	public PersonServiceException(String message) {
		super(message);
	}	
}

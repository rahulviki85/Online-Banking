package com.cg.springdataonlinebanking.exception;

public class InvalidInputException extends RuntimeException {
	public InvalidInputException() {
		super();
	}
	
	public InvalidInputException(String msg) {
		super(msg);
	}
}

package com.cg.onlinebanking.exception;

public class InsufficientBalanceException extends RuntimeException {

	public InsufficientBalanceException() {
		super();
	}
	
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}

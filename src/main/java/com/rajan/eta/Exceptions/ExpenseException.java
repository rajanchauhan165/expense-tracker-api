package com.rajan.eta.Exceptions;

public class ExpenseException extends RuntimeException {

	public ExpenseException() {
	}

	public ExpenseException(String message) {
		super(message);
	}
}

package com.rajan.eta.Exceptions;

public class ItemAlreadyExistException extends RuntimeException{
	public ItemAlreadyExistException() {
		
	}
	public ItemAlreadyExistException(String message) {
		super(message);
	}
}

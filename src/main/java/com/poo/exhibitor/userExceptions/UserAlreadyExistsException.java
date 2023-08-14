package com.poo.exhibitor.userExceptions;

public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException(String message) {
		super(message);
	}
	
	private static final long serialVersionUID = 1L;
}

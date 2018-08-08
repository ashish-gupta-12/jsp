package com.capgemini.dal;

public class InvalidUserException extends RuntimeException {
	String msg;
	
	public  InvalidUserException(String msg) {
		super(msg);
	}
}

package com.kp.springwebmvc.springwebmvc.exceptions;

public class BadRequestException extends RuntimeException{
	
	public BadRequestException(String message) {
		super(message);
	}

}

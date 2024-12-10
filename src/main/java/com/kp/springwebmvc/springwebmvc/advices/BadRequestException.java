package com.kp.springwebmvc.springwebmvc.advices;

public class BadRequestException extends RuntimeException{
	
	public BadRequestException(String message) {
		super(message);
	}

}

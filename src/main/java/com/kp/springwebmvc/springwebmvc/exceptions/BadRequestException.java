package com.kp.springwebmvc.springwebmvc.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class BadRequestException extends RuntimeException{
	
	public BadRequestException(String message) {
		super(message);
	}

}





package com.kp.springwebmvc.springwebmvc.advices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ApiError {
	
	private String message;
	
	private HttpStatus status;
	
	private List<String> subError;

	public List<String> getSubError() {
		return subError;
	}

	public void setSubError(List<String> subError) {
		this.subError = subError;
	}

	public ApiError() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	

}

package com.kp.springwebmvc.springwebmvc.advices;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.*;

import lombok.*;
public class ApiResponse<T> {
	
	private T data;
	
	@JsonFormat(pattern="hh:mm:ss dd-MM-yyyy")
	private LocalDateTime timeElapsed;
	
	private ApiError apiError;
	
	

	public ApiResponse() {
		this.timeElapsed = LocalDateTime.now();
	}



	public ApiResponse(T data) {
		this();
		this.data = data;
	}
	
	public ApiResponse(ApiError apiError) {
		this();
		this.apiError = apiError;
	}



	public T getData() {
		return data;
	}



	public LocalDateTime getTimestamp() {
		return timeElapsed;
	}



	public ApiError getApiError() {
		return apiError;
	}
	
	
	
	
	
	
	
	
	

}

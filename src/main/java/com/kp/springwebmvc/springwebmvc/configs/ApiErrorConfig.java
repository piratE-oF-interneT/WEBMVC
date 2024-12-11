package com.kp.springwebmvc.springwebmvc.configs;

import org.springframework.context.annotation.Bean;

import com.kp.springwebmvc.springwebmvc.advices.ApiError;

public class ApiErrorConfig {
	
	@Bean
	
	public ApiError ApiErrorConfig() {
		return new ApiError();
	}

}

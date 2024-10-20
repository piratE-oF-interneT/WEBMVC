package com.kp.springwebmvc.springwebmvc.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MapperConfig {
	@Bean
	public ModelMapper getModelMapper() {
		// TODO Auto-generated method stub
			return new ModelMapper();
	}
	
	
	
	
	

}

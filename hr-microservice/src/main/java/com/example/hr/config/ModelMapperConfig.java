package com.example.hr.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper mapper() {
		var modelMapper = new ModelMapper();
		
		return modelMapper;
	}
}

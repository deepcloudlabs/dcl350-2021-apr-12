package com.example.crm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.PathMatchConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "CRM API", version = "1.0", description = "Documentation APIs v1.0"))
@Configuration
@EnableWebFlux
public class SwaggerUiConfig implements WebFluxConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("*");
		WebFluxConfigurer.super.addCorsMappings(registry);
	}

	@Override
	public void configurePathMatching(PathMatchConfigurer configurer) {
		configurer.addPathPrefix("/api/v1", clazz -> true);
		WebFluxConfigurer.super.configurePathMatching(configurer);
	}


}

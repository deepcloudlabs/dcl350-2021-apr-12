package com.example.crm.config;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.crm.handler.CrmHandler;

@Configuration
@RouterOperation
@EnableWebFlux
public class CrmRouter implements WebFluxConfigurer {

	@Bean
	public RouterFunction<ServerResponse> route(CrmHandler crmHandler){
		return RouterFunctions.route()
				.DELETE("/customers/{email}",crmHandler::removeCustomerByIdentity)
				.build();
	}
}

package com.example.crm.config;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.crm.handler.CrmHandler;

@Configuration
@RouterOperation
public class CrmRouter {

	@Bean
	public RouterFunction<ServerResponse> route(CrmHandler crmHandler){
		return RouterFunctions.route(
				RequestPredicates.DELETE("/customers/{email}"),crmHandler::removeCustomerByIdentity
		);
	}
}

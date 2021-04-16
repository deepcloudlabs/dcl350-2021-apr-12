package com.example.crm.handler;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.crm.document.CustomerDocument;
import com.example.crm.service.CustomerReactiveService;

import reactor.core.publisher.Mono;

@Service
public class CrmHandler {
	@Autowired
	private CustomerReactiveService customerService;
	
	public Mono<ServerResponse> removeCustomerByIdentity(ServerRequest request){
		Function<CustomerDocument,ServerResponse> mapper = 
				cust -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(cust)).block();
		return customerService.removeCustomerByEmail(request.pathVariable("email")).map(mapper);		
	}
}

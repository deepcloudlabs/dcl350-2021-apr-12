package com.example.lottery.service;

import org.springframework.stereotype.Service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@Service
public class BusinessService {

	@Bulkhead(name = "business", fallbackMethod = "doSomethingImportantFallback")
	public String doSomethingImportant() {
		return "Hello World!";
	}
	
	String doSomethingImportantFallback(Exception e) {
		return "Hello Mars!";
	}
}

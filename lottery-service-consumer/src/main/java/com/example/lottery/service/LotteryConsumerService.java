package com.example.lottery.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

//@Service
public class LotteryConsumerService {
	@Autowired
	private DiscoveryClient discoveryClient;
	private List<ServiceInstance> serviceInstances;
	private static final AtomicInteger counter = new AtomicInteger(0);
	
	@PostConstruct
	public void retrieveServiceInstances() {
		serviceInstances = discoveryClient.getInstances("lottery-producer");
	}
	
	@Scheduled(fixedRate = 3_000)
	public void callLotteryService() {
		var restTemplate = new RestTemplate();
		var index = counter.getAndIncrement() % serviceInstances.size();
		var serviceInstance = serviceInstances.get(index );
		var response = restTemplate.getForEntity(String.format("http://%s:%d/lottery/api/v1/numbers?column=5",serviceInstance.getHost(),serviceInstance.getPort()), String.class).getBody();
		System.out.println(response);
	}
}

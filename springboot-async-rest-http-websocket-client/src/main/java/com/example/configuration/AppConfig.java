package com.example.configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Configuration
@EnableScheduling
@EnableAsync
public class AppConfig {

	@Bean(name="mythreadpool-1")
	public Executor threadPool1() {
		return Executors.newSingleThreadExecutor();
	}
	
	@Bean(name="mythreadpool-2")
	public Executor threadPool2() {
		return Executors.newFixedThreadPool(10);
	}
	
	@Bean
	public WebSocketClient wsClient() {
		return new StandardWebSocketClient();
	}
}

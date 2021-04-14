package com.example.service;

import java.util.Arrays;
import java.util.Comparator;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dto.TickerDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class BinanceReactiveClientService {
	@Value("${binance.rest.url.base}")
	private String binanceRestUrlBase;
	@Value("${ticker.symbols}")
	private String tickerSymbols;
	private WebClient webClient;
	
	@PostConstruct
	public void init() {
		webClient = WebClient.builder().baseUrl(binanceRestUrlBase).build();
	}
	
	@Scheduled(fixedRate = 3_000)
	public void reactiveCallToBinance() {
		Flux.fromIterable(Arrays.asList(tickerSymbols.split(",")))
		    .parallel()
		    .runOn(Schedulers.boundedElastic())
		    .flatMap(this::getTicker)
		    .ordered(Comparator.comparing(TickerDTO::getPrice))
		    .subscribe(System.err::println);
	}
	
	public Mono<TickerDTO> getTicker(String symbol){
		return webClient.get()
				        .uri(uriBuilder -> uriBuilder.path("/ticker/price")
				        		                     .queryParam("symbol", symbol)
				        		                     .build())
				        .retrieve()
				        .bodyToMono(TickerDTO.class);
	} 
}

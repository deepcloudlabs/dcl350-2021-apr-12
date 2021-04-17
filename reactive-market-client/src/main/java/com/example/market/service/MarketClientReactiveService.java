package com.example.market.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.market.dto.Ticker;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@SuppressWarnings("deprecation")
public class MarketClientReactiveService {
	private final static String URL = "https://api.binance.com/api/v3/ticker/price";
	private final static String BASE_URL = "https://api.binance.com/api/v3";
	private final static List<String> SYMBOLS =
			List.of("BTCUSDT","LTCBTC","ETHBTC","BNBBTC","NEOBTC","EOSETH",
					"SNTETH","BNTETH","BCCBTC","SALTBTC","SALTETH","XVGETH",
					"XVGBTC", "SUBETH","EOSBTC","MTHBTC","ETCETH","DNTBTC","ENGBTC");
    private RestTemplate restTemplate = new RestTemplate();
	private AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
    private WebClient webclient = WebClient.builder().baseUrl(BASE_URL).build();
	//@Scheduled(fixedRate = 25_000)
	public void callBinanceService() {
		SYMBOLS.forEach(symbol ->
		  asyncRestTemplate.getForEntity(URL.concat("?symbol="+symbol), String.class)
		                   .addCallback(System.out::println, System.err::println)
		);
		SYMBOLS.stream().parallel()
		     .map( symbol -> 
			restTemplate.getForEntity(URL.concat("?symbol="+symbol), String.class)
			.getBody()
		).forEach(System.out::println);
	}
	
	@Scheduled(fixedRate = 25_000)
	public void reactiveCallNinanceService() {
		System.err.println(String.format("Calling binance %d times...",SYMBOLS.size()));
	    // Async
		Flux.fromIterable(SYMBOLS)
	        .parallel()
	        .runOn(Schedulers.elastic())
	        .flatMap(this::getTicker)
	        .ordered(Comparator.comparing(Ticker::getSymbol))
	        .subscribe(System.err::println);  
	    System.err.println(String.format("Calling binance %d times... done.",SYMBOLS.size()));
	}
	
	public Mono<Ticker> getTicker(String symbol){
		return webclient.get()
				  .uri(uriBuilder -> uriBuilder.path("/ticker/price")
						                        .queryParam("symbol", symbol).build())
				  .retrieve()
				  .bodyToMono(Ticker.class);
	}
}

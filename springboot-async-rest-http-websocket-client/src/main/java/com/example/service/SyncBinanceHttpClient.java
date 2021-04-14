package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.example.dto.TickerDTO;

@SuppressWarnings("deprecation")
@Service
public class SyncBinanceHttpClient {
	@Value("${binance.rest.url}")
	private String url;

	//@Scheduled(fixedRateString = "${binance.rest.period}")
	public void callBinance() {
		var rt = new RestTemplate();
		var ticker = rt.getForEntity(url, TickerDTO.class).getBody();
		System.err.println(ticker);
	}
	
	@Scheduled(fixedRateString = "${binance.rest.period}")
	public void asynCallBinance() {
		var rt = new AsyncRestTemplate();
		rt.getForEntity(url, TickerDTO.class)
		  .addCallback(
				  ticker -> System.out.println(ticker.getBody()),
				  err -> System.out.println(err.getMessage())
		  );
	}
}

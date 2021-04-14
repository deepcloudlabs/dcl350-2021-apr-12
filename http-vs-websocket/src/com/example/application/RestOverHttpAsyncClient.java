package com.example.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RestOverHttpAsyncClient {
	private static final List<String> CURRENCIES = List.of(
			"BTCUSDT", "BNBBTC", "NEOBTC",
			"LTCBTC", "ETHBTC", "SNMBTC",
			"SNMETH", "NEOETH", "TUSDBTC", "ETHTUSD"
			) ;
	private static final String URL = "https://api.binance.com/api/v3/ticker/price?symbol=";
	private static final AtomicInteger counter = new AtomicInteger(0);

	public static void main(String[] args) throws IOException, InterruptedException {
		// SSE (Server-Sent Event) HTTP2/HTTP3
		var client = HttpClient.newHttpClient();
		var start = System.currentTimeMillis();
		for (var currency :  CURRENCIES) {
			var request = HttpRequest.newBuilder().uri(URI.create(URL+currency)).header("Accept", "appplication/json").build();
			client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenAcceptAsync(ticker -> {
				var index = counter.incrementAndGet();
				System.err.println(ticker.body());
				if (index==10) {
					var stop = System.currentTimeMillis();
					System.err.println("Duration: " + (stop - start) + " ms.");					
				}
			});
		}
		TimeUnit.SECONDS.sleep(30);
	}

}

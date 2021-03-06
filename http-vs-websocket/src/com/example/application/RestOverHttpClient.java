package com.example.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestOverHttpClient {
	private static final String URL = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";
	public static void main(String[] args) throws IOException, InterruptedException {
		// SSE (Server-Sent Event) HTTP2/HTTP3
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				                 .uri(URI.create(URL))
				                 .header("Accept", "appplication/json")
				                 .build();
		var start = System.currentTimeMillis();
		for (var i=0;i<10;++i) {
			var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
			System.err.println(response);
		}
		var stop = System.currentTimeMillis();
		System.err.println("Duration: "+(stop-start)+" ms.");
	}

}

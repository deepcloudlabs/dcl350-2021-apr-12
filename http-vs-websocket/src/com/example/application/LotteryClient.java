package com.example.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SuppressWarnings("unused")
public class LotteryClient {
	// 8520 ms
	private static final String URL_GATEWAY = "http://localhost:3200/lottery1/api/v1/numbers?column=2";
	// 4278 ms
	private static final String URL_DIRECT = "http://localhost:2100/api/v1/numbers?column=2";
	public static void main(String[] args) throws IOException, InterruptedException {
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				                 .uri(URI.create(URL_DIRECT))
				                 .header("Accept", "appplication/json")
				                 .build();
		var start = System.currentTimeMillis();
		for (var i=0;i<1000;++i) {
			var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
			//System.err.println(response);
		}
		var stop = System.currentTimeMillis();
		System.err.println("Duration: "+(stop-start)+" ms.");
	}

}

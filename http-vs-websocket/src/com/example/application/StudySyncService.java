package com.example.application;

import com.example.service.LotteryService;

public class StudySyncService {

	public static void main(String[] args) {
		System.err.println("App is running");
		var service = new LotteryService();
		System.err.println(service.draw(60, 6));
		System.err.println("Done.");
	}

}

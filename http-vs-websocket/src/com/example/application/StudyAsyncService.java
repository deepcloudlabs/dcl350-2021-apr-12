package com.example.application;

import java.util.concurrent.TimeUnit;

import com.example.service.LotteryAsyncService;

public class StudyAsyncService {

	public static void main(String[] args) throws InterruptedException {
		System.err.println("App is running");
		var service = new LotteryAsyncService();
		service.draw(60, 6)
		       .thenAcceptAsync( numbers -> {
		    	   System.err.println(Thread.currentThread().getName()+ ": "+numbers);    
		       });
		for (var i=0;i<30;++i) {
			System.err.println(Thread.currentThread().getName()+" is running ...");
			TimeUnit.MICROSECONDS.sleep(100);				
		}
		TimeUnit.SECONDS.sleep(30);	
	}

}

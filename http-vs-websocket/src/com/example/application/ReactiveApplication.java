package com.example.application;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Flow.Subscription;

import com.example.event.Trade;

public class ReactiveApplication {

	public static void main(String[] args) {
		var trades = List.of(
				new Trade("ORCL", 100.0, 50),
				new Trade("MSFT", 120.0, 70),
				new Trade("IBM", 140.0, 60),
				new Trade("ORCL", 130.0, 90),
				new Trade("MSFT", 120.0, 80),
				new Trade("IBM", 110.0, 30)
		);
		SubmissionPublisher<Trade> publisher = new SubmissionPublisher<>();
		publisher.subscribe(new AlgoTrader());
		publisher.subscribe(new SignalProducer());
		trades.forEach(publisher::submit);
		try { TimeUnit.SECONDS.sleep(30);}catch(Exception e) {}
	}

}

class AlgoTrader implements Flow.Subscriber<Trade> {
	
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("AlgoTrader is subscribed.");
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(Trade event) {
		try { TimeUnit.SECONDS.sleep(4);}catch(Exception e) {}
		System.err.println("AlgoTrader : " + event);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("AlgoTrader - Error : "+throwable.getMessage());
		
	}

	@Override
	public void onComplete() {
		System.err.println("AlgoTrader is done.");
	}
	
}

class SignalProducer implements Flow.Subscriber<Trade> {
	
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("SignalProducer is subscribed.");
		this.subscription = subscription;
		this.subscription.request(1);		
	}
	
	@Override
	public void onNext(Trade event) {
		System.err.println("SignalProducer : " + event);
		this.subscription.request(1);		
	}
	
	@Override
	public void onError(Throwable throwable) {
		System.err.println("SignalProducer - Error : "+throwable.getMessage());
		
	}
	
	@Override
	public void onComplete() {
		System.err.println("SignalProducer is done.");
	}
	
}
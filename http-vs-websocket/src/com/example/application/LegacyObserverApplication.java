package com.example.application;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import com.example.event.Trade;

public class LegacyObserverApplication {

	public static void main(String[] args) {
		var observable = new TradeEventObservable();
		Observer slowObserver = (o, trade) -> {
			try { TimeUnit.SECONDS.sleep(4);}catch(Exception e) {}
			System.err.println("Slow observer: "+trade);
		};
		Observer fastObserver = (o, trade) -> {
			System.err.println("Fast observer: "+trade);
		};
		observable.addObserver(slowObserver);
		observable.addObserver(fastObserver);
		var trades = List.of(
				new Trade("ORCL", 100.0, 50),
				new Trade("MSFT", 120.0, 70),
				new Trade("IBM", 140.0, 60),
				new Trade("ORCL", 130.0, 90),
				new Trade("MSFT", 120.0, 80),
				new Trade("IBM", 110.0, 30)
		);
		trades.forEach(observable::notifyObservers);
	}

}


class TradeEventObservable extends Observable {

	@Override
	public void notifyObservers(Object event) {
		setChanged();
		super.notifyObservers(event);
	}
	
}
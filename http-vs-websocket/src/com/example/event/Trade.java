package com.example.event;

public class Trade {

	private String symbol;
	private double price;
	private double quantity;

	public Trade(String symbol, double price, double quantity) {
		this.symbol = symbol;
		this.price = price;
		this.quantity = quantity;
	}

	public final String getSymbol() {
		return symbol;
	}

	public final double getPrice() {
		return price;
	}

	public final double getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Trade [symbol=" + symbol + ", price=" + price + ", quantity=" + quantity + "]";
	}

}

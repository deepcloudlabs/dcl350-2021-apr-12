package com.example.dto;

public class TickerDTO {
	private String symbol;
	private String price;

	public TickerDTO() {
	}

	public final String getSymbol() {
		return symbol;
	}

	public final void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public final String getPrice() {
		return price;
	}

	public final void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TickerDTO [symbol=" + symbol + ", price=" + price + "]";
	}

}

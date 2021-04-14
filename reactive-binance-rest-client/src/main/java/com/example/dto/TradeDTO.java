package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// {"e":"trade","E":1618404010669,"s":"BTCUSDT","t":765293836,"p":"64170.00000000","q":"0.01244500","b":5535693991,"a":5535703525,"T":1618404010667,"m":true,"M":true}
public class TradeDTO {
	@JsonProperty("s")
	private String symbol;
	@JsonProperty("p")
	private String price;
	@JsonProperty("q")
	private String quantity;
	@JsonProperty("b")
	private long bid;
	@JsonProperty("a")
	private long ask;

	public TradeDTO() {
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

	public final String getQuantity() {
		return quantity;
	}

	public final void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public final long getBid() {
		return bid;
	}

	public final void setBid(long bid) {
		this.bid = bid;
	}

	public final long getAsk() {
		return ask;
	}

	public final void setAsk(long ask) {
		this.ask = ask;
	}

	@Override
	public String toString() {
		return "TradeDTO [symbol=" + symbol + ", price=" + price + ", quantity=" + quantity + ", bid=" + bid + ", ask="
				+ ask + "]";
	}

}

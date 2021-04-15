package com.example.lottery.dto;

import java.util.List;

public class LotteryResponse {
	private List<List<Integer>> numbers;

	public LotteryResponse() {
	}

	public final List<List<Integer>> getNumbers() {
		return numbers;
	}

	public final void setNumbers(List<List<Integer>> numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "LotteryResponse [numbers=" + numbers + "]";
	}

}

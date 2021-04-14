package com.example.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class LotteryAsyncService {
	public CompletableFuture<List<Integer>> draw(int max,int size){
		return CompletableFuture.supplyAsync( () ->{
			System.err.println(Thread.currentThread().getName()+" is running ...");
			try  { TimeUnit.SECONDS.sleep(3); } catch (Exception e) { }
			return ThreadLocalRandom.current()
					.ints(1, max)
					.distinct()
					.limit(size)
					.sorted()
					.boxed()
					.collect(Collectors.toList());			
		} );
	}
}

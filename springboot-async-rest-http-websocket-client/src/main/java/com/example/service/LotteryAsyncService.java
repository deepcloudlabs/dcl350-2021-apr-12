package com.example.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class LotteryAsyncService {

	public List<Integer> draw(int max, int size){
		return ThreadLocalRandom.current().ints(1,max).distinct().limit(size).sorted().boxed().collect(Collectors.toList());
	}
	
	@Async("mythreadpool-2") // Java 8+
	public CompletableFuture<List<Integer>> asyncDraw1(int max, int size){
		return CompletableFuture.supplyAsync( () -> draw(max,size) ) ;
	}

	@Async("mythreadpool-1") // Spring Framework
	public Future<List<Integer>> asyncDraw2(int max, int size){
		return new AsyncResult<List<Integer>>( draw(max,size) ) ;
	}
}

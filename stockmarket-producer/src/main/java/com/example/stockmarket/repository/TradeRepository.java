package com.example.stockmarket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.stockmarket.document.Trade;

public interface TradeRepository extends MongoRepository<Trade, String> {

}

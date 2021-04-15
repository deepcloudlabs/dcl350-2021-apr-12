package com.example.random.service.business;

import java.security.SecureRandom;
import java.util.Random;

import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

@Quality(QualityLevel.SECURE)
public class SecureRandomNumberService implements RandomNumberService {

	private Random random = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

}

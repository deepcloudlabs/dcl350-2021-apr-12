package com.example.lottery.application;

import java.util.ResourceBundle;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

public class LotteryApplication {

	public static void main(String[] args) {
		
		var bundle = ResourceBundle.getBundle("application");
		var qualityLevel = bundle.getString("quality.level");
		var level = QualityLevel.valueOf(qualityLevel);

		var lotteryService = new StandardLotteryService();
		ServiceLoader<RandomNumberService> implementations = ServiceLoader.load(RandomNumberService.class);
		var randomNumberService = implementations.stream().filter(imp -> {
			var clazz = imp.get().getClass();
			if (clazz.isAnnotationPresent(Quality.class)) {
				var quality = clazz.getAnnotation(Quality.class);
				if (quality.value() == level)
					return true;
			}
			return false;
		}).findFirst().get().get();

		System.err.println(randomNumberService.getClass().getName());
		lotteryService.setRandomNumberService(randomNumberService);
		System.err.println(lotteryService.draw(60, 6));
	}

}

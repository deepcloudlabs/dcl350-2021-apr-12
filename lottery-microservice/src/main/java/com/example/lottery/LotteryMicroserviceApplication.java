package com.example.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// How to build spring boot application:
// mvn clean install spring-boot:repackage
// target/lottery-microservice-0.0.1.Final.jar
// java -jar lottery-microservice-0.0.1.Final.jar

// How to run spring boot application:
// mvn clean install spring-boot:run

// How to set JDK 11 to path
// set PATH=c:\DEVEL\stage\opt\jdk-11.0.7\bin;%PATH%

// How to set active spring profile: -Dspring.profiles.active=preprod
//start java -Dserver.port=5300 -Dspring.profiles.active=preprod -jar target\lottery-microservice-0.0.1.Final.jar

// jar xvf target\lottery-microservice-0.0.1.Final.jar BOOT-INF/classes/application-preprod.properties

@SpringBootApplication
public class LotteryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryMicroserviceApplication.class, args);
	}

}

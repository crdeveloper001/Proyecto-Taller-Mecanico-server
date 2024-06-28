package com.example.tallermecanicoserverv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.tallermecanicoserverv2.Repositories"})
public class TallerMecanicoServerv2Application {

	public static void main(String[] args) {
		SpringApplication.run(TallerMecanicoServerv2Application.class, args);
		System.out.println("API SERVER STARTED");
	}

}

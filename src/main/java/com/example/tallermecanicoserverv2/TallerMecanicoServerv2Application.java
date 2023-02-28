package com.example.tallermecanicoserverv2;

import jakarta.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.tallermecanicoserverv2.Repositories"})
public class TallerMecanicoServerv2Application {

	public static void main(String[] args) {
		SpringApplication.run(TallerMecanicoServerv2Application.class, args);

	}




}

package com.waiwing.example.queryapp;

import com.waiwing.example.queryapp.repository.QueryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class QueryappApplication {

	@Autowired
	QueryItemRepository queryItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(QueryappApplication.class, args);
	}

}

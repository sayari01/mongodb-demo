package com.ps.mongodbdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ps.mongodbdemo.model.Details;
import com.ps.mongodbdemo.repository.ApiRepository;
import com.ps.mongodbdemo.service.ApiDetailsService;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbDemoApplication implements CommandLineRunner {

	@Autowired
	ApiRepository apiRepository;

	@Autowired
	ApiDetailsService apiDetailsService;

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("-------------CREATE API DETAILS ITEMS-------------------------------\n");
		apiDetailsService.createApiDetails();

		System.out.println("\n----------------SHOW ALL Api Details ITEMS---------------------------\n");
		apiDetailsService.showAllApiDetails();

		System.out.println("\n--------------GET API DETAILS BY NAME-----------------------------------\n");
		apiDetailsService.getApiDetailsByName("sample Api 1");

		System.out.println("\n-----------UPDATE DETAILS OF API DETAILS----------------\n");
		apiDetailsService.updateApiDetails("sample Api 2", new Details("1234", "This API Is recommended", "HIGH"));

		System.out.println("\n----------DELETE A ApiDetails ITEM----------------------------------\n");
		apiDetailsService.deleteApiDetails("Api 3");

		System.out.println("\n------------FINAL COUNT OF GROCERY ITEMS-------------------------\n");
		apiDetailsService.findCountApiDetails();

		System.out.println("\n-------------------THANK YOU---------------------------");
	}
}

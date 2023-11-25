package com.ecommerce.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.ecommerce.microservice.entity.Product;
import com.ecommerce.microservice.repository.ProductRepository;


@EnableEurekaClient
@SpringBootApplication
public class EcommerceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceProductApplication.class, args);
	}
	
	
	

}

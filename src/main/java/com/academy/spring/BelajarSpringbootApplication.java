package com.academy.spring;

import com.academy.spring.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BelajarSpringbootApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BelajarSpringbootApplication.class, args);
	}

}

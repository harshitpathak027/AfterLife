package com.example.AfterLife;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AfterLifeApplication {

	public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AfterLifeApplication.class, args);

	}

}

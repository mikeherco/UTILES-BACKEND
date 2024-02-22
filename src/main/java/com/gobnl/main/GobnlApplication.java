package com.gobnl.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan({"com.*"})
@PropertySource("classpath:application.properties")
public class GobnlApplication   {
	public static void main(String[] args) {
		SpringApplication.run(GobnlApplication.class, args);
	}
}
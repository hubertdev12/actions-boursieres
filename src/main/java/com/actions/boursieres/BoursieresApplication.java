package com.actions.boursieres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(ActionsConfigProperties.class)
public class BoursieresApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoursieresApplication.class, args);
	}

}

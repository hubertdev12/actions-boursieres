package com.actions.boursieres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //Active les tâches planifiées
@EnableConfigurationProperties(ActionsConfigProperties.class) // Activation des paramètres de la configuration personnelles
@EnableCaching // Active la cache pour stocker les prix
public class BoursieresApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoursieresApplication.class, args);
	}

}

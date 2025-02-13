package com.actions.boursieres.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


    /**
     * Charger les variables d'environnement depuis secret.env
     * @return configurer
     */
    /*
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new FileSystemResource("conf/secret.env"));

        return configurer;
    }*/

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}

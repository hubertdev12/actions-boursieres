package com.actions.boursieres;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("actions")
public record ActionsConfigProperties(String apiUrl, String apiVersion, String databaseUrl, String database, String databaseUsername, String databasePassword, String apiVantageKey, String apiVantageUrl) {

}

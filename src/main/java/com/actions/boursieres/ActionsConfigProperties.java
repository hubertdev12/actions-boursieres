package com.actions.boursieres;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Paramètres pour les clés secretes
 * @param apiUrl
 * @param apiVersion
 * @param databaseUrl
 * @param database
 * @param databaseUsername
 * @param databasePassword
 * @param apiVantageKey
 * @param apiVantageUrl
 */
@ConfigurationProperties("actions")
public record ActionsConfigProperties(String apiUrl, String apiVersion, String databaseUrl, String database, String databaseUsername, String databasePassword, String apiVantageKey, String apiVantageUrl) {

}

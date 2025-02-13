package com.actions.boursieres.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StockPriceService {
    private final RestTemplate restTemplate;

    @Value("${alpha_vantage.api.key}")
    private String apiKey;
    @Value("${alpha_vantage.api.url}")
    private String apiUrl;

    private static final String TIME_SERIES_INTRADAY = "TIME_SERIES_INTRADAY";

    /**
     * Service de récupération des prix en temps réel (interroge Alpha Vantage)
     * @param symbol
     * @return
     */
    public Double getRealTimeStockPrice(String symbol){
        System.out.println("API KEY : " + apiKey);
        System.out.println("API KEY : " + apiUrl);
        String url = String.format("%s?function=%s&symbol=%s&interval=5min&apikey=%s", apiUrl, TIME_SERIES_INTRADAY, symbol, apiKey);

        System.out.println("URL : " + url);

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> body = response.getBody();

        if(body == null || !body.containsKey("Time Series (5min)")){
            throw new RuntimeException("Données non disponibles pour " + symbol);
        }

        //Extraire la dernière valeur de l'action
        Map<String, Object> timeSeries = (Map<String, Object>) body.get("Time Series (5min)");
        String lastKey = timeSeries.keySet().iterator().next();
        Map<String, String> lastData = (Map<String, String>) timeSeries.get(lastKey);

        return Double.parseDouble(lastData.get("4. close")); //Prix de la cloture du dernier point
    }
}

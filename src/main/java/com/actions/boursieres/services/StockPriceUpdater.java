package com.actions.boursieres.services;

import com.actions.boursieres.entities.Stock;
import com.actions.boursieres.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class StockPriceUpdater {
    private final StockRepository stockRepository;
    private final StockPriceService stockPriceService;

    /**
     * Planification de la mise à jour d'une action toutes les minutes
     */
    @Scheduled(fixedRateString = "${stock.update.frequency}") // 60000 ms = 1 min
    public void updateStockPrices(){
        log.info("Mise à jour des prix des actions en cours...");

        List<Stock> stocks = stockRepository.findAll();
        if (stocks.isEmpty()) return;

        Stock stock = stocks.get(new Random().nextInt(stocks.size())); // choisir une action aléatoire
        try {
            Double newPrice = stockPriceService.getRealTimeStockPrice(stock.getTickerSymbol());
            stock.setCurrentPrice(newPrice);
            stockRepository.save(stock);
            log.info("{} mise à jour à {}", stock.getTickerSymbol(), newPrice);
        } catch (Exception e){
            log.error("Erreur de mise à jour pour {} : {}", stock.getTickerSymbol(), e.getMessage());
        }

    }
}

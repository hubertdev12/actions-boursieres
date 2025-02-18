package com.actions.boursieres.services;

import com.actions.boursieres.entities.Stock;
import com.actions.boursieres.entities.StockPriceHistory;
import com.actions.boursieres.repositories.StockPriceHistoryRepository;
import com.actions.boursieres.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockPriceHistoryService {
    private final StockPriceHistoryRepository stockPriceHistoryRepository;
    private final StockRepository stockRepository;

    /**
     *
     * @param symbol
     * @return les prix des 30 derniers jours
     */
    public List<StockPriceHistory> getPriceHistory(String symbol){
        Stock stock = stockRepository.findByTickerSymbol(symbol)
                .orElseThrow(() -> new RuntimeException("Stock no found"));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date last30Days = calendar.getTime();

        return stockPriceHistoryRepository.findRecentHistory(stock, last30Days);
    }
}

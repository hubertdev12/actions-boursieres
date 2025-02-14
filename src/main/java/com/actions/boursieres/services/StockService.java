package com.actions.boursieres.services;

import com.actions.boursieres.entities.Stock;
import com.actions.boursieres.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final StockPriceService stockPriceService;

    public Stock addStock(Stock stock){
        return  stockRepository.save(stock);
    }

    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    /**
     *
     * @param symbol
     * @return
     */
    public Stock getStockBySymbol(String symbol){
        return stockRepository.findByTickerSymbol(symbol)
                .orElseThrow(() -> new RuntimeException("Stock no found"));
    }
}

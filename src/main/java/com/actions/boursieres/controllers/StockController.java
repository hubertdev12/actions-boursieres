package com.actions.boursieres.controllers;

import com.actions.boursieres.entities.Stock;
import com.actions.boursieres.services.StockPriceService;
import com.actions.boursieres.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    private final StockPriceService stockPriceService;

    /**
     * Ajouter une action
     * @param stock
     * @return
     */
    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        return ResponseEntity.ok(stockService.addStock(stock));
    }

    /**
     * Voir toutes les actions
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks(){
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    /**
     * Voir une action par symbol
     * @param symbol
     * @return
     */
    @GetMapping("/{symbol}")
    public ResponseEntity<Stock> getStock(@PathVariable String symbol){
        return ResponseEntity.ok(stockService.getStockBySymbol(symbol));
    }

    @GetMapping("/{symbol}/price")
    public ResponseEntity<Double> getStockPrice(@PathVariable String symbol){
        return ResponseEntity.ok(stockPriceService.getRealTimeStockPrice(symbol));
    }
}

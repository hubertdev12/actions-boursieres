package com.actions.boursieres.services;

import com.actions.boursieres.entities.Portfolio;
import com.actions.boursieres.entities.Stock;
import com.actions.boursieres.repositories.PortfolioRepository;
import com.actions.boursieres.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;

    public Portfolio createPortfolio(){
        return  portfolioRepository.save(new Portfolio(null, new ArrayList<>(), 0.0));
    }

    public Portfolio addStockToPortfolio(Long portfolioId, String tickerSymbol){
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio no found"));
        Stock stock = stockRepository.findByTickerSymbol(tickerSymbol)
                .orElseThrow(() -> new RuntimeException("Stock no found"));

        portfolio.getStocks().add(stock);
        portfolio.setTotalValue(portfolio.getStocks().stream().mapToDouble(Stock::getCurrentPrice).sum());

        return portfolioRepository.save(portfolio);
    }

    public Portfolio getPortfolio(Long id){
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio no found"));
    }
}

package com.actions.boursieres.repositories;

import com.actions.boursieres.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByTickerSymbol(String tickerSymbol);
}

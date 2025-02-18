package com.actions.boursieres.repositories;

import com.actions.boursieres.entities.Stock;
import com.actions.boursieres.entities.StockPriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockPriceHistoryRepository extends JpaRepository<StockPriceHistory, Long> {
    List<StockPriceHistory> findByStockOrderByTimestampDesc(Stock stock);

    @Query("SELECT s FROM StockPriceHistory s WHERE s.stock = :stock AND s.timestamp >= :since ORDER BY s.timestamp DESC")
    List<StockPriceHistory> findRecentHistory(@Param("stock") Stock stock, @Param("since")Date since);
}

package com.actions.boursieres.controllers;

import com.actions.boursieres.entities.Portfolio;
import com.actions.boursieres.services.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    /**
     * Créer un portefeuille
     * @return
     */
    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(){
        return ResponseEntity.ok(portfolioService.createPortfolio());
    }

    /**
     * Ajouter une action à un portefeuille
     * @param id
     * @param symbol
     * @return
     */
    @PostMapping("/{id}/stocks/{symbol}")
    public ResponseEntity<Portfolio> addStockToPortfolio(@PathVariable Long id, @PathVariable String symbol){
        return ResponseEntity.ok(portfolioService.addStockToPortfolio(id, symbol));
    }

    /**
     * Voir un portefeuille
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolio(@PathVariable Long id){
        return ResponseEntity.ok(portfolioService.getPortfolio(id));
    }

}

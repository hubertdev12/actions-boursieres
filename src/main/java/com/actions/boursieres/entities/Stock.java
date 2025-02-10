package com.actions.boursieres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private  String tickerSymbol; // Ex: AAPL, TSLA, MSFT

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private Double currentPrice;
}

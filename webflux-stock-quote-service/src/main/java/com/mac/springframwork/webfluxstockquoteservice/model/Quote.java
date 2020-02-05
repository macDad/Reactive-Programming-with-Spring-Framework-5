package com.mac.springframwork.webfluxstockquoteservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Instant;

/**
 * The type Quote.
 */
@Data
@NoArgsConstructor
public class Quote {
    private static final MathContext MATH_CONTEXT = new MathContext(2);

    private String ticker;
    private BigDecimal price;
    private Instant instant;

    /**
     * Instantiates a new Quote.
     *
     * @param ticker the ticket
     * @param price  the price
     */
    public Quote(String ticker, BigDecimal price) {
        this.ticker = ticker;
        this.price = price;
    }

    /**
     * Instantiates a new Quote.
     *
     * @param ticker the ticket
     * @param price  the price
     */
    public Quote(String ticker, Double price) {
        this.ticker = ticker;
        this.price = new BigDecimal(price, MATH_CONTEXT);
    }
}

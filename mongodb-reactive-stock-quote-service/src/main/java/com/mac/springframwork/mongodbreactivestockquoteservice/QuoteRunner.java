package com.mac.springframwork.mongodbreactivestockquoteservice;

import com.mac.springframwork.mongodbreactivestockquoteservice.client.StockQuoteClient;
import com.mac.springframwork.mongodbreactivestockquoteservice.domain.Quote;
import com.mac.springframwork.mongodbreactivestockquoteservice.repositories.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

@Component
public class QuoteRunner implements CommandLineRunner {
    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository quoteRepository;

    public QuoteRunner(StockQuoteClient stockQuoteClient, QuoteRepository quoteRepository) {
        this.stockQuoteClient = stockQuoteClient;
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Flux<Quote> quoteFlux = stockQuoteClient.getQuoteStream();
        Flux<Quote> quoteFlux = quoteRepository.findWithTableCursorBy();


        Disposable disposable = quoteFlux.subscribe(quote -> {
            System.out.println("*$*$**$*$$*$*$*$*$*$$*$*$ Id: " + quote.getId());
        });
        disposable.dispose();
    }
}

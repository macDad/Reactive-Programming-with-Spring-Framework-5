package com.mac.springframwork.mongodbreactivestockquoteservice.repositories;


import com.mac.springframwork.mongodbreactivestockquoteservice.domain.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

/**
 * The interface Quote repository.
 */
public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {
    @Tailable
    Flux<Quote> findWithTableCursorBy();
}

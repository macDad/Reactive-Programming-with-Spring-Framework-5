package com.mac.springframework.netfluxexample.service;

import com.mac.springframework.netfluxexample.domain.Movie;
import com.mac.springframework.netfluxexample.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The interface Movie service.
 */
public interface MovieService {
    /**
     * Generate stream of movie events for given movie id
     *
     * @param movieId the movie id
     * @return the flux
     */
    Flux<MovieEvent> events(String movieId);

    /**
     * Get Movie By id.
     *
     * @param id the id
     * @return the mono
     */
    Mono<Movie> getMovieById(String id);

    /**
     * Gets list of all movies.
     *
     * @return the all movies
     */
    Flux<Movie> getAllMovies();
}

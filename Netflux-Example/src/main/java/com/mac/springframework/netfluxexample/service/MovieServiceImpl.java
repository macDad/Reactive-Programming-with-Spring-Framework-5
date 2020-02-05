package com.mac.springframework.netfluxexample.service;

import com.mac.springframework.netfluxexample.domain.Movie;
import com.mac.springframework.netfluxexample.domain.MovieEvent;
import com.mac.springframework.netfluxexample.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

/**
 * The type Movie service.
 */
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    /**
     * Instantiates a new Movie service.
     *
     * @param movieRepository the movie repository
     */
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Generate stream of movie events for given movie id
     *
     * @param movieId the movie id
     * @return the flux
     */
    @Override
    public Flux<MovieEvent> events(String movieId) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }

    /**
     * Get Movie By id.
     *
     * @param id the id
     * @return the mono
     */
    @Override
    public Mono<Movie> getMovieById(String id) {
        return this.movieRepository.findById(id);
    }

    /**
     * Gets list of all movies.
     *
     * @return the all movies
     */
    @Override
    public Flux<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }
}

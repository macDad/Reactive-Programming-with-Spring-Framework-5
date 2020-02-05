package com.mac.springframework.netfluxexample.controllers;

import com.mac.springframework.netfluxexample.domain.Movie;
import com.mac.springframework.netfluxexample.domain.MovieEvent;
import com.mac.springframework.netfluxexample.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The type Movie controller.
 */
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    /**
     * Instantiates a new Movie controller.
     *
     * @param movieService the movie service
     */
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Stream movie events flux.
     *
     * @param id the id
     * @return the flux
     */
    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> streamMovieEvents(@PathVariable String id) {
        return movieService.events(id);
    }

    /**
     * Gets movie by id.
     *
     * @param id the id
     * @return the movie by id
     */
    @GetMapping(value = "/{id}")
    Mono<Movie> getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    /**
     * Gets all movies.
     *
     * @return the all movies
     */
    @GetMapping
    Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}

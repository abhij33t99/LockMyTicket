package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.model.Movie;
import com.ticketbooking.theatreservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @QueryMapping
    public List<Movie> getRecommendedMovies() {
        return movieService.getRecommendedMovies();
    }

    @MutationMapping
    public Movie addMovie(@Argument Movie movie) {
        return movieService.addMovie(movie);
    }
}

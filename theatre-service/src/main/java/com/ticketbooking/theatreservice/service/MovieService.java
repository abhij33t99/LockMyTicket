package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.model.Movie;
import com.ticketbooking.theatreservice.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getRecommendedMovies() {
        return this.movieRepository.getRecommendedMovies();
    }
}

package com.ticketbooking.theatreservice.repository;

import com.ticketbooking.theatreservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "select * from movie where release_date >= current_date - interval '30 days' order by release_date desc", nativeQuery = true)
    List<Movie> getRecommendedMovies();
}

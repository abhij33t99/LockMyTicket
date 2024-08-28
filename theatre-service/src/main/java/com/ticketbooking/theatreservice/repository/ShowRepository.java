package com.ticketbooking.theatreservice.repository;

import com.ticketbooking.theatreservice.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.ticketbooking.theatreservice.constant.QueryConstant.SQL_GET_SHOWS_BY_THEATRE_AND_DATE;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query(value = SQL_GET_SHOWS_BY_THEATRE_AND_DATE, nativeQuery = true)
    List<Show> findByTheatreAndDate(@Param("theatreId") long theatreId, @Param("date") LocalDate date);

    @Modifying
    @Query(value = "CALL ADD_NEW_SHOW(:p_movie_id, :p_screen_id, :p_date);", nativeQuery = true)
    void addShow(@Param("p_movie_id") long movieId, @Param("p_date") LocalDateTime dateTime, @Param("p_screen_id") long screenId);
}

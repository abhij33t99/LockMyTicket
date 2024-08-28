package com.ticketbooking.theatreservice.repository;

import com.ticketbooking.theatreservice.model.Seat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query(value = "select * from seat where show_id = :show_id", nativeQuery = true)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Seat> findAllByShow(@Param("show_id") long showId);

}

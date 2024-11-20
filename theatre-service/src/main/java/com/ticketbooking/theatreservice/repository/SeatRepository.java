package com.ticketbooking.theatreservice.repository;

import com.ticketbooking.theatreservice.model.Seat;
import com.ticketbooking.theatreservice.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByShow(Show show);
}

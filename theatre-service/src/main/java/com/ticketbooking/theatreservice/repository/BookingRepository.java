package com.ticketbooking.theatreservice.repository;

import com.ticketbooking.theatreservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Procedure(procedureName = "book_tickets")
    Long bookTickets(@Param("p_seats") String seats, @Param("p_name") String name, @Param("p_showtime") Timestamp showTime);
}

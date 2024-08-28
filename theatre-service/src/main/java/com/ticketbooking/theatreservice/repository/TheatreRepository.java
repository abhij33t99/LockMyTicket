package com.ticketbooking.theatreservice.repository;

import com.ticketbooking.theatreservice.model.City;
import com.ticketbooking.theatreservice.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    List<Theatre> findByCity(City city);
}

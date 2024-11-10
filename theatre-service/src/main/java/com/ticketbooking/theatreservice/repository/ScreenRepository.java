package com.ticketbooking.theatreservice.repository;

import com.ticketbooking.theatreservice.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
}

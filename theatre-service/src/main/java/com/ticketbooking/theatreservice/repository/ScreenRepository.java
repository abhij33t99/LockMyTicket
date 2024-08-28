package com.ticketbooking.theatreservice.repository;

import com.ticketbooking.theatreservice.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {

    @Query(value = "insert into screen(name, seats, theatre_id) values(?, ?, ?)", nativeQuery = true)
    @Modifying
    void save(String name, int seats, long theatre_id);
}

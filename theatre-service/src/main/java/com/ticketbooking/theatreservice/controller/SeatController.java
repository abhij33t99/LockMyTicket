package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.model.Seat;
import com.ticketbooking.theatreservice.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @QueryMapping
    public List<Seat> getAllSeatsByShow(@Argument long showId) {
        return seatService.getAllSeatsByShow(showId);
    }

}

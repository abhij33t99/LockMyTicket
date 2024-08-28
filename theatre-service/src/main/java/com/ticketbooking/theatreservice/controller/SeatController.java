package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.model.Seat;
import com.ticketbooking.theatreservice.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeatsByShow(@RequestParam long showId) {
        return new ResponseEntity<>(seatService.getAllSeatsByShow(showId), HttpStatus.OK);
    }

}

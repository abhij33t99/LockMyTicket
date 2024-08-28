package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.dto.BookingDto;
import com.ticketbooking.theatreservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> bookTickets(@RequestBody BookingDto bookingDto) {
        bookingService.bookTickets(bookingDto);
        return new ResponseEntity<>("Booking successful!", HttpStatus.CREATED);
    }

}

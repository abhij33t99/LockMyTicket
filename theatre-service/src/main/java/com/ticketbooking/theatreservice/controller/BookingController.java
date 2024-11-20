package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.dto.BookingDto;
import com.ticketbooking.theatreservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @MutationMapping
    public Long bookTickets(@Argument("booking") BookingDto bookingDto) {
        return bookingService.bookTickets(bookingDto);
    }

}

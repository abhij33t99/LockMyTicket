package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.dto.BookingDto;
import com.ticketbooking.theatreservice.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    @Transactional
    public void bookTickets(BookingDto bookingDto) {
        String seats = bookingDto.getSeatIds()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        bookingRepository.bookTickets(seats, bookingDto.getName(), LocalDateTime.now());
    }
}

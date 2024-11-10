package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.dto.BookingDto;
import com.ticketbooking.theatreservice.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    @Transactional
    public long bookTickets(BookingDto bookingDto) {
        String seats = bookingDto.getSeatIds()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        return bookingRepository.bookTickets(seats, bookingDto.getName(), Timestamp.from(Instant.now()));
    }
}

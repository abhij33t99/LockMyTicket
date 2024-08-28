package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.model.Seat;
import com.ticketbooking.theatreservice.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public List<Seat> getAllSeatsByShow(long showId) {
        return seatRepository.findAllByShow(showId);
    }
}

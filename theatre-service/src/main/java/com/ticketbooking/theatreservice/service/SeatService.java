package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.constant.Field;
import com.ticketbooking.theatreservice.exception.NotFoundException;
import com.ticketbooking.theatreservice.model.Seat;
import com.ticketbooking.theatreservice.model.Show;
import com.ticketbooking.theatreservice.repository.SeatRepository;
import com.ticketbooking.theatreservice.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    private final ShowRepository showRepository;

    public List<Seat> getAllSeatsByShow(long showId) {
        Show show = showRepository.findById(showId).orElseThrow(() -> new NotFoundException(Field.SHOW, showId));
        return seatRepository.findAllByShow(show);
    }
}

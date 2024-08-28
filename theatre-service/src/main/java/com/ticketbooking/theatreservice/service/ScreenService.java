package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.dto.ScreenDto;
import com.ticketbooking.theatreservice.model.Screen;
import com.ticketbooking.theatreservice.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;

    @Transactional
    public void addScreen(ScreenDto screenDto) {
        this.screenRepository.save(screenDto.getName(), screenDto.getSeats(), screenDto.getTheatreId());
    }
}

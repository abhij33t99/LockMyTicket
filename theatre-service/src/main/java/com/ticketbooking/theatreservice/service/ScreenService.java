package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.constant.Field;
import com.ticketbooking.theatreservice.dto.ScreenDto;
import com.ticketbooking.theatreservice.exception.NotFoundException;
import com.ticketbooking.theatreservice.model.Screen;
import com.ticketbooking.theatreservice.repository.ScreenRepository;
import com.ticketbooking.theatreservice.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    @Transactional
    public Screen addScreen(ScreenDto screenDto) {
        Screen screen = Screen.builder()
                .name(screenDto.getName())
                .seats(screenDto.getSeats())
                .theatre(
                        theatreRepository.findById(screenDto.getTheatreId()).orElseThrow(() -> new NotFoundException(Field.THEATRE, screenDto.getTheatreId()))
                )
                .build();
        return screenRepository.save(screen);
    }
}

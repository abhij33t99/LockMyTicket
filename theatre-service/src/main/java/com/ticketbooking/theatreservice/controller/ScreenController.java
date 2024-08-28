package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.dto.ScreenDto;
import com.ticketbooking.theatreservice.model.Screen;
import com.ticketbooking.theatreservice.repository.ScreenRepository;
import com.ticketbooking.theatreservice.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/screen")
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping
    public ResponseEntity<String> addScreen(@RequestBody ScreenDto screenDto) {
        screenService.addScreen(screenDto);
        return new ResponseEntity<>(screenDto.toString(), HttpStatus.OK);
    }
}

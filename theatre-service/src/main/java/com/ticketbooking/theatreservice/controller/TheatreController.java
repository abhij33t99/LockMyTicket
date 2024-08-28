package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.model.Theatre;
import com.ticketbooking.theatreservice.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    @GetMapping
    public ResponseEntity<List<Theatre>> getTheatresByCity(@RequestParam String city) {
        return new ResponseEntity<>(theatreService.getTheatresByCity(city), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) {
        return new ResponseEntity<>(theatreService.addTheatre(theatre), HttpStatus.CREATED);
    }
}

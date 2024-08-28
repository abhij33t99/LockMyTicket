package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.dto.ShowDto;
import com.ticketbooking.theatreservice.model.Show;
import com.ticketbooking.theatreservice.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping
    public ResponseEntity<List<Show>> getShowsByTheatre(@RequestParam long theatreId, @RequestParam String date) {
        return new ResponseEntity<>(showService.getShowsByTheatreAndDate(theatreId, date), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addShow(@RequestBody ShowDto showDto) {
        showService.addShow(showDto);
        return new ResponseEntity<>("Show has been added successfully!", HttpStatus.CREATED);
    }
}

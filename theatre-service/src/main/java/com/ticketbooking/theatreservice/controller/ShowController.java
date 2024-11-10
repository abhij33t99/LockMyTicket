package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.dto.ShowDto;
import com.ticketbooking.theatreservice.model.Show;
import com.ticketbooking.theatreservice.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @QueryMapping
    public ResponseEntity<List<Show>> getShowsByTheatre(@Argument long theatreId, @Argument String date) {
        return new ResponseEntity<>(showService.getShowsByTheatreAndDate(theatreId, date), HttpStatus.OK);
    }

    @MutationMapping
    public ResponseEntity<String> addShow(@Argument("show") ShowDto showDto) {
        showService.addShow(showDto);
        return new ResponseEntity<>("Show has been added successfully!", HttpStatus.CREATED);
    }
}

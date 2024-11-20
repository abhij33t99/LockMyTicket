package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.dto.TheatreInputDto;
import com.ticketbooking.theatreservice.model.Theatre;
import com.ticketbooking.theatreservice.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    @QueryMapping
    public List<Theatre> getTheatresByCity(@Argument String city) {
        return theatreService.getTheatresByCity(city);
    }

    @MutationMapping
    public Theatre addTheatre(@Argument("theatre") TheatreInputDto theatreInputDto) {
        return theatreService.addTheatre(theatreInputDto);
    }
}

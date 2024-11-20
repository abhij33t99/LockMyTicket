package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.dto.ScreenDto;
import com.ticketbooking.theatreservice.model.Screen;
import com.ticketbooking.theatreservice.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @MutationMapping
    public Screen addScreen(@Argument("screen") ScreenDto screenDto) {
        return screenService.addScreen(screenDto);
    }
}

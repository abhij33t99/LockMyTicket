package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.model.City;
import com.ticketbooking.theatreservice.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @QueryMapping
    public List<City> getCities() {
        return cityService.getCities();
    }

    @MutationMapping
    public List<City> addCities(@Argument List<City> cities) {
        return cityService.addCity(cities);
    }

}

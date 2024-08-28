package com.ticketbooking.theatreservice.controller;

import com.ticketbooking.theatreservice.constant.EndpointConstant;
import com.ticketbooking.theatreservice.model.City;
import com.ticketbooking.theatreservice.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(EndpointConstant.CITIES)
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getCities() {
        return new ResponseEntity<>(cityService.getCities(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<City>> addCities(@RequestBody List<City> city) {
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.CREATED);
    }

}

package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.model.City;
import com.ticketbooking.theatreservice.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public List<City> addCity(List<City> cities) {
        return cityRepository.saveAll(cities);
    }
}

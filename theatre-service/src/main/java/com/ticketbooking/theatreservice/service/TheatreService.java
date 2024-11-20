package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.constant.Field;
import com.ticketbooking.theatreservice.dto.TheatreInputDto;
import com.ticketbooking.theatreservice.exception.NotFoundException;
import com.ticketbooking.theatreservice.model.City;
import com.ticketbooking.theatreservice.model.Theatre;
import com.ticketbooking.theatreservice.repository.CityRepository;
import com.ticketbooking.theatreservice.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheatreService {

    private final TheatreRepository theatreRepository;
    private final CityRepository cityRepository;

    public List<Theatre> getTheatresByCity(String cityName) {
        City city = cityRepository.findByName(cityName)
                .orElseThrow(() -> new NotFoundException(Field.CITY, cityName));
        return theatreRepository.findByCity(city);
    }

    public Theatre addTheatre(TheatreInputDto theatreInputDto) {
        City city = cityRepository.findById(theatreInputDto.getCityId())
                .orElseThrow(() -> new NotFoundException(Field.CITY, theatreInputDto.getCityId()));
        var theatre = Theatre.builder().city(city).name(theatreInputDto.getName()).build();
        return theatreRepository.save(theatre);
    }
}

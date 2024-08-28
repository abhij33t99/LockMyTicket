package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.constant.Field;
import com.ticketbooking.theatreservice.exception.NotFoundException;
import com.ticketbooking.theatreservice.model.City;
import com.ticketbooking.theatreservice.model.Theatre;
import com.ticketbooking.theatreservice.repository.CityRepository;
import com.ticketbooking.theatreservice.repository.TheatreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Theatre addTheatre(Theatre theatre) {
        City city = cityRepository.findById(theatre.getCity().getId())
                .orElseThrow(() -> new NotFoundException(Field.CITY, theatre.getCity().getId()));
        theatre.setCity(city);
        return theatreRepository.save(theatre);
    }
}

package com.ticketbooking.theatreservice.service;

import com.ticketbooking.theatreservice.constant.Field;
import com.ticketbooking.theatreservice.dto.ShowDto;
import com.ticketbooking.theatreservice.exception.NotFoundException;
import com.ticketbooking.theatreservice.model.Movie;
import com.ticketbooking.theatreservice.model.Screen;
import com.ticketbooking.theatreservice.model.Show;
import com.ticketbooking.theatreservice.repository.MovieRepository;
import com.ticketbooking.theatreservice.repository.ScreenRepository;
import com.ticketbooking.theatreservice.repository.ShowRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    public List<Show> getShowsByTheatreAndDate(long theatreId, String date) {
        LocalDate lDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return showRepository.findByTheatreAndDate(theatreId, lDate);
    }

    @Transactional
    public void addShow(ShowDto showDto) {
        Movie movie = movieRepository.findById(showDto.getMovieId())
                .orElseThrow(() -> new NotFoundException(Field.MOVIE, showDto.getMovieId()));
        log.info(movie.toString());
        Screen screen = screenRepository.findById(showDto.getMovieId())
                .orElseThrow(() -> new NotFoundException(Field.SCREEN, showDto.getScreenId()));
        log.info(screen.toString());
        showRepository.addShow(movie.getId(), LocalDateTime.now(), screen.getId());
    }
}

package com.ticketbooking.theatreservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ShowDto {
    private long movieId;
    private long screenId;
    private LocalDateTime showTime;
}

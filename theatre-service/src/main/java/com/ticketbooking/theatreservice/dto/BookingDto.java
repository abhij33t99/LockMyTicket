package com.ticketbooking.theatreservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookingDto {
    private List<Long> seatIds;
    private String name;
}

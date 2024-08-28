package com.ticketbooking.theatreservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScreenDto {
    private String name;
    private long theatreId;
    private int seats;
}

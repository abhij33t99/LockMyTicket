package com.ticketbooking.notificationservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvoiceDto {
    private String name;
    private long bookingId;
    private String movieName;
    private String theatreName;
    private String cityName;
    private double showPrice;
    private int seats;
    private String seatNames;
}

package com.ticketbooking.gatewayservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class User {
    @Id
    private long id;
    private String email;
}

package com.ticketbooking.theatreservice.exception;

import com.ticketbooking.theatreservice.constant.Field;

public class NotFoundException extends RuntimeException{
    public <T> NotFoundException(Field field, T id) {
        super(field.name() + "not found for identifier : "+id);
    }
}

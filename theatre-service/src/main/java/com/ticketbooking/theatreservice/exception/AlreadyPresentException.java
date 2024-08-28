package com.ticketbooking.theatreservice.exception;

import com.ticketbooking.theatreservice.constant.Field;

public class AlreadyPresentException extends RuntimeException{
    public <T> AlreadyPresentException(Field field, T id) {
        super(field.name() + "already present for identifier : "+id);
    }
}

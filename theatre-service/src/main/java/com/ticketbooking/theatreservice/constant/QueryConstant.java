package com.ticketbooking.theatreservice.constant;

public class QueryConstant {
    public static final String SQL_GET_SHOWS_BY_THEATRE_AND_DATE = "select * from show s, screen sc where sc.id = s.screen_id and s.date = :date and sc.theatreId = :theatreId";
}

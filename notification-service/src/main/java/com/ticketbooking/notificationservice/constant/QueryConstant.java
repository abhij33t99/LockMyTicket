package com.ticketbooking.notificationservice.constant;

public class QueryConstant {

    public static final String FETCH_DETAILS_FOR_INVOICE = """
            SELECT
                                        B.NAME AS user,
                                        B.ID AS booking_id,
                                        M.NAME AS movie_name,
                                        T.NAME AS theatre_name,
                                        C.NAME AS city_name,
                                        S.PRICE AS show_price,
                                        COUNT(SE.SEAT_NO) AS SEATS,
                                    	STRING_AGG(SE.SEAT_NO, ',') AS SEAT_NAMES
                                    FROM
                                        BOOKING B
                                        INNER JOIN SHOWS S ON B.SHOW_ID = S.ID
                                    	INNER JOIN SEATS SE ON SE.SHOW_ID = S.ID AND SE.BOOKING_ID = B.ID
                                        INNER JOIN MOVIE M ON M.ID = S.MOVIE_ID
                                        INNER JOIN SCREEN SC ON SC.ID = S.SCREEN_ID
                                        INNER JOIN THEATRE T ON T.ID = SC.THEATRE_ID
                                        INNER JOIN CITY C ON C.id = T.city_id
                                    WHERE
                                        B.ID = 3
                                    GROUP BY B.NAME, M.NAME, T.NAME, C.NAME, S.PRICE, B.ID
            """;
}

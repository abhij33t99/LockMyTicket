package com.ticketbooking.notificationservice.repository;

import com.ticketbooking.notificationservice.constant.QueryConstant;
import com.ticketbooking.notificationservice.dto.InvoiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class InvoiceRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public InvoiceDto fetchNecessaryDetailsForInvoice(long bookingId) {
        Map<String, Object> params = Map.of("bookingId", bookingId);
        return namedParameterJdbcTemplate.queryForObject(QueryConstant.FETCH_DETAILS_FOR_INVOICE, params,
                (rs, rowNum) -> InvoiceDto.builder()
                        .name(rs.getString("user"))
                        .bookingId(rs.getLong("booking_id"))
                        .movieName(rs.getString("movie_name"))
                        .theatreName(rs.getString("theatre_name"))
                        .cityName(rs.getString("city_name"))
                        .showPrice(rs.getDouble("show_price"))
                        .seats(rs.getInt("seats"))
                        .seatNames(rs.getString("seat_names"))
                        .build()
        );
    }
}

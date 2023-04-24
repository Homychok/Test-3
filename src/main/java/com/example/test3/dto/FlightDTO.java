package com.example.test3.dto;

import com.example.test3.model.Flight;
import lombok.Data;

import java.time.Instant;


@Data
public class FlightDTO {
    private String flightNumber;
    private Instant departureDate;
    private Instant arrivalDate;
    private String departureAirportName;
    private String arrivalAirportName;
    private String airlineName;

    public static FlightDTO from(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setDepartureDate(flight.getDepartureDate());
        dto.setArrivalDate(flight.getArrivalDate());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setDepartureAirportName(flight.getDepartureAirport().getName());
        dto.setArrivalAirportName(flight.getArrivalAirport().getName());
        dto.setAirlineName(flight.getAirline().getName());
        return dto;
    }

}
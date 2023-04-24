package com.example.test3.service;

import com.example.test3.dto.FilterDTO;
import com.example.test3.dto.FlightDTO;
import com.example.test3.model.Flight;
import com.example.test3.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.test3.specification.FlightSpecification.byAirline;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getFlightsFiltered(FilterDTO filterDTO) {
        List<Flight> flights = flightRepository.findAll(byAirline(filterDTO.getAirlineName()));
        return flights.stream().map(FlightDTO::from).collect(Collectors.toList());
    }
    public Flight getFlightById(Long id) {
        return null;
    }
    }

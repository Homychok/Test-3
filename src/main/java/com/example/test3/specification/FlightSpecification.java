package com.example.test3.specification;

import com.example.test3.model.Airline;
import com.example.test3.model.Flight;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public class FlightSpecification {
    public static Specification<Flight> byAirline(String airlineName){
        return (root, query, criteriaBuilder) -> {
            if (airlineName == null || airlineName.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            Join<Flight, Airline> airline = root.join("airline");
            return criteriaBuilder.equal(airline.get("name"), airlineName);
        };
    }
    public static Specification<Flight> byAirportName(String airportName){
        return (root, query, criteriaBuilder) -> {
            Join<Flight, Airline> airline = root.join("airline");
            return criteriaBuilder.equal(airline.get("name"), airportName);
        };
    }
        }

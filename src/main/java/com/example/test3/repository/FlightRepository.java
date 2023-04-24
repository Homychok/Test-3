package com.example.test3.repository;
import com.example.test3.model.Flight;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {
    @Override
    @EntityGraph(attributePaths = {"departureAirport","arrivalAirport","airline"})
    List<Flight> findAll(Specification<Flight> spec);

}

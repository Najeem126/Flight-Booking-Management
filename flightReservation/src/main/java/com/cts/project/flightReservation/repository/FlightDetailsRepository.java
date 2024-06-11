package com.cts.project.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.project.flightReservation.model.FlightDetails;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer>{

}

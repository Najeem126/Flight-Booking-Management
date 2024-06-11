package com.cts.project.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.flightReservation.model.RouteDetails;

public interface RouteDetailsRepository extends JpaRepository<RouteDetails, Integer>{
	
}

package com.cts.project.flightReservation.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.flightReservation.exception.DetailsNotFoundException;
import com.cts.project.flightReservation.model.Booking;
import com.cts.project.flightReservation.model.FlightDetails;
import com.cts.project.flightReservation.repository.FlightDetailsRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightService {
	
	@Autowired
	FlightDetailsRepository repo;
	
	@Autowired
	EntityManager em;
	
	
	public FlightDetails save(FlightDetails flight) {
		return repo.save(flight);
	}
	
	public FlightDetails updateflight(FlightDetails route) {
		return repo.save(route);
	}
	
	public Optional<FlightDetails> findByid(int id){
		return repo.findById(id);
	}
	
	public List<FlightDetails> findall(){
		return repo.findAll();
	}
	
	public void deleteByid(int id) {
		repo.deleteById(id);
	}
	
}

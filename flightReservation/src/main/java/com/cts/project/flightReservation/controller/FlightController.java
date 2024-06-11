package com.cts.project.flightReservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.flightReservation.exception.DetailsNotFoundException;
import com.cts.project.flightReservation.model.FlightDetails;
import com.cts.project.flightReservation.service.FlightService;

@RestController
@RequestMapping("/Flight")
public class FlightController {
	
	@Autowired
	FlightService service;
	
	@GetMapping("/{id}")
	public Optional<FlightDetails> retrieveById(@PathVariable int id){
		Optional<FlightDetails> Flight =  service.findByid(id);
		if(Flight.isEmpty()) {
			throw new DetailsNotFoundException("Flight id is invalid:"+id);
		}
		return Flight;
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public List<FlightDetails> retrieveAll(){
		return service.findall();
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public FlightDetails createFlight(@RequestBody FlightDetails route) {
		return service.save(route);
	}
	
	@CrossOrigin
	@PutMapping("/update")
	public FlightDetails updateFlight(@RequestBody FlightDetails route) {
		return service.updateflight(route);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public void deleteId(@PathVariable int id) {
		service.deleteByid(id);
	}
	

}

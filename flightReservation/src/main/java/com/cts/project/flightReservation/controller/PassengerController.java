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

import com.cts.project.flightReservation.DTO.LoginDTO;
import com.cts.project.flightReservation.exception.UserNotFoundException;
import com.cts.project.flightReservation.model.PassengerDetails;
import com.cts.project.flightReservation.service.PassengerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/passenger")
@CrossOrigin("*")
public class PassengerController {
	
	@Autowired
	PassengerService service;
	
	@GetMapping("/gender/{gender}")
	public List<PassengerDetails> retrieveInfoBasedOnGender(@PathVariable String gender){
		
		return service.findByGender(gender);
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public List<PassengerDetails> retrieveAll(){
		return service.FindAll();
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public PassengerDetails addDetails(@RequestBody @Valid PassengerDetails passgenger) {
		return service.createDetails(passgenger);
	}
	
	@CrossOrigin
	@PutMapping("/update/{id}")
	public PassengerDetails updateDetails(@RequestBody PassengerDetails passgenger, @PathVariable int id) {
		return service.updateDetails(passgenger);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Optional<PassengerDetails> findById(@PathVariable int id) {
//		return service.findByid(id);
		Optional<PassengerDetails> passenger = service.findByid(id);
		if(passenger.isEmpty()) {
			throw new UserNotFoundException("Passenger Not found id:"+id);
		}
		
		return passenger;
	}
	
	@CrossOrigin
	@DeleteMapping("delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@DeleteMapping("deleteall")
	public void deleteAll() {
		service.deleteAll();
	}
	  @CrossOrigin
	    @PostMapping("/login")
	    public PassengerDetails findUserByCred(@RequestBody LoginDTO login) {
	       return service.findUserByCred(login.getEmail(), login.getPassword());
	    }
}

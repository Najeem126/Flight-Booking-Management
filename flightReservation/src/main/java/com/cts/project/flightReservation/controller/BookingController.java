package com.cts.project.flightReservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.flightReservation.model.Booking;
import com.cts.project.flightReservation.service.BookingService;

import jakarta.annotation.PostConstruct;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService service;
	
	@GetMapping("/count")
	public Long bookingCount() {
		return service.totalCount();
	}
	
	@GetMapping("/{id}")
	public Optional<Booking> retrieveById(@PathVariable int id){
		return service.findByid(id);
	}
	
	@GetMapping("/all")
	public List<Booking> retrieveAll(){
		return service.findall();
	}
	
	@PostMapping("/add")
	public String addBooking(@RequestBody Booking booking) {
		return service.save(booking);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteBooking(id);
	}
	
	@DeleteMapping("/cancel/{pnr}")
	public String cancelticket(@PathVariable String pnr) {
		return service.cancelTicket(pnr);
	}
	
	@GetMapping("/flightId/{flightid}")
	public Booking getBookingByPassengerId(@PathVariable int flightid) {
		return service.bookingByPassengerId(flightid);
	}
	
	@GetMapping("pass/{id}")
	public Optional<Booking> findByPassenger(@PathVariable int id) {
		return service.findByPassenger(id);
	}
	
	
	
}

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
import com.cts.project.flightReservation.model.RouteDetails;
import com.cts.project.flightReservation.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	
	@Autowired
	RouteService service;
	
	@GetMapping("/{id}")
	public Optional<RouteDetails> retrieveById(@PathVariable int id){
		Optional<RouteDetails> route = service.findByid(id);
		
		if(route.isEmpty()) {
			throw new DetailsNotFoundException("Not Found in the id:"+id);
		}
		
		return route;
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public List<RouteDetails> retrieveAll(){
		return service.findall();
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public RouteDetails createRoute(@RequestBody RouteDetails route) {
		return service.save(route);
	}
	
	@CrossOrigin
	@PutMapping("/update")
	public RouteDetails updateRoute(@RequestBody RouteDetails route) {
		return service.save(route);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public void deleteId(@PathVariable int id) {
		service.deleteByid(id);
	}
	
}

package com.cts.project.flightReservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.flightReservation.model.AuthenticationResponse;
import com.cts.project.flightReservation.model.PassengerDetails;
import com.cts.project.flightReservation.service.AuthenticationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthenticationController {
 
    private final AuthenticationService authService;
 
    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }
 
 
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody PassengerDetails request
            ) {
        return ResponseEntity.ok(authService.register(request));
    }
 
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody PassengerDetails request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}

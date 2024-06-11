package com.cts.project.flightReservation.model;

public class AuthenticationResponse {
	
    private String token;

    private String message;
    
    private PassengerDetails passenger;

	public AuthenticationResponse(String token, String message, PassengerDetails passenger) {
		super();
		this.token = token;
		this.message = message;
		this.passenger = passenger;
	}

	public String getToken() {
		return token;
	}

	public String getMessage() {
		return message;
	}

	public PassengerDetails getPassenger() {
		return passenger;
	}

    
}

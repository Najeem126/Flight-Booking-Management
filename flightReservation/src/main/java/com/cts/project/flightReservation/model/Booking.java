package com.cts.project.flightReservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="id" , sequenceName = "id" , initialValue = 20001)
public class Booking {
	
	@Id
	@GeneratedValue(generator = "id")
	@Column(name="booking_id")
	private int bookingId;
	
	private String pnr;
	
	private int seatsRequired;
	
	private String seatNumbers;
	
	@ManyToOne
	private PassengerDetails passenger;
	
	@ManyToOne	
	private FlightDetails flight;
	
	
	
	public Booking() {
		
	}
	
	public Booking(int bookingId, String pnr, int seatsRequired, String seatNumbers) {
		super();
		this.bookingId = bookingId;
		this.pnr = pnr;
		this.seatsRequired = seatsRequired;
		this.seatNumbers = seatNumbers;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public int getSeatsRequired() {
		return seatsRequired;
	}

	public void setSeatsRequired(int seatsRequired) {
		this.seatsRequired = seatsRequired;
	}

	public String getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public PassengerDetails getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerDetails passenger) {
		this.passenger = passenger;
	}

	public FlightDetails getFlight() {
		return flight;
	}

	public void setFlight(FlightDetails flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", pnr=" + pnr + ", seatsRequired=" + seatsRequired
				+ ", seatNumbers=" + seatNumbers + ", passenger=" + passenger + ", flight=" + flight + "]";
	}
	
	
}

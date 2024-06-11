//
//package com.cts.project.flightReservation.model;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.SequenceGenerator;
//import jakarta.persistence.Table;
//
//@Entity
//@SequenceGenerator(name="train_id",sequenceName="train_id",initialValue=10003)
//@Table(name="flight")
//public class FlightDetails {
//	
//	@Id
//	@Column(name="flight_id")
//	private int flightId;
//	
//	@OneToOne(mappedBy = "flight")
//	@JsonIgnore
//	private Booking booking;
//	
//	@Column(name="flight_name")
//	private String flightName;
//	
//	@Column(name="flight_class")
//	private String flightClass;
//	
//	private int capacity;
//	
//	private double price;
//	
//	private LocalDate date;
//	
//	private LocalTime timing;
//	
//	
//
//	@OneToMany(mappedBy = "flight")
//	@JsonIgnore
//	private List<RouteDetails> route = new ArrayList<>();
//	


package com.cts.project.flightReservation.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@SequenceGenerator(name="flight_id",sequenceName="flight_id",initialValue=10003)
@Table(name="flight")
public class FlightDetails {
	
	@Id
	@GeneratedValue(generator="flight_id")
	private int flightId;
	
	@OneToMany(mappedBy = "flight" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> booking = new ArrayList<>();
	
	private String flightName;
	
	private String flightClass;
	
	private int capacity;
	
	private LocalDate date;
	
	private LocalTime timing;
	
	@ManyToOne
	private RouteDetails route;

	public FlightDetails() {
	}

	public FlightDetails(int flightId, String flightName, String flightClass, int capacity, LocalDate date,
			LocalTime timing) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.flightClass = flightClass;
		this.capacity = capacity;
		this.date = date;
		this.timing = timing;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTiming() {
		return timing;
	}

	public void setTiming(LocalTime timing) {
		this.timing = timing;
	}

	public RouteDetails getRoute() {
		return route;
	}

	public void setRoute(RouteDetails route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", booking=" + booking + ", flightName=" + flightName
				+ ", flightClass=" + flightClass + ", capacity=" + capacity + ", date=" + date + ", timing=" + timing
				+ ", route=" + route + "]";
	}

//	public List<RouteDetails> getRoute() {
//		return route;
//	}
//
//	public void setRoute(List<RouteDetails> route) {
//		this.route = route;
//	}

//	@Override
//	public String toString() {
//		return "FlightDetails [flightId=" + flightId + ", booking=" + booking + ", flightName=" + flightName
//				+ ", flightClass=" + flightClass + ", capacity=" + capacity + ", date=" + date + ", timing=" + timing
//				+ ", route=" + route + "]";
//	}
	
}
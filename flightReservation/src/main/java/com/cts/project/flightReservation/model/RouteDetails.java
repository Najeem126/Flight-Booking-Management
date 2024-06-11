package com.cts.project.flightReservation.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="route")
public class RouteDetails {
	
	@Id
	@Column(name="route_id")
	@GeneratedValue
	private int routeId;
	
	private String source;
	
	private String destination;
	
	@JsonIgnore
	@OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
	private List<FlightDetails> flight = new ArrayList<>();

	public RouteDetails() {
		
	}

	public RouteDetails(int routeId, String source, String destination) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

//	public FlightDetails getFlight() {
//		return flight;
//	}
//
//	public void setFlight(FlightDetails flight) {
//		this.flight = flight;
//	}

//	@Override
//	public String toString() {
//		return "RouteDetails [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", flight="
//				+ flight + "]";
//	}

	public List<FlightDetails> getFlight() {
		return flight;
	}

	public void setFlight(List<FlightDetails> flight) {
		this.flight = flight;
	}
	
	@Override
	public String toString() {
		return "RouteDetails [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", flight="
				+ flight + "]";
	}
}
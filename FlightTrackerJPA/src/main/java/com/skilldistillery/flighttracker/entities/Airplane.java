package com.skilldistillery.flighttracker.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Airplane {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="airline_id")
	private Airline airline;
	@ManyToOne
	@JoinColumn(name="airplane_type_id")
	private AirplaneType airplaneType;
	@OneToMany(mappedBy="airplane")
	private List<Flight> flights;
	
	/*
	 * getters / setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public AirplaneType getAirplaneType() {
		return airplaneType;
	}
	public void setAirplaneType(AirplaneType airplaneType) {
		this.airplaneType = airplaneType;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Airplane [id=").append(id)
				.append(", airline=").append(airline)
				.append(", airplaneType=").append(airplaneType)
				.append(", flights=").append(flights.size())
				.append("]");
		return builder.toString();
	}
	
	public Airplane() {
		super();
	}
	
	public Airplane(int id, Airline airline, AirplaneType airplaneType, List<Flight> flights) {
		super();
		this.id = id;
		this.airline = airline;
		this.airplaneType = airplaneType;
		this.flights = flights;
	}
	
	
}

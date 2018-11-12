package com.skilldistillery.flighttracker.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="seats_occupied")
	private Integer seatsOccupied;
	@Column(name="scheduled_departure")
	private Date scheduledDeparture;
	@Column(name="actual_departure")
	private Date actualDeparture;
	@Column(name="scheduled_arrival")
	private Date scheduledArrival;
	@Column(name="actual_arrival")
	private Date actualArrival;
	@Column(name="flight_number")
	private String flightNumer;
	@Column(name="number_of_stops")
	private Integer numberOfStops;
	private boolean available;
	@ManyToOne
	@JoinColumn(name="airplane_id")
	private Airplane airplane;
	@ManyToOne
	@JoinColumn(name="departure_airport")
	private Airport departureAirport;
	@ManyToOne
	@JoinColumn(name="arrival_airport")
	private Airport arrivalAirport;
	
	/*
	 * getters / setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getSeatsOccupied() {
		return seatsOccupied;
	}

	public void setSeatsOccupied(Integer seatsOccupied) {
		this.seatsOccupied = seatsOccupied;
	}

	public Date getScheduledDeparture() {
		return scheduledDeparture;
	}

	public void setScheduledDeparture(Date scheduledDeparture) {
		this.scheduledDeparture = scheduledDeparture;
	}

	public Date getActualDeparture() {
		return actualDeparture;
	}

	public void setActualDeparture(Date actualDeparture) {
		this.actualDeparture = actualDeparture;
	}

	public Date getScheduledArrival() {
		return scheduledArrival;
	}

	public void setScheduledArrival(Date scheduledArrival) {
		this.scheduledArrival = scheduledArrival;
	}

	public Date getActualArrival() {
		return actualArrival;
	}

	public void setActualArrival(Date actualArrival) {
		this.actualArrival = actualArrival;
	}

	public String getFlightNumer() {
		return flightNumer;
	}

	public void setFlightNumer(String flightNumer) {
		this.flightNumer = flightNumer;
	}

	public Integer getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(Integer numberOfStops) {
		this.numberOfStops = numberOfStops;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
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
		Flight other = (Flight) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [id=").append(id)
				.append(", seatsOccupied=").append(seatsOccupied)
				.append(", scheduledDeparture=").append(scheduledDeparture)
				.append(", actualDeparture=").append(actualDeparture)
				.append(", scheduledArrival=").append(scheduledArrival)
				.append(", actualArrival=").append(actualArrival)
				.append(", flightNumer=").append(flightNumer)
				.append(", numberOfStops=").append(numberOfStops)
				.append(", available=").append(available)
				.append(", airplane=").append(airplane)
				.append(", departureAirport=").append(departureAirport)
				.append(", arrivalAirport=").append(arrivalAirport)
				.append("]");
		return builder.toString();
	}
	
	public Flight() {
		super();
	}

	public Flight(int id, Integer seatsOccupied, Date scheduledDeparture, Date actualDeparture, Date scheduledArrival,
			Date actualArrival, String flightNumer, Integer numberOfStops, boolean available, Airplane airplane,
			Airport departureAirport, Airport arrivalAirport) {
		super();
		this.id = id;
		this.seatsOccupied = seatsOccupied;
		this.scheduledDeparture = scheduledDeparture;
		this.actualDeparture = actualDeparture;
		this.scheduledArrival = scheduledArrival;
		this.actualArrival = actualArrival;
		this.flightNumer = flightNumer;
		this.numberOfStops = numberOfStops;
		this.available = available;
		this.airplane = airplane;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}
	
	
}

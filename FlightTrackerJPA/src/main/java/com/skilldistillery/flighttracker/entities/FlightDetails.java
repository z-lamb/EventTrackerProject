package com.skilldistillery.flighttracker.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight_details")
public class FlightDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String airline;
	@Column(name="airplane_capacity")
	private Integer airplaneCapacity;
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
	@Column(name="departure_airport")
	private String departureAirport;
	@Column(name="arrival_airport")
	private String arrivalAirport;
	private String airplane;
	@Column(name="flight_number")
	private String flightNumer;
	@Column(name="number_of_stops")
	private Integer numberOfStops;
	
	/*
	 * getters / setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public Integer getAirplaneCapacity() {
		return airplaneCapacity;
	}
	public void setAirplaneCapacity(Integer airlineCapacity) {
		this.airplaneCapacity = airlineCapacity;
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
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public String getAirplane() {
		return airplane;
	}
	public void setAirplane(String airplane) {
		this.airplane = airplane;
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
		FlightDetails other = (FlightDetails) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlightDetails [id=").append(id)
				.append(", airline=").append(airline)
				.append(", airlineCapacity=").append(airplaneCapacity)
				.append(", seatsOccupied=").append(seatsOccupied)
				.append(", scheduledDeparture=").append(scheduledDeparture)
				.append(", actualDeparture=").append(actualDeparture)
				.append(", scheduledArrival=").append(scheduledArrival)
				.append(", actualArrival=").append(actualArrival)
				.append(", departureAirport=").append(departureAirport)
				.append(", arrivalAirport=").append(arrivalAirport)
				.append(", airplane=").append(airplane)
				.append(", flightNumer=").append(flightNumer)
				.append(", numberOfStops=").append(numberOfStops)
				.append("]");
		return builder.toString();
	}
	
	public FlightDetails() {
		super();
	}
	
	public FlightDetails(int id, String airline, Integer airplaneCapacity, Integer seatsOccupied, Date scheduledDeparture,
			Date actualDeparture, Date scheduledArrival, Date actualArrival, String departureAirport,
			String arrivalAirport, String airplane, String flightNumer, Integer numberOfStops) {
		super();
		this.id = id;
		this.airline = airline;
		this.airplaneCapacity = airplaneCapacity;
		this.seatsOccupied = seatsOccupied;
		this.scheduledDeparture = scheduledDeparture;
		this.actualDeparture = actualDeparture;
		this.scheduledArrival = scheduledArrival;
		this.actualArrival = actualArrival;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.airplane = airplane;
		this.flightNumer = flightNumer;
		this.numberOfStops = numberOfStops;
	}
}

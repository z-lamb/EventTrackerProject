package com.skilldistillery.flighttracker.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String code;
	private String city;
	private String state;
	private String country;
	@OneToMany(mappedBy="departureAirport")
	private List<Flight> departureAirport;
	@OneToMany(mappedBy="arrivalAirport")
	private List<Flight> arrivalAirport;
	
	/*
	 * getters / setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Flight> getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(List<Flight> departureAirport) {
		this.departureAirport = departureAirport;
	}
	public List<Flight> getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(List<Flight> arrivalAirport) {
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
		Airport other = (Airport) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Airport [id=").append(id)
				.append(", name=").append(name)
				.append(", code=").append(code)
				.append(", city=").append(city)
				.append(", state=").append(state)
				.append(", country=").append(country)
				.append(", departureAirport=").append(departureAirport.size())
				.append(", arrivalAirport=").append(arrivalAirport.size())
				.append("]");
		return builder.toString();
	}
	
	public Airport() {
		super();
	}
	
	public Airport(int id, String name, String code, String city, String state, String country,
			List<Flight> departureAirport, List<Flight> arrivalAirport) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.city = city;
		this.state = state;
		this.country = country;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}
	
	
}

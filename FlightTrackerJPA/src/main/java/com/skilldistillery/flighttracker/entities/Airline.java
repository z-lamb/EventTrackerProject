package com.skilldistillery.flighttracker.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airline {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "airline")
	private List<Airplane> airplanes;
	
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
	
	public List<Airplane> getAirplanes() {
		return airplanes;
	}
	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
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
		Airline other = (Airline) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Airline [id=").append(id)
		.append(", name=").append(name)
		.append(", airplanes=").append(airplanes.size())
		.append("]");
		return builder.toString();
	}
	
	public Airline() {
		super();
	}
	
	public Airline(int id, String name, List<Airplane> airplanes) {
		super();
		this.id = id;
		this.name = name;
		this.airplanes = airplanes;
	}
}

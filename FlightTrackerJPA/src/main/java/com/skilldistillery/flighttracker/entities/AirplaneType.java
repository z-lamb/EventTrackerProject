package com.skilldistillery.flighttracker.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="airplane_type")
public class AirplaneType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String maker;
	private String type;
	private Integer capacity;
	private Boolean wifi;
	@JsonIgnore
	@OneToMany(mappedBy="airplaneType")
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
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Boolean getWifi() {
		return wifi;
	}
	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
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
		AirplaneType other = (AirplaneType) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirplaneType [id=").append(id)
				.append(", maker=").append(maker)
				.append(", type=").append(type)
				.append(", capacity=").append(capacity)
				.append(", wifi=").append(wifi)
				.append("]");
		return builder.toString();
	}
	
	public AirplaneType() {
		super();
	}
	
	public AirplaneType(int id, String maker, String type, Integer capacity, Boolean wifi, List<Airplane> airplanes) {
		super();
		this.id = id;
		this.maker = maker;
		this.type = type;
		this.capacity = capacity;
		this.wifi = wifi;
		this.airplanes = airplanes;
	}
}

package com.skilldistillery.flighttracker.service;

import java.util.List;

import com.skilldistillery.flighttracker.entities.Airline;

public interface AirlineService {

	List<Airline> findAll();

	Airline findById(int airlineId);

	Airline create(Airline airline);

	boolean delete(int airlineId);

	Airline update(int airlineId, Airline airline);

}

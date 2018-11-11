package com.skilldistillery.flighttracker.service;

import java.util.List;

import com.skilldistillery.flighttracker.entities.FlightDetails;

public interface FlightDetailsService {

	List<FlightDetails> findAll();

	FlightDetails findById(int flightId);

	FlightDetails create(FlightDetails flightDetails);

	boolean delete(int flightId);

	FlightDetails update(int flightId, FlightDetails flightDetails);

	FlightDetails patch(int flightId, FlightDetails flightDetails);

}

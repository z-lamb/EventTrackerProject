package com.skilldistillery.flighttracker.service;

import java.util.List;

import com.skilldistillery.flighttracker.entities.Flight;

public interface FlightDetailsService {

	List<Flight> findAll();

	Flight findById(int flightId);

	Flight create(Flight flightDetails);

	boolean delete(int flightId);

	Flight update(int flightId, Flight flightDetails);

	Flight patch(int flightId, Flight flightDetails);

}

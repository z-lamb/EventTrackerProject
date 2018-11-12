package com.skilldistillery.flighttracker.service;

import java.util.List;

import com.skilldistillery.flighttracker.entities.Flight;

public interface FlightService {

	List<Flight> findAll();

	Flight findById(int flightId);

	Flight create(Flight flight, int arrivalId, int departureId, int airplaneId);

	boolean delete(int flightId);

	Flight update(int flightId, Flight flight);

	Flight patch(int flightId, Flight flight);


}

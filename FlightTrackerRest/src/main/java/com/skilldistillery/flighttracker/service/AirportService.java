package com.skilldistillery.flighttracker.service;

import java.util.List;

import com.skilldistillery.flighttracker.entities.Airport;

public interface AirportService {

	List<Airport> findAll();

	Airport findById(int airportId);

	Airport create(Airport airport);

	boolean delete(int airportId);

	Airport update(int airportId, Airport airport);

	Airport patch(int airportId, Airport airport);

	Airport findByCode(String airportCode);

}

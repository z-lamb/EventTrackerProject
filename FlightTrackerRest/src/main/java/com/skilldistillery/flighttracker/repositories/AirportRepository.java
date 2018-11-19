package com.skilldistillery.flighttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.flighttracker.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
	
	@Query("SELECT airport FROM Airport airport WHERE airport.code = :airportCode")
	Airport findByCode(@Param("airportCode") String airportCode);

}

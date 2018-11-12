package com.skilldistillery.flighttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.flighttracker.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer> {

}

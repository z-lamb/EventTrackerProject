package com.skilldistillery.flighttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.flighttracker.entities.Flight;


public interface FlightDetailsRepository extends JpaRepository<Flight, Integer> {

}

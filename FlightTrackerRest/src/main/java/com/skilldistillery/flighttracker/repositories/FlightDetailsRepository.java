package com.skilldistillery.flighttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.flighttracker.entities.FlightDetails;


public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer> {

}

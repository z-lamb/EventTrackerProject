package com.skilldistillery.flighttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.flighttracker.entities.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {

}

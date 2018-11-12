package com.skilldistillery.flighttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.flighttracker.entities.AirplaneType;

public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Integer> {

}

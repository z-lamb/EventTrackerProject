package com.skilldistillery.flighttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.flighttracker.entities.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {

}

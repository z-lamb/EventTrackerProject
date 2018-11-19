package com.skilldistillery.flighttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skilldistillery.flighttracker.entities.AirplaneType;

public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Integer> {

	@Query("SELECT COUNT(airplaneType) FROM AirplaneType airplaneType WHERE airplaneType.wifi = 1")
	Integer numberOfWifiPlanes();

}

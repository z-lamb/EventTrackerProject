package com.skilldistillery.flighttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.flighttracker.entities.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {

	@Query(value="SELECT airplane.id FROM airplane" + 
					"JOIN airline ON airplane.airline_id = airline.id\n" + 
					"JOIN airplane_type ON airplane.airplane_type_id = airplane_type.id" + 
					"JOIN flight ON airplane.id = flight.airplane_id" + 
					"WHERE airline.name = :airlineName " + 
					"AND airplane_type.maker = :airplaneTypeMaker" + 
					"AND airplane_type.type = :airplaneTypeName" + 
					"AND flight.id = 1", nativeQuery=true)
	Airplane airplaneByAirlineNameAndAirplaneTypeName(
			@Param("airlineName") String airlineName, 
			@Param("airplaneTypeName") String airplaneTypeName);

}

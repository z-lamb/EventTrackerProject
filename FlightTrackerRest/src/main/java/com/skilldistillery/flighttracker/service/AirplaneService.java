package com.skilldistillery.flighttracker.service;

import java.util.List;

import com.skilldistillery.flighttracker.entities.Airplane;

public interface AirplaneService {

	List<Airplane> findAll();

	Airplane findById(int airplaneId);

	Airplane create(int airlineId, int airplaneTypeId);

	boolean delete(int airplaneId);

	Airplane patch(int airplaneId, int airlineId, int airplaneTypeId);

}

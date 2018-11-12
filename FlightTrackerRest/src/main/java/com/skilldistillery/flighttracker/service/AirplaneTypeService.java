package com.skilldistillery.flighttracker.service;

import java.util.List;

import com.skilldistillery.flighttracker.entities.AirplaneType;

public interface AirplaneTypeService {

	List<AirplaneType> findAll();

	AirplaneType findById(int airplaneTypeId);

	AirplaneType create(AirplaneType airplaneType);

	boolean delete(int airplaneTypeId);

	AirplaneType update(int airplaneTypeId, AirplaneType airplaneType);

	AirplaneType patch(int airplaneTypeId, AirplaneType airplaneType);

}

package com.skilldistillery.flighttracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.entities.Airline;
import com.skilldistillery.flighttracker.entities.Airplane;
import com.skilldistillery.flighttracker.entities.AirplaneType;
import com.skilldistillery.flighttracker.entities.Airport;
import com.skilldistillery.flighttracker.repositories.AirlineRepository;
import com.skilldistillery.flighttracker.repositories.AirplaneRepository;
import com.skilldistillery.flighttracker.repositories.AirplaneTypeRepository;

@Service
public class AirplaneServiceImpl implements AirplaneService {

	@Autowired
	private AirplaneRepository airplaneRepo;
	@Autowired
	private AirlineRepository airlineRepo;
	@Autowired
	private AirplaneTypeRepository airplaneTypeRepository;
	
	@Override
	public List<Airplane> findAll(){
		return airplaneRepo.findAll();
	}
	
	@Override
	public Airplane findById(int airplaneId) {
		Airplane findById = null;
		Optional<Airplane> optionalAirplane = airplaneRepo.findById(airplaneId);
		if( optionalAirplane.isPresent()) {
			findById = optionalAirplane.get();
		}
		return findById;
	}

	@Override
	public Airplane create(int airlineId, int airplaneTypeId) {
		Airplane newAirplane = null;
		Airline airline = null;
		AirplaneType airplaneType = null;
		Optional<Airline> optionalAirline = airlineRepo.findById(airlineId);
		if(optionalAirline.isPresent()) {
			airline = optionalAirline.get();
			newAirplane = new Airplane();
			newAirplane.setAirline(airline);
			Optional<AirplaneType> optionalAirplaneType = airplaneTypeRepository.findById(airplaneTypeId);
			if(optionalAirplaneType.isPresent()) {
				airplaneType = optionalAirplaneType.get();
				newAirplane.setAirplaneType(airplaneType);
				newAirplane = airplaneRepo.saveAndFlush(newAirplane);
			}
		}
		return newAirplane;
	}
	
	@Override
	public boolean delete(int airplaneId) {
		boolean deleted = false;
		if(airplaneRepo.existsById(airplaneId)) {
			airplaneRepo.deleteById(airplaneId);
			deleted = true;
		}
		return deleted;
	}
	
	@Override
	public Airplane patch(int airplaneId, int airlineId, int airplaneTypeId) {
		Airplane patchedAirplane = null;
		Airline airline = null;
		AirplaneType airplaneType = null;
		Optional<Airplane> optionalAirplane = airplaneRepo.findById(airplaneId);
		if(optionalAirplane.isPresent()) {
			patchedAirplane = optionalAirplane.get();
			Optional<Airline> optionalAirline = airlineRepo.findById(airlineId);
			if(optionalAirline.isPresent()) {
				airline = optionalAirline.get();
				patchedAirplane.setAirline(airline);
				Optional<AirplaneType> optionalAirplaneType = airplaneTypeRepository.findById(airplaneTypeId);
				if(optionalAirplaneType.isPresent()) {
					airplaneType = optionalAirplaneType.get();
					patchedAirplane.setAirplaneType(airplaneType);
					patchedAirplane = airplaneRepo.saveAndFlush(patchedAirplane);
				}
			}
		}
		return patchedAirplane;
	}

	@Override
	public Airplane airplaneByAirlineNameAndAirplaneTypeName(String airlineName, String airplaneTypeName) {
		Airplane airplaneByAirlineNameAndAirplaneTypeName = null;
		Airplane foundAirplane = airplaneRepo.airplaneByAirlineNameAndAirplaneTypeName(airlineName, airplaneTypeName);
		if(foundAirplane != null) {
			airplaneByAirlineNameAndAirplaneTypeName = foundAirplane;
		}
		return airplaneByAirlineNameAndAirplaneTypeName;
	}
	
}

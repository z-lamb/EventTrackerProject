package com.skilldistillery.flighttracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.entities.Airline;
import com.skilldistillery.flighttracker.repositories.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepo;

	@Override
	public List<Airline> findAll() {
		return airlineRepo.findAll();
	}

	@Override
	public Airline findById(int airlineId) {
		Airline findById = null;
		Optional<Airline> optionalAirline = airlineRepo.findById(airlineId);
		if(optionalAirline.isPresent()) {
			findById = optionalAirline.get();
		}
		return findById;
	}
	
	@Override
	public Airline create(Airline airline) {
		Airline newAirline = null;
		newAirline = airlineRepo.saveAndFlush(airline);
		return newAirline;
	}
	
	@Override
	public boolean delete(int airlineId) {
		boolean deleted = false;
		if(airlineRepo.existsById(airlineId)) {
			airlineRepo.deleteById(airlineId);
			deleted = true;
		}
		return deleted;
	}
	
	@Override
	public Airline update(int airlineId, Airline airline) {
		Airline updatedAirline = null;
		Optional<Airline> optionalAirline = airlineRepo.findById(airlineId);
		if(optionalAirline.isPresent()) {
			updatedAirline = optionalAirline.get();
			updatedAirline.setName(airline.getName());
			updatedAirline = airlineRepo.saveAndFlush(updatedAirline);
		}
		return updatedAirline;
	}
}

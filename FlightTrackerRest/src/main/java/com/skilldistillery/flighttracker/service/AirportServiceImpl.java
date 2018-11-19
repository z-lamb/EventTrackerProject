package com.skilldistillery.flighttracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.entities.Airport;
import com.skilldistillery.flighttracker.repositories.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportRepository airportRepo;

	@Override
	public List<Airport> findAll() {
		return airportRepo.findAll();
	}

	@Override
	public Airport findById(int airportId) {
		Airport findById = null;
		Optional<Airport> optionalAirport = airportRepo.findById(airportId);
		if (optionalAirport.isPresent()) {
			findById = optionalAirport.get();
		}
		return findById;
	}

	@Override
	public Airport create(Airport airport) {
		Airport newAirport = null;
		newAirport = airportRepo.saveAndFlush(airport);
		return newAirport;
	}

	@Override
	public boolean delete(int airportId) {
		boolean deleted = false;
		if (airportRepo.existsById(airportId)) {
			airportRepo.deleteById(airportId);
			deleted = true;
		}
		return deleted;
	}

	@Override
	public Airport update(int airportId, Airport airport) {
		Airport updatedAirport = null;
		Optional<Airport> optionalAirport = airportRepo.findById(airportId);
		if (optionalAirport.isPresent()) {
			updatedAirport = optionalAirport.get();
			updatedAirport.setName(airport.getName());
			updatedAirport.setCode(airport.getCode());
			updatedAirport.setCity(airport.getCity());
			updatedAirport.setState(airport.getState());
			updatedAirport.setCountry(airport.getCountry());
			updatedAirport = airportRepo.saveAndFlush(updatedAirport);
		}
		return updatedAirport;
	}

	@Override
	public Airport patch(int airportId, Airport airport) {
		Airport patchedAirport = null;
		Optional<Airport> optionalAirport = airportRepo.findById(airportId);
		if (optionalAirport.isPresent()) {
			patchedAirport = optionalAirport.get();
			if (airport.getName() != null) {
				patchedAirport.setName(airport.getName());
			}
			if (airport.getCode() != null) {
				patchedAirport.setCode(airport.getCode());
			}
			if (airport.getCity() != null) {
				patchedAirport.setCity(airport.getCity());
			}
			if (airport.getState() != null) {
				patchedAirport.setState(airport.getState());
			}
			if (airport.getCountry() != null) {
				patchedAirport.setCountry(airport.getCountry());
			}
			patchedAirport = airportRepo.saveAndFlush(patchedAirport);
		}
		return patchedAirport;
	}

	@Override
	public Airport findByCode(String airportCode) {
		Airport findByCode = null;
		Airport airportFromCode = airportRepo.findByCode(airportCode);
		if(airportFromCode != null) {
			findByCode = airportFromCode;
		}
		return findByCode;
	}
}

package com.skilldistillery.flighttracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.entities.Airplane;
import com.skilldistillery.flighttracker.entities.AirplaneType;
import com.skilldistillery.flighttracker.repositories.AirplaneTypeRepository;

@Service
public class AirplaneTypeServiceImpl implements AirplaneTypeService {

	@Autowired
	private AirplaneTypeRepository airplaneTypeRepo;

	@Override
	public List<AirplaneType> findAll() {
		return airplaneTypeRepo.findAll();
	}

	@Override
	public AirplaneType findById(int airplaneTypeId) {
		AirplaneType findById = null;
		Optional<AirplaneType> optionalAirplaneType = airplaneTypeRepo.findById(airplaneTypeId);
		if (optionalAirplaneType.isPresent()) {
			findById = optionalAirplaneType.get();
		}
		return findById;
	}

	@Override
	public AirplaneType create(AirplaneType airplaneType) {
		AirplaneType newAirplaneType = null;
		newAirplaneType = airplaneTypeRepo.saveAndFlush(airplaneType);
		return newAirplaneType;
	}

	@Override
	public boolean delete(int airplaneTypeId) {
		boolean deleted = false;
		if (airplaneTypeRepo.existsById(airplaneTypeId)) {
			airplaneTypeRepo.deleteById(airplaneTypeId);
			deleted = true;
		}
		return deleted;
	}

	@Override
	public AirplaneType update(int airplaneTypeId, AirplaneType airplaneType) {
		AirplaneType updatedAirplaneType = null;
		Optional<AirplaneType> optionalAirplaneType = airplaneTypeRepo.findById(airplaneTypeId);
		if (optionalAirplaneType.isPresent()) {
			updatedAirplaneType = optionalAirplaneType.get();
			updatedAirplaneType.setMaker(airplaneType.getMaker());
			updatedAirplaneType.setType(airplaneType.getType());
			updatedAirplaneType.setCapacity(airplaneType.getCapacity());
			updatedAirplaneType.setWifi(airplaneType.getWifi());
			updatedAirplaneType = airplaneTypeRepo.saveAndFlush(updatedAirplaneType);
		}
		return updatedAirplaneType;
	}

	@Override
	public AirplaneType patch(int airplaneTypeId, AirplaneType airplaneType) {
		AirplaneType patchedAirplaneType = null;
		Optional<AirplaneType> optionalAirplaneType = airplaneTypeRepo.findById(airplaneTypeId);
		if (optionalAirplaneType.isPresent()) {
			patchedAirplaneType = optionalAirplaneType.get();
			if (airplaneType.getMaker() != null) {
				patchedAirplaneType.setMaker(airplaneType.getMaker());
			}
			if (airplaneType.getType() != null) {
				patchedAirplaneType.setType(airplaneType.getType());
			}
			if (airplaneType.getCapacity() != null) {
				patchedAirplaneType.setCapacity(airplaneType.getCapacity());
			}
			if (airplaneType.getWifi() != null) {
				patchedAirplaneType.setWifi(airplaneType.getWifi());
			}
			patchedAirplaneType = airplaneTypeRepo.saveAndFlush(patchedAirplaneType);
		}
		return patchedAirplaneType;
	}
}

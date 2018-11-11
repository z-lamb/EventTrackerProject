package com.skilldistillery.flighttracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.entities.FlightDetails;
import com.skilldistillery.flighttracker.repositories.FlightDetailsRepository;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	@Autowired
	private FlightDetailsRepository flightDetailsRepo;
	
	@Override
	public List<FlightDetails> findAll(){
		return flightDetailsRepo.findAll();
	}
	
	@Override
	public FlightDetails findById(int flightId) {
		FlightDetails findById = null;
		Optional<FlightDetails> optionalFlightDetails = flightDetailsRepo.findById(flightId);
		if(optionalFlightDetails.isPresent()) {
			findById = optionalFlightDetails.get();
		}
		return findById;
	}
	
	@Override
	public FlightDetails create(FlightDetails flightDetails) {
		FlightDetails newFlightDetails = null;
		newFlightDetails = flightDetailsRepo.saveAndFlush(flightDetails);
		return newFlightDetails;
	}

	@Override
	public boolean delete(int flightId) {
		boolean deleted = false;
		if(flightDetailsRepo.existsById(flightId)) {
			flightDetailsRepo.deleteById(flightId);
			deleted = true;
		}
		return deleted;
	}

	@Override
	public FlightDetails update(int flightId, FlightDetails flightDetails) {
		FlightDetails updatedFlight = null;
		Optional<FlightDetails> optionalFlightDetails = flightDetailsRepo.findById(flightId);
		if(optionalFlightDetails.isPresent()) {
			updatedFlight = optionalFlightDetails.get();
			updatedFlight.setAirline(flightDetails.getAirline());
			updatedFlight.setAirplaneCapacity(flightDetails.getAirplaneCapacity());
			updatedFlight.setSeatsOccupied(flightDetails.getSeatsOccupied());
			updatedFlight.setScheduledDeparture(flightDetails.getScheduledDeparture());
			updatedFlight.setActualDeparture(flightDetails.getActualDeparture());
			updatedFlight.setScheduledArrival(flightDetails.getScheduledArrival());
			updatedFlight.setActualArrival(flightDetails.getActualArrival());
			updatedFlight.setDepartureAirport(flightDetails.getDepartureAirport());
			updatedFlight.setArrivalAirport(flightDetails.getArrivalAirport());
			updatedFlight.setAirplane(flightDetails.getAirplane());
			updatedFlight.setFlightNumer(flightDetails.getFlightNumer());
			updatedFlight.setNumberOfStops(flightDetails.getNumberOfStops());
			flightDetailsRepo.saveAndFlush(updatedFlight);
		}
		return updatedFlight;
	}

	@Override
	public FlightDetails patch(int flightId, FlightDetails flightDetails) {
		FlightDetails patchedFlight = null;
		Optional<FlightDetails> optionalFlightDetails = flightDetailsRepo.findById(flightId);
		if(optionalFlightDetails.isPresent()) {
			patchedFlight = optionalFlightDetails.get();
			if(flightDetails.getAirline() != null) {patchedFlight.setAirline(flightDetails.getAirline());}
			if(flightDetails.getAirplaneCapacity() != null) {patchedFlight.setAirplaneCapacity(flightDetails.getAirplaneCapacity());}
			if(flightDetails.getSeatsOccupied() != null) {patchedFlight.setSeatsOccupied(flightDetails.getSeatsOccupied());}
			if(flightDetails.getScheduledDeparture() != null) {patchedFlight.setScheduledDeparture(flightDetails.getScheduledDeparture());}
			if(flightDetails.getActualDeparture() != null) {patchedFlight.setActualDeparture(flightDetails.getActualDeparture());}
			if(flightDetails.getScheduledArrival() != null) {patchedFlight.setScheduledArrival(flightDetails.getScheduledArrival());}
			if(flightDetails.getActualArrival() != null) {patchedFlight.setActualArrival(flightDetails.getActualArrival());}
			if(flightDetails.getDepartureAirport() != null) {patchedFlight.setDepartureAirport(flightDetails.getDepartureAirport());}
			if(flightDetails.getArrivalAirport() != null) {patchedFlight.setArrivalAirport(flightDetails.getArrivalAirport());}
			if(flightDetails.getAirplane() != null) {patchedFlight.setAirplane(flightDetails.getAirplane());}
			if(flightDetails.getFlightNumer() != null) {patchedFlight.setFlightNumer(flightDetails.getFlightNumer());}
			if(flightDetails.getNumberOfStops() != null) {patchedFlight.setNumberOfStops(flightDetails.getNumberOfStops());}
			flightDetailsRepo.saveAndFlush(patchedFlight);
		}
		return patchedFlight;
	}
}

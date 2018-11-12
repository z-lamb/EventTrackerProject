package com.skilldistillery.flighttracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.entities.Flight;
import com.skilldistillery.flighttracker.repositories.FlightDetailsRepository;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	@Autowired
	private FlightDetailsRepository flightDetailsRepo;
	
	@Override
	public List<Flight> findAll(){
		return flightDetailsRepo.findAll();
	}
	
	@Override
	public Flight findById(int flightId) {
		Flight findById = null;
		Optional<Flight> optionalFlightDetails = flightDetailsRepo.findById(flightId);
		if(optionalFlightDetails.isPresent()) {
			findById = optionalFlightDetails.get();
		}
		return findById;
	}
	
	@Override
	public Flight create(Flight flightDetails) {
		Flight newFlightDetails = null;
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
	public Flight update(int flightId, Flight flight) {
		Flight updatedFlight = null;
		Optional<Flight> optionalFlightDetails = flightDetailsRepo.findById(flightId);
		if(optionalFlightDetails.isPresent()) {
			updatedFlight = optionalFlightDetails.get();
//			updatedFlight.setAirline(flight.getAirline());
//			updatedFlight.setAirplaneCapacity(flight.getAirplaneCapacity());
			updatedFlight.setSeatsOccupied(flight.getSeatsOccupied());
			updatedFlight.setScheduledDeparture(flight.getScheduledDeparture());
			updatedFlight.setActualDeparture(flight.getActualDeparture());
			updatedFlight.setScheduledArrival(flight.getScheduledArrival());
			updatedFlight.setActualArrival(flight.getActualArrival());
			updatedFlight.setDepartureAirport(flight.getDepartureAirport());
			updatedFlight.setArrivalAirport(flight.getArrivalAirport());
			updatedFlight.setAirplane(flight.getAirplane());
			updatedFlight.setFlightNumer(flight.getFlightNumer());
			updatedFlight.setNumberOfStops(flight.getNumberOfStops());
			flightDetailsRepo.saveAndFlush(updatedFlight);
		}
		return updatedFlight;
	}

	@Override
	public Flight patch(int flightId, Flight flight) {
		Flight patchedFlight = null;
		Optional<Flight> optionalFlightDetails = flightDetailsRepo.findById(flightId);
		if(optionalFlightDetails.isPresent()) {
			patchedFlight = optionalFlightDetails.get();
//			if(flight.getAirline() != null) {patchedFlight.setAirline(flight.getAirline());}
//			if(flight.getAirplaneCapacity() != null) {patchedFlight.setAirplaneCapacity(flight.getAirplaneCapacity());}
			if(flight.getSeatsOccupied() != null) {patchedFlight.setSeatsOccupied(flight.getSeatsOccupied());}
			if(flight.getScheduledDeparture() != null) {patchedFlight.setScheduledDeparture(flight.getScheduledDeparture());}
			if(flight.getActualDeparture() != null) {patchedFlight.setActualDeparture(flight.getActualDeparture());}
			if(flight.getScheduledArrival() != null) {patchedFlight.setScheduledArrival(flight.getScheduledArrival());}
			if(flight.getActualArrival() != null) {patchedFlight.setActualArrival(flight.getActualArrival());}
			if(flight.getDepartureAirport() != null) {patchedFlight.setDepartureAirport(flight.getDepartureAirport());}
			if(flight.getArrivalAirport() != null) {patchedFlight.setArrivalAirport(flight.getArrivalAirport());}
			if(flight.getAirplane() != null) {patchedFlight.setAirplane(flight.getAirplane());}
			if(flight.getFlightNumer() != null) {patchedFlight.setFlightNumer(flight.getFlightNumer());}
			if(flight.getNumberOfStops() != null) {patchedFlight.setNumberOfStops(flight.getNumberOfStops());}
			flightDetailsRepo.saveAndFlush(patchedFlight);
		}
		return patchedFlight;
	}
}

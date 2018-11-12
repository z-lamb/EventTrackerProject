package com.skilldistillery.flighttracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.entities.Airplane;
import com.skilldistillery.flighttracker.entities.Airport;
import com.skilldistillery.flighttracker.entities.Flight;
import com.skilldistillery.flighttracker.repositories.AirplaneRepository;
import com.skilldistillery.flighttracker.repositories.AirportRepository;
import com.skilldistillery.flighttracker.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private AirportRepository airportRepo;
	@Autowired
	private AirplaneRepository airplaneRepo;

	@Override
	public List<Flight> findAll() {
		return flightRepo.findAll();
	}

	@Override
	public Flight findById(int flightId) {
		Flight findById = null;
		Optional<Flight> optionalFlightDetails = flightRepo.findById(flightId);
		if (optionalFlightDetails.isPresent()) {
			findById = optionalFlightDetails.get();
		}
		return findById;
	}

	@Override
	public Flight create(Flight flight, int arrivalId, int departureId, int airplaneId) {
		Flight newFlightDetails = null;
		Airplane airplane = null;
		Airport departureAirport = null;
		Airport arrivalAirport = null;
		Optional<Airplane> optionalAirplane = airplaneRepo.findById(airplaneId);
		if (optionalAirplane.isPresent()) {
			airplane = optionalAirplane.get();
			flight.setAirplane(airplane);
			Optional<Airport> optionalDeparture = airportRepo.findById(departureId);
			if (optionalDeparture.isPresent()) {
				departureAirport = optionalDeparture.get();
				flight.setDepartureAirport(departureAirport);
				Optional<Airport> optionalArrival = airportRepo.findById(arrivalId);
				if (optionalArrival.isPresent()) {
					arrivalAirport = optionalArrival.get();
					flight.setArrivalAirport(arrivalAirport);
					newFlightDetails = flightRepo.saveAndFlush(flight);
				}
			}
		}
		return newFlightDetails;
	}

	@Override
	public boolean delete(int flightId) {
		boolean deleted = false;
		if (flightRepo.existsById(flightId)) {
			flightRepo.deleteById(flightId);
			deleted = true;
		}
		return deleted;
	}

	@Override
	public Flight update(int flightId, Flight flight, int arrivalId, int departureId, int airplaneId) {
		Flight updatedFlight = null;
		Airplane airplane = null;
		Airport departureAirport = null;
		Airport arrivalAirport = null;
		Optional<Flight> optionalFlightDetails = flightRepo.findById(flightId);
		if (optionalFlightDetails.isPresent()) {
			updatedFlight = optionalFlightDetails.get();
			Optional<Airplane> optionalAirplane = airplaneRepo.findById(airplaneId);
			if (optionalAirplane.isPresent()) {
				airplane = optionalAirplane.get();
				updatedFlight.setAirplane(airplane);
				Optional<Airport> optionalDeparture = airportRepo.findById(departureId);
				if (optionalDeparture.isPresent()) {
					departureAirport = optionalDeparture.get();
					updatedFlight.setDepartureAirport(departureAirport);
					Optional<Airport> optionalArrival = airportRepo.findById(arrivalId);
					if (optionalArrival.isPresent()) {
						arrivalAirport = optionalArrival.get();
						updatedFlight.setArrivalAirport(arrivalAirport);
						updatedFlight.setSeatsOccupied(flight.getSeatsOccupied());
						updatedFlight.setScheduledDeparture(flight.getScheduledDeparture());
						updatedFlight.setActualDeparture(flight.getActualDeparture());
						updatedFlight.setScheduledArrival(flight.getScheduledArrival());
						updatedFlight.setActualArrival(flight.getActualArrival());
						updatedFlight.setFlightNumer(flight.getFlightNumer());
						updatedFlight.setNumberOfStops(flight.getNumberOfStops());
						updatedFlight.setAvailable(flight.isAvailable());
						flightRepo.saveAndFlush(updatedFlight);
					}
				}
			}
		}
		return updatedFlight;
	}

	@Override
	public Flight patch(int flightId, Flight flight, int arrivalId, int departureId, int airplaneId) {
		Flight patchedFlight = null;
		Airplane airplane = null;
		Airport departureAirport = null;
		Airport arrivalAirport = null;
		Optional<Flight> optionalFlightDetails = flightRepo.findById(flightId);
		if (optionalFlightDetails.isPresent()) {
			patchedFlight = optionalFlightDetails.get();
			Optional<Airplane> optionalAirplane = airplaneRepo.findById(airplaneId);
			if (optionalAirplane.isPresent()) {
				airplane = optionalAirplane.get();
				patchedFlight.setAirplane(airplane);
				Optional<Airport> optionalDeparture = airportRepo.findById(departureId);
				if (optionalDeparture.isPresent()) {
					departureAirport = optionalDeparture.get();
					patchedFlight.setDepartureAirport(departureAirport);
					Optional<Airport> optionalArrival = airportRepo.findById(arrivalId);
					if (optionalArrival.isPresent()) {
						arrivalAirport = optionalArrival.get();
						patchedFlight.setArrivalAirport(arrivalAirport);
						if (flight.getSeatsOccupied() != null) {
							patchedFlight.setSeatsOccupied(flight.getSeatsOccupied());
						}
						if (flight.getScheduledDeparture() != null) {
							patchedFlight.setScheduledDeparture(flight.getScheduledDeparture());
						}
						if (flight.getActualDeparture() != null) {
							patchedFlight.setActualDeparture(flight.getActualDeparture());
						}
						if (flight.getScheduledArrival() != null) {
							patchedFlight.setScheduledArrival(flight.getScheduledArrival());
						}
						if (flight.getActualArrival() != null) {
							patchedFlight.setActualArrival(flight.getActualArrival());
						}
						if (flight.getDepartureAirport() != null) {
							patchedFlight.setDepartureAirport(flight.getDepartureAirport());
						}
						if (flight.getArrivalAirport() != null) {
							patchedFlight.setArrivalAirport(flight.getArrivalAirport());
						}
						if (flight.getFlightNumer() != null) {
							patchedFlight.setFlightNumer(flight.getFlightNumer());
						}
						if (flight.getNumberOfStops() != null) {
							patchedFlight.setNumberOfStops(flight.getNumberOfStops());
						}
						if (flight.isAvailable() != null) {
							patchedFlight.setAvailable(flight.isAvailable());
						}
						flightRepo.saveAndFlush(patchedFlight);
					}
				}

			}
		}
		return patchedFlight;
	}
}

package com.skilldistillery.flighttracker.contollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.flighttracker.entities.Flight;
import com.skilldistillery.flighttracker.service.FlightService;

@RestController
@RequestMapping("api")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping("flights")
	public List<Flight> index(HttpServletResponse resp) {
		List<Flight> flights = null;
		flights = flightService.findAll();
		if (flights.isEmpty()) {
			resp.setStatus(404);
		}
		return flights;
	}

	@GetMapping("flights/{flightId}")
	public Flight flightById(@PathVariable("flightId") int flightId, HttpServletResponse resp) {
		Flight flight = null;
		flight = flightService.findById(flightId);
		if (flight == null) {
			resp.setStatus(404);
		}
		return flight;
	}

	@PostMapping("flights/arrival/{arrivalId}/departure/{departureId}/airplane/{airplaneId}")
	public Flight create(@RequestBody Flight flight, @PathVariable("arrivalId") int arrivalId,
			@PathVariable("departureId") int departureId, @PathVariable("airplaneId") int airplaneId,
			HttpServletResponse resp, HttpServletRequest req) {
		Flight newFlight = null;
		newFlight = flightService.create(flight, arrivalId, departureId, airplaneId);
		if (newFlight == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(201);
			String newResourceUrl = req.getRequestURL() + "/" + newFlight.getId();
			resp.setHeader("Location", newResourceUrl);
		}
		return newFlight;
	}

	@DeleteMapping("flights/{flightId}")
	public boolean delete(@PathVariable("flightId") int flightId, HttpServletResponse resp) {
		boolean deleted = false;
		deleted = flightService.delete(flightId);
		if (deleted) {
			resp.setStatus(202);
		} else {
			resp.setStatus(404);
		}
		return deleted;
	}

	@PutMapping("flights/{flightId}/arrival/{arrivalId}/departure/{departureId}/airplane/{airplaneId}")
	public Flight update(@PathVariable("flightId") int flightId, @RequestBody Flight flight, @PathVariable("arrivalId") int arrivalId,
			@PathVariable("departureId") int departureId, @PathVariable("airplaneId") int airplaneId,
			HttpServletResponse resp) {
		Flight updatedFlight = null;
		updatedFlight = flightService.update(flightId, flight, arrivalId, departureId, airplaneId);
		if (updatedFlight != null) {
			resp.setStatus(202);
		} else {
			resp.setStatus(400);
		}
		return updatedFlight;
	}

	@PatchMapping("flights/{flightId}/arrival/{arrivalId}/departure/{departureId}/airplane/{airplaneId}")
	public Flight patchUpdate(@PathVariable("flightId") int flightId, @RequestBody Flight flight, @PathVariable("arrivalId") int arrivalId,
			@PathVariable("departureId") int departureId, @PathVariable("airplaneId") int airplaneId,
			HttpServletResponse resp) {
		Flight patchedFlight = null;
		patchedFlight = flightService.patch(flightId, flight, arrivalId, departureId, airplaneId);
		if(patchedFlight != null) {
			resp.setStatus(202);
		} else {
			resp.setStatus(404);
		}
		return patchedFlight;
	}

	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
}

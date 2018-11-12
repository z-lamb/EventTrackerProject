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
import com.skilldistillery.flighttracker.service.FlightServiceImpl;

@RestController
@RequestMapping("api")
public class FlightController {

	@Autowired
	private FlightServiceImpl flightService;

	@GetMapping("flights")
	public List<Flight> index(HttpServletResponse resp) {
		List<Flight> flightDetails = null;
		flightDetails = flightService.findAll();
		if (flightDetails.isEmpty()) {
			resp.setStatus(404);
		}
		return flightDetails;
	}

	@GetMapping("flights/{flightId}")
	public Flight flightById(@PathVariable("flightId") int flightId, HttpServletResponse resp) {
		Flight flightDetails = null;
		flightDetails = flightService.findById(flightId);
		if (flightDetails == null) {
			resp.setStatus(404);
		}
		return flightDetails;
	}

	@PostMapping("flights/arrival/{arrivalId}/departure/{departureId}/airplane/{airplaneId}")
	public Flight create(@RequestBody Flight flight, @PathVariable("arrivalId") int arrivalId,
			@PathVariable("departureId") int departureId, @PathVariable("airplaneId") int airplaneId,
			HttpServletResponse resp, HttpServletRequest req) {
		Flight newFlightDetails = null;
		newFlightDetails = flightService.create(flight, arrivalId, departureId, airplaneId);
		if (newFlightDetails == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(201);
			String newResourceUrl = req.getRequestURL() + "/" + newFlightDetails.getId();
			resp.setHeader("Location", newResourceUrl);
		}
		return newFlightDetails;
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
		Flight updatedDetails = null;
		updatedDetails = flightService.update(flightId, flight, arrivalId, departureId, airplaneId);
		if (updatedDetails != null) {
			resp.setStatus(202);
		} else {
			resp.setStatus(400);
		}
		return updatedDetails;
	}

	@PatchMapping("flights/{flightId}/arrival/{arrivalId}/departure/{departureId}/airplane/{airplaneId}")
	public Flight patchUpdate(@PathVariable("flightId") int flightId, @RequestBody Flight flight, @PathVariable("arrivalId") int arrivalId,
			@PathVariable("departureId") int departureId, @PathVariable("airplaneId") int airplaneId,
			HttpServletResponse resp) {
		Flight patchedDetails = null;
		patchedDetails = flightService.patch(flightId, flight, arrivalId, departureId, airplaneId);
		return patchedDetails;
	}

	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
}

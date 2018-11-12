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
import com.skilldistillery.flighttracker.service.FlightDetailsServiceImpl;

@RestController
@RequestMapping("api")
public class FlightDetailsController {

	@Autowired
	private FlightDetailsServiceImpl flightDetailsService;
	
	@GetMapping("flights")
	public List<Flight> index(HttpServletResponse resp){
		List<Flight> flightDetails = null;
		flightDetails = flightDetailsService.findAll();
		if(flightDetails.isEmpty()) {
			resp.setStatus(404);
		}
		return flightDetails;
	}
	
	@GetMapping("flights/{flightId}")
	public Flight flightById(@PathVariable("flightId") int flightId, HttpServletResponse resp) {
		Flight flightDetails = null;
		flightDetails = flightDetailsService.findById(flightId);
		if(flightDetails == null) {
			resp.setStatus(404);
		}
		return flightDetails;
	}
	
	@PostMapping("flights")
	public Flight create(@RequestBody Flight flightDetails, HttpServletResponse resp, HttpServletRequest req) {
		Flight newFlightDetails = null;
		newFlightDetails = flightDetailsService.create(flightDetails);
		if(newFlightDetails == null) {
			resp.setStatus(400);
		}
		else {
			resp.setStatus(201);
			String newResourceUrl = req.getRequestURL() + "/" + newFlightDetails.getId();
			resp.setHeader("Location", newResourceUrl);
		}
		return newFlightDetails;
	}
	
	@DeleteMapping("flights/{flightId}")
	public boolean delete(@PathVariable("flightId") int flightId, HttpServletResponse resp) {
		boolean deleted = false;
		deleted = flightDetailsService.delete(flightId);
		if(deleted) {
			resp.setStatus(202);
		}
		else {
			resp.setStatus(404);
		}
		return deleted;
	}
	
	@PutMapping("flights/{flightId}")
	public Flight update(@PathVariable("flightId") int flightId, @RequestBody Flight flightDetails, HttpServletResponse resp) {
		Flight updatedDetails = null;
		updatedDetails = flightDetailsService.update(flightId, flightDetails);
		if(updatedDetails !=  null) {
			resp.setStatus(202);
		}
		else {
			resp.setStatus(400);
		}
		return updatedDetails;
	}
	
	@PatchMapping("flights/{flightId}")
	public Flight patchUpdate(@PathVariable("flightId") int flightId, @RequestBody Flight flightDetails, HttpServletResponse resp) {
		Flight patchedDetails = null;
		patchedDetails = flightDetailsService.patch(flightId, flightDetails);
		return patchedDetails;
	}
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
}

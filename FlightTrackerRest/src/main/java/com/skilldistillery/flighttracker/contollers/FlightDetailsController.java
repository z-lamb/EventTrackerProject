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

import com.skilldistillery.flighttracker.entities.FlightDetails;
import com.skilldistillery.flighttracker.service.FlightDetailsServiceImpl;

@RestController
@RequestMapping("api")
public class FlightDetailsController {

	@Autowired
	private FlightDetailsServiceImpl flightDetailsService;
	
	@GetMapping("flights")
	public List<FlightDetails> index(HttpServletResponse resp){
		List<FlightDetails> flightDetails = null;
		flightDetails = flightDetailsService.findAll();
		if(flightDetails.isEmpty()) {
			resp.setStatus(404);
		}
		return flightDetails;
	}
	
	@GetMapping("flights/{flightId}")
	public FlightDetails flightById(@PathVariable("flightId") int flightId, HttpServletResponse resp) {
		FlightDetails flightDetails = null;
		flightDetails = flightDetailsService.findById(flightId);
		if(flightDetails == null) {
			resp.setStatus(404);
		}
		return flightDetails;
	}
	
	@PostMapping("flights")
	public FlightDetails create(@RequestBody FlightDetails flightDetails, HttpServletResponse resp, HttpServletRequest req) {
		FlightDetails newFlightDetails = null;
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
	public FlightDetails update(@PathVariable("flightId") int flightId, @RequestBody FlightDetails flightDetails, HttpServletResponse resp) {
		FlightDetails updatedDetails = null;
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
	public FlightDetails patchUpdate(@PathVariable("flightId") int flightId, @RequestBody FlightDetails flightDetails, HttpServletResponse resp) {
		FlightDetails patchedDetails = null;
		patchedDetails = flightDetailsService.patch(flightId, flightDetails);
		return patchedDetails;
	}
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
}

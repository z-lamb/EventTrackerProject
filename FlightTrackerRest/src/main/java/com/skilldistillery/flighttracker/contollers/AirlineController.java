package com.skilldistillery.flighttracker.contollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.flighttracker.entities.Airline;
import com.skilldistillery.flighttracker.service.AirlineService;

@RestController
@RequestMapping("api")
public class AirlineController {

	@Autowired
	private AirlineService airlineService;
	
	@GetMapping("airlines")
	public List<Airline> index(HttpServletResponse resp){
		List<Airline> airlines = null;
		airlines = airlineService.findAll();
		if (airlines.isEmpty()) {
			resp.setStatus(404);
		}
		return airlines;
	}
	
	@GetMapping("airlines/{airlineId}")
	public Airline airlineById(@PathVariable("airlineId") int airlineId, HttpServletResponse resp) {
		Airline airline = null;
		airline = airlineService.findById(airlineId);
		if (airline == null) {
			resp.setStatus(404);
		}
		return airline;
	}
	
	@PostMapping("airlines")
	public Airline create(@RequestBody Airline airline, HttpServletResponse resp, HttpServletRequest req) {
		Airline newAirline = null;
		newAirline = airlineService.create(airline);
		if (newAirline == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(201);
			String newResourceUrl = req.getRequestURL() + "/" + newAirline.getId();
			resp.setHeader("Location", newResourceUrl);
		}
		return newAirline;
	}
	
	@DeleteMapping("airlines/{airlineId}")
	public boolean delete(@PathVariable("airlineId") int airlineId, HttpServletResponse resp) {
		boolean deleted = false;
		deleted = airlineService.delete(airlineId);
		if (deleted) {
			resp.setStatus(202);
		} else {
			resp.setStatus(404);
		}
		return deleted;
	}
	
	@PutMapping("airlines/{airlineId}")
	public Airline update(@PathVariable("airlineId") int airlineId, @RequestBody Airline airline, HttpServletResponse resp) {
		Airline updatedAirline = null;
		updatedAirline = airlineService.update(airlineId, airline);
		if (updatedAirline != null) {
			resp.setStatus(202);
		} else {
			resp.setStatus(400);
		}
		return updatedAirline;
	}
}

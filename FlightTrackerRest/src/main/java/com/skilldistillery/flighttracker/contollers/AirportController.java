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

import com.skilldistillery.flighttracker.entities.Airport;
import com.skilldistillery.flighttracker.service.AirportService;

@RestController
@RequestMapping("api")
public class AirportController {

	@Autowired
	private AirportService airportService;
	
	@GetMapping("airports")
	public List<Airport> index(HttpServletResponse resp){
		List<Airport> airports = null;
		airports = airportService.findAll();
		if (airports.isEmpty()) {
			resp.setStatus(404);
		}
		return airports;
	}
	
	@GetMapping("airports/{airportId}")
	public Airport airportById(@PathVariable("airportId") int airportId, HttpServletResponse resp) {
		Airport airport = null;
		airport = airportService.findById(airportId);
		if (airport == null) {
			resp.setStatus(404);
		}
		return airport;
	}
	
	@PostMapping("airports")
	public Airport create(@RequestBody Airport airport, HttpServletResponse resp, HttpServletRequest req) {
		Airport newAirport = null;
		newAirport = airportService.create(airport);
		if (newAirport == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(201);
			String newResourceUrl = req.getRequestURL() + "/" + newAirport.getId();
			resp.setHeader("Location", newResourceUrl);
		}
		return newAirport;
	}
	
	@DeleteMapping("airports/{airportId}")
	public boolean delete(@PathVariable("airportId") int airportId, HttpServletResponse resp) {
		boolean deleted = false;
		deleted = airportService.delete(airportId);
		if (deleted) {
			resp.setStatus(202);
		} else {
			resp.setStatus(404);
		}
		return deleted;
	}
	
	@PutMapping("airports/{airportId}")
	public Airport update(@PathVariable("airportId") int airportId, @RequestBody Airport airport, HttpServletResponse resp) {
		Airport updatedAirport = null;
		updatedAirport = airportService.update(airportId, airport);
		if (updatedAirport != null) {
			resp.setStatus(202);
		} else {
			resp.setStatus(400);
		}
		return updatedAirport;
	}
	
	@PatchMapping("airports/{airportId}")
	public Airport patch(@PathVariable("airportId") int airportId, @RequestBody Airport airport, HttpServletResponse resp) {
		Airport patchedAirport;
		patchedAirport = airportService.patch(airportId, airport);
		if (patchedAirport != null) {
			resp.setStatus(202);
		} else {
			resp.setStatus(400);
		}
		return patchedAirport;
	}
}

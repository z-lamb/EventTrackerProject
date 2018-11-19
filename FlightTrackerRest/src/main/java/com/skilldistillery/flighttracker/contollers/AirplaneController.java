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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.flighttracker.entities.Airplane;
import com.skilldistillery.flighttracker.service.AirplaneService;

@RestController
@RequestMapping("api")
public class AirplaneController {

	@Autowired
	private AirplaneService airplaneService;
	
	@GetMapping("airplanes")
	public List<Airplane> index(HttpServletResponse resp){
		List<Airplane> airplanes = null;
		airplanes = airplaneService.findAll();
		if (airplanes.isEmpty()) {
			resp.setStatus(404);
		}
		return airplanes;
	}
	
	@GetMapping("airplanes/{airplaneId}")
	public Airplane airplaneById(@PathVariable("airplaneId") int airplaneId, HttpServletResponse resp) {
		Airplane airplane = null;
		airplane = airplaneService.findById(airplaneId);
		if (airplane == null) {
			resp.setStatus(404);
		}
		return airplane;
	}
	
	@PostMapping("airplanes/airlines/{airlineId}/airplaneTypes/{airplaneTypeId}")
	public Airplane create(@PathVariable("airlineId") int airlineId, @PathVariable("airplaneTypeId") int airplaneTypeId, HttpServletResponse resp, HttpServletRequest req) {
		Airplane newAirplane = null;
		newAirplane = airplaneService.create(airlineId, airplaneTypeId);
		if (newAirplane == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(201);
			String newResourceUrl = req.getRequestURL() + "/" + newAirplane.getId();
			resp.setHeader("Location", newResourceUrl);
		}
		return newAirplane;
	}
	
	@DeleteMapping("airplanes/{airplaneId}")
	public boolean delete(@PathVariable("airplaneId") int airplaneId, HttpServletResponse resp) {
		boolean deleted = false;
		deleted = airplaneService.delete(airplaneId);
		if (deleted) {
			resp.setStatus(202);
		} else {
			resp.setStatus(404);
		}
		return deleted;
	}
	
	@PatchMapping("airplanes/{airplaneId}/airlines/{airlineId}/airplaneTypes/{airplaneTypeId}")
	public Airplane patchUpdate(@PathVariable("airplaneId") int airplaneId, @PathVariable("airlineId") int airlineId, @PathVariable("airplaneTypeId") int airplaneTypeId,
			HttpServletResponse resp) {
		Airplane patchedAirplane = null;
		patchedAirplane = airplaneService.patch(airplaneId, airlineId, airplaneTypeId);
		if(patchedAirplane != null) {
			resp.setStatus(202);
		} else {
			resp.setStatus(404);
		}
		return patchedAirplane;
	}
	
	@GetMapping("airplanes/airlines/{airlineName}/airplaneMakers/{airplaneMaker}/airplaneTypes/{airplaneType}/fights/{flightId}")
	public Airplane airplaneByAirlineNameAndAirplaneTypeName(@PathVariable("airlineName") String airlineName, @PathVariable("airplaneTypeName") String airplaneTypeName, HttpServletResponse resp) {
		Airplane airplane = null;
		airplane = airplaneService.airplaneByAirlineNameAndAirplaneTypeName(airlineName, airplaneTypeName);
		if (airplane == null) {
			resp.setStatus(404);
		}
		return airplane;
	}
}

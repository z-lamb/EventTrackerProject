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

import com.skilldistillery.flighttracker.entities.AirplaneType;
import com.skilldistillery.flighttracker.service.AirplaneTypeService;

@RestController
@RequestMapping("api")
public class AirplaneTypeController {

	@Autowired
	private AirplaneTypeService airplaneTypeService;
	
	@GetMapping("airplaneTypes")
	public List<AirplaneType> index(HttpServletResponse resp){
		List<AirplaneType> airplaneTypes = null;
		airplaneTypes = airplaneTypeService.findAll();
		if (airplaneTypes.isEmpty()) {
			resp.setStatus(404);
		}
		return airplaneTypes;
	}
	
	@GetMapping("airplaneTypes/{airplaneTypeId}")
	public AirplaneType airplaneTypeById(@PathVariable("airplaneTypeId") int airplaneTypeId, HttpServletResponse resp) {
		AirplaneType airplaneType = null;
		airplaneType = airplaneTypeService.findById(airplaneTypeId);
		if (airplaneType == null) {
			resp.setStatus(404);
		}
		return airplaneType;
	}
	
	@PostMapping("airplaneTypes")
	public AirplaneType create(@RequestBody AirplaneType airplaneType, HttpServletResponse resp, HttpServletRequest req) {
		AirplaneType newAirplaneType = null;
		newAirplaneType = airplaneTypeService.create(airplaneType);
		if (newAirplaneType == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(201);
			String newResourceUrl = req.getRequestURL() + "/" + newAirplaneType.getId();
			resp.setHeader("Location", newResourceUrl);
		}
		return newAirplaneType;
	}
	
	@DeleteMapping("airplaneTypes/{airplaneTypeId}")
	public boolean delete(@PathVariable("airplaneTypeId") int airplaneTypeId, HttpServletResponse resp) {
		boolean deleted = false;
		deleted = airplaneTypeService.delete(airplaneTypeId);
		if (deleted) {
			resp.setStatus(202);
		} else {
			resp.setStatus(404);
		}
		return deleted;
	}
	
	@PutMapping("airplaneTypes/{airplaneTypeId}")
	public AirplaneType update(@PathVariable("airplaneTypeId") int airplaneTypeId, @RequestBody AirplaneType airplaneType, HttpServletResponse resp) {
		AirplaneType updatedAirplaneType = null;
		updatedAirplaneType = airplaneTypeService.update(airplaneTypeId, airplaneType);
		if (updatedAirplaneType != null) {
			resp.setStatus(202);
		} else {
			resp.setStatus(400);
		}
		return updatedAirplaneType;
	}
	
	@PatchMapping("airplaneTypes/{airplaneTypeId}")
	public AirplaneType patch(@PathVariable("airplaneTypeId") int airplaneTypeId, @RequestBody AirplaneType airplaneType, HttpServletResponse resp) {
		AirplaneType patchedAirplaneType;
		patchedAirplaneType = airplaneTypeService.patch(airplaneTypeId, airplaneType);
		if (patchedAirplaneType != null) {
			resp.setStatus(202);
		} else {
			resp.setStatus(400);
		}
		return patchedAirplaneType;
	}
}

package com.skilldistillery.flighttracker.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.flighttracker.service.AirportServiceImpl;

@RestController
@RequestMapping("api")
public class AirportController {

	@Autowired
	private AirportServiceImpl airportService;
	
	
}
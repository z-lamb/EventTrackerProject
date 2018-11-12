package com.skilldistillery.flighttracker.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.flighttracker.repositories.AirplaneRepository;

public class AirplaneServiceImpl implements AirplaneService {

	@Autowired
	private AirplaneRepository airplaneRepo;
}

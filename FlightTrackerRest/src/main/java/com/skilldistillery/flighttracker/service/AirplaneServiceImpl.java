package com.skilldistillery.flighttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.repositories.AirplaneRepository;

@Service
public class AirplaneServiceImpl implements AirplaneService {

	@Autowired
	private AirplaneRepository airplaneRepo;
}

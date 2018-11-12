package com.skilldistillery.flighttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.repositories.AirplaneTypeRepository;

@Service
public class AirplaneTypeServiceImpl implements AirplaneTypeService {

	@Autowired
	private AirplaneTypeRepository airplaneTypeRepo;
}

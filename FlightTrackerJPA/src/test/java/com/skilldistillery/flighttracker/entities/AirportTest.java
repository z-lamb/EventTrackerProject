package com.skilldistillery.flighttracker.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AirportTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Airport airport;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("FlightTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		airport = em.find(Airport.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@DisplayName("Test Airport Mappings")
	void test_AirportMappings() {
		assertNotNull(airport);
		assertEquals("Denver International Airport", airport.getName());
		assertEquals("DEN", airport.getCode());
		assertEquals("Denver", airport.getCity());
		assertEquals("CO", airport.getState());
		assertEquals("US", airport.getCountry());
	}

}

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

class AirplaneTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Airplane airplane;

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
		airplane = em.find(Airplane.class, 15);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@DisplayName("Test Airplane Mappings")
	void test_AirplaneMappings() {
		assertNotNull(airplane);
		assertEquals("Southwest Airlines", airplane.getAirline().getName());
		assertEquals("Boeing", airplane.getAirplaneType().getMaker());
		assertEquals(2, airplane.getFlights().size());
	}

}

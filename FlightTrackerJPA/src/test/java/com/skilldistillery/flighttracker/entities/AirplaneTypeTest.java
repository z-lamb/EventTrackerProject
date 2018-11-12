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

class AirplaneTypeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private AirplaneType airplaneType;

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
		airplaneType = em.find(AirplaneType.class, 13);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@DisplayName("Test Airline Mappings")
	void test_FlightDetailsMappings() {
		assertNotNull(airplaneType);
		assertEquals("Boeing", airplaneType.getMaker());
		assertEquals("737-MAX", airplaneType.getType());
		assertEquals(172, airplaneType.getCapacity().intValue());
		assertEquals(true, airplaneType.getWifi());
		assertEquals(3, airplaneType.getAirplanes().size());
	}

}

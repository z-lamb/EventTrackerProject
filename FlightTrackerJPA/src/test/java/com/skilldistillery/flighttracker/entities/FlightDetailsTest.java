package com.skilldistillery.flighttracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FlightDetailsTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private FlightDetails flightDetails;

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
		flightDetails = em.find(FlightDetails.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@DisplayName("Test Flight Details Mappings")
	void test_FlightDetailsMappings() {
		assertNotNull(flightDetails);
		assertEquals("Southwest", flightDetails.getAirline());
		assertEquals(175, flightDetails.getAirplaneCapacity().intValue());
		assertEquals(170, flightDetails.getSeatsOccupied().intValue());
		assertEquals(Timestamp.valueOf("2018-11-12 06:00:00.0"), flightDetails.getScheduledDeparture());
		assertNull(flightDetails.getActualDeparture());
		assertEquals(Timestamp.valueOf("2018-11-12 10:00:00.0"), flightDetails.getScheduledArrival());
		assertNull(flightDetails.getActualArrival());
		assertEquals("DEN", flightDetails.getDepartureAirport());
		assertEquals("MDW", flightDetails.getArrivalAirport());
		assertEquals("Boeing 737-MAX", flightDetails.getAirplane());
		assertNull(flightDetails.getFlightNumer());
		assertEquals(0, flightDetails.getNumberOfStops().intValue());
	}

}

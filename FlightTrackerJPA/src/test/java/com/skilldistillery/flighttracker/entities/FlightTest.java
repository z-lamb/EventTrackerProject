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

class FlightTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Flight flightDetails;

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
		flightDetails = em.find(Flight.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@DisplayName("Test Flight Details Mappings")
	void test_FlightDetailsMappings() {
		assertNotNull(flightDetails);
		assertEquals(170, flightDetails.getSeatsOccupied().intValue());
		assertEquals(Timestamp.valueOf("2018-11-12 06:00:00.0"), flightDetails.getScheduledDeparture());
		assertNull(flightDetails.getActualDeparture());
		assertEquals(Timestamp.valueOf("2018-11-12 10:00:00.0"), flightDetails.getScheduledArrival());
		assertNull(flightDetails.getActualArrival());
		assertEquals("1235", flightDetails.getFlightNumer());
		assertEquals(0, flightDetails.getNumberOfStops().intValue());
		assertEquals(true, flightDetails.isAvailable());
		assertEquals("Boeing", flightDetails.getAirplane().getAirplaneType().getMaker());
		assertEquals("Southwest Airlines", flightDetails.getAirplane().getAirline().getName());
		assertEquals("DEN", flightDetails.getDepartureAirport().getCode());
		assertEquals("MDW", flightDetails.getArrivalAirport().getCode());
	}

}

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
	private Flight flight;

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
		flight = em.find(Flight.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@DisplayName("Test Flight Mappings")
	void test_FlightMappings() {
		assertNotNull(flight);
		assertEquals(170, flight.getSeatsOccupied().intValue());
		assertEquals(Timestamp.valueOf("2018-11-12 06:00:00.0"), flight.getScheduledDeparture());
		assertNull(flight.getActualDeparture());
		assertEquals(Timestamp.valueOf("2018-11-12 10:00:00.0"), flight.getScheduledArrival());
		assertNull(flight.getActualArrival());
		assertEquals("1235", flight.getFlightNumer());
		assertEquals(0, flight.getNumberOfStops().intValue());
		assertEquals(true, flight.isAvailable());
		assertEquals("Boeing", flight.getAirplane().getAirplaneType().getMaker());
		assertEquals("Southwest Airlines", flight.getAirplane().getAirline().getName());
		assertEquals("DEN", flight.getDepartureAirport().getCode());
		assertEquals("MDW", flight.getArrivalAirport().getCode());
	}

}

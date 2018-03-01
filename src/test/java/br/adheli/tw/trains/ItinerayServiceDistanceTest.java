package br.adheli.tw.trains;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.adheli.tw.trains.exception.NoSuchRouteException;
import br.adheli.tw.trains.service.ItineraryService;

/**
 * Testing the distance method from RouteService class
 * @author adheli.tavares
 *
 */
public class ItinerayServiceDistanceTest {

	private ItineraryService service;

	/**
	 * Starts a list of routes for distance testing
	 */
	@Before
	public void setUp() {
		this.service = new ItineraryService();
		service.startRoutes("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
	}

	@Test
	public void distanceForItinerary_A_B_C_Test() {
		int distance = service.calculateDistanceOfItineray("A-B-C");
		assertEquals(9, distance);
	}

	@Test
	public void distanceForItinerary_A_D_Test() {
		int distance = service.calculateDistanceOfItineray("A-D");
		assertEquals(5, distance);
	}

	@Test
	public void distanceForItinerary_A_D_C_Test() {
		int distance = service.calculateDistanceOfItineray("A-D-C");
		assertEquals(13, distance);
	}

	@Test
	public void distanceForItinerary_A_E_B_C_D_Test() {
		int distance = service.calculateDistanceOfItineray("A-E-B-C-D");
		assertEquals(22, distance);
	}

	@Test(expected = NoSuchRouteException.class)
	public void shouldThrowExceptionNoRouteForItinerary_E_D_Test() {
		service.calculateDistanceOfItineray("A-E-D");
	}

	@Test
	public void distanceShouldBeUnder30Test() {
		int distance = service.calculateDistanceOfItineray("C-E-B-C-E-B-C-E-B-C");
		assertTrue(distance < 30);
	}

}

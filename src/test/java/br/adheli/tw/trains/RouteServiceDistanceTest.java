package br.adheli.tw.trains;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.adheli.tw.trains.exception.NoSuchRouteException;
import br.adheli.tw.trains.service.RouteService;

/**
 * Testing the distance method from RouteService class
 * @author adheli.tavares
 *
 */
public class RouteServiceDistanceTest {

	private RouteService service;

	/**
	 * Starts a list of routes for distance testing
	 */
	@Before
	public void setUp() {
		this.service = new RouteService();
		service.insertRoutes("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
	}

	@Test
	public void testDistance1() {
		int distance = service.distance("A-B-C");
		assertEquals(9, distance);
	}

	@Test
	public void testDistance2() {
		int distance = service.distance("A-D");
		assertEquals(5, distance);
	}

	@Test
	public void testDistance3() {
		int distance = service.distance("A-D-C");
		assertEquals(13, distance);
	}

	@Test
	public void testDistance4() {
		int distance = service.distance("A-E-B-C-D");
		assertEquals(22, distance);
	}

	@Test(expected = NoSuchRouteException.class)
	public void shouldThrowExceptionNoRouteForEDRoute() {
		service.distance("A-E-D");
	}

	@Test
	public void testDistanceUnder30() {
		int distance = service.distance("C-E-B-C-E-B-C-E-B-C");
		assertTrue(distance < 30);
	}

}

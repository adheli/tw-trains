package br.adheli.tw.trains;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.adheli.tw.trains.model.Route;
import br.adheli.tw.trains.service.RouteService;

/**
 * Testing the insertRoutes method from RouteService class
 * @author adheli.tavares
 *
 */
public class RouteServiceInsertTest {

	private RouteService service = new RouteService();

	/**
	 * Verifies if the route CE2 is inserted correctly
	 * Verifies if nine routes are inserted correctly
	 */
	@Test
	public void shouldInsertRoutesTest() {
		Route ce2 = new Route("CE2");
		List<Route> routes = service.readInRawRoutes("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");

		assertTrue(routes.size() == 9);
		assertTrue(routes.contains(ce2));
	}
	
	/**
	 * Verifies if routes without all parameters (city 1, city 2 and distance) cannot be inserted
	 */
	@Test
	public void shouldNotInsertRoutesWithoutAllParametersTest() {
		Route ce2 = new Route("CE2");
		List<Route> routes = service.readInRawRoutes("A 5, BC4, CD8, DC , DE6, AD5, CE2, EB3, AE10");

		assertTrue(routes.size() == 7);
		assertTrue(routes.contains(ce2));
	}
	
	/**
	 * Verifies if java IllegalArgumentException is issued when not passing a valid string of routes
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWithEmptyRoutesTest() {
		this.service.readInRawRoutes("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWithNullParameterTest() {
		this.service.readInRawRoutes(null);
	}
	
	/**
	 * Verifies if routes without all parameters (city 1, city 2 and distance) cannot be inserted
	 */
	@Test
	public void shouldUpdateRouteTest() {
		Route ce2 = new Route("CE2");
		List<Route> routes = service.readInRawRoutes("AB5, BC4, CD8, DC4, DE6, AD5, CE7, EB3, AE10");
		routes = service.readInRawRoutes("AB5, BC4, CD8, DC4, DE6, AD5, CE2, EB3, AE10");

		assertTrue(routes.size() == 9);
		assertTrue(routes.contains(ce2));
	}
}

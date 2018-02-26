package br.adheli.tw.trains;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.adheli.tw.trains.model.Route;
import br.adheli.tw.trains.service.RouteService;

public class RouteServiceInsertTest {

	private RouteService service = new RouteService();

	@Test
	public void testInsertRoutes() {
		Route ce2 = new Route("CE2");
		List<Route> routes = service.insertRoutes("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");

		assertTrue(routes.size() == 9);
		assertTrue(routes.contains(ce2));
	}
}

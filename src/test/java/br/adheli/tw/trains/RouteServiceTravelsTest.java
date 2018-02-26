package br.adheli.tw.trains;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.adheli.tw.trains.service.RouteService;

public class RouteServiceTravelsTest {

	private RouteService service;

	@Before
	public void setUp() {
		this.service = new RouteService();
		this.service.insertRoutes("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
	}

	@Test
	public void testHowManyTravelsCC3() {
		List<String> travels = this.service.makeTravels("C", "C", 3);
		
		assertEquals(2, travels.size());
	}

	@Test
	public void testHowManyTravelsAC4() {
		List<String> travels = this.service.makeTravels("A", "C", 4);
		
		assertEquals(3, travels.size());
	}

}

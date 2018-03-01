package br.adheli.tw.trains;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.adheli.tw.trains.service.ItineraryService;

public class ItineraryServiceFindItineryTest {

	private ItineraryService service;

	@Before
	public void setUp() {
		this.service = new ItineraryService();
		this.service.startRoutes("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
	}

	@Test
	public void howManyTravelsCC3Test() {
		List<String> travels = this.service.findItinerary("C", "C", 3);
		
		assertEquals(2, travels.size());
	}

	@Test
	public void howManyTravelsAC4Test() {
		List<String> travels = this.service.findItinerary("A", "C", 4);
		
		assertEquals(3, travels.size());
	}

}

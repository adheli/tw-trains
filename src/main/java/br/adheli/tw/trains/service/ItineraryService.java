package br.adheli.tw.trains.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.adheli.tw.trains.model.Route;

/**
 * 
 * @author adheli.tavares
 *
 */
public class ItineraryService {
	
	private RouteService routeService;
	
	public ItineraryService() {
		this.routeService = new RouteService();
	}
	
	public void startRoutes(String routes) {
		this.routeService.readInRawRoutes(routes);
	}

	// TODO - I didn't find a solution to get the route chain.
	public List<String> findItinerary(String cityStart, String cityEnd, int stops) {

		List<String> probRoutes = new ArrayList<>();

		return probRoutes;
	}

	public int calculateDistanceOfItineray(String itinerary) {
		int distance = 0;

		if (itinerary.isEmpty()) {
			throw new IllegalArgumentException(
					"The cities you need to calculate the distance between must be informed");
		} else {
			List<String> citiesList = Arrays.asList(itinerary.split("-"));

			for (String city : citiesList) {
				try {
					int index = citiesList.indexOf(city) + 1;
					distance += this.routeService.getRouteDistance(new Route(city, citiesList.get(index)));
				} catch (IndexOutOfBoundsException e) {
					break;
				}
			}
		}

		return distance;
	}
}
